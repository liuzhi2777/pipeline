/*
*  Description: java pipeline as code
*  Date: 2019-04-23 16:14
*  Author: gaowei
*/
def call(Map map) {
    pipeline {

        agent {
            label 'swarm'
        }

        options {
            buildDiscarder(logRotator(numToKeepStr: '50'))
            disableConcurrentBuilds()
            timeout(time: 30, unit: 'MINUTES')
        }

        environment {
            APP = "${map.app}"
            LANG = "${map.lang}"

            ARTIFACT = "${map.artifact}"
//            PORTAL_TOKEN = credentials("portal")

            IMAGE_NAME = "${HARBOR}/library/${JOB_NAME}:${BUILD_ID}"
        }

        parameters {
            choice(name: 'BUILD_ENV', choices: 'dev\ntest\nuat', description: '请选择部署环境:')
            choice(name: 'BUILD_BRANCH', choices: 'dev\nrelease', description: '请选择分支:')
        }

        stages {

            stage('输入密钥') {
                when {
                    expression {
                        return !isDev()
                    }
                }
                steps {
                    auth()
                }
            }

            stage('清空目录') {
                steps {
                    deleteDir()
                }
            }

            stage('拉取代码') {
                steps {
                    script {
                        log.debug("选择的分支: ${params.BUILD_BRANCH}")
                        log.debug("部署环境: ${params.BUILD_ENV}")
                        git branch: params.BUILD_BRANCH, credentialsId: 'gitlab', url: map.git
                    }
                }
            }

            stage('拉取配置') {
                steps {
                    script {
                        sh "git clone -b ${params.BUILD_ENV} http://gitlab.top.mw/devops/config.git mw_config"
                        sh "mv mw_config/${env.APP}/nginx.conf ./"
                        sh "rm -rf mw_config"
                        sh "ls -lh"
                    }
                }
            }

            stage('编译') {
                steps {
                    nodejs('NODEJS') {
                        sh "yarn install"
                        sh "yarn run build --mode ${params.BUILD_ENV}"
                        sh "ls -lh"
                    }
                }
            }

            stage('推送镜像') {
                steps {
                    script {
                        docker.withRegistry("$HARBOR_URL", "harbor") {
                            configFileProvider([configFile(fileId: 'dockerfile_nodejs', variable: 'DOCKER_FILE')]) {
                                def app = docker.build("$IMAGE_NAME", "--no-cache --build-arg ARTIFACT_NAME=${ARTIFACT} -f ${DOCKER_FILE} .")
                                app.push()
                            }
                        }
                        sh "docker rmi -f $IMAGE_NAME"
                    }
                }
            }

            stage("K8S部署") {
                steps{
                    configFileProvider([configFile(fileId: "${params.BUILD_ENV}-k8s-config", variable: 'config')]) {
                        sh "docker run --rm -v ${config}:/.kube/config bitnami/kubectl:1.15 -n ${env.NS} set image deployment ${env.APP} ${env.APP}=${IMAGE_NAME}"
                    }
                }
            }

            stage('同步阿里云') {
                when {
                    expression {
                        return isUat()
                    }
                }
                steps {
                    script {
                        def url = "${env.JENKINS_URL}/view/PRD/job/aliyun-harbor-nodejs/buildWithParameters?token=${env.PORTAL_TOKEN}&app=${env.APP}"
                        log.debug(" url = ${url}")

                        def response = httpRequest(
                            url: "${url}",
                            httpMode: 'GET'
                        )
                        println('Status: '+response.status)
                        println('Response: '+response.content)
                    }
                }
            }


        }
    }
}