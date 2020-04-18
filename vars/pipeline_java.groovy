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
            timeout(time: 20, unit: 'MINUTES')
        }

        environment {
            APP = "${map.app}"
            LANG = "${map.lang}"
            APP_PORT = "${map.appPort}"
            GROUP= "${map.group}"
            ARTIFACT = "${map.artifact}"
            NS = "${map.namespace}"

//            PORTAL_TOKEN = credentials("portal")

            IMAGE_NAME = "${HARBOR}/library/${JOB_NAME}:${BUILD_ID}"
        }

        parameters {
            choice(name: 'BUILD_ENV', choices: 'dev\ntest\nuat', description: '请选择部署环境:')
            gitParameter(branchFilter: 'origin/(.*)', defaultValue: 'dev', name: 'BUILD_BRANCH', type: 'PT_BRANCH', description: '请选择分支(该参数只在开发环境有效):', useRepository: "${map.git}")
        }

        stages {

            stage('认证') {
                when {
                    anyOf {
                        environment name: 'BUILD_ENV', value: 'test'
                        environment name: 'BUILD_ENV', value: 'uat'
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
                        log.debug("部署环境: ${params.BUILD_ENV}")
                        log.debug("选择的分支: ${params.BUILD_BRANCH}")
                        log.debug("App 元数据: ${map}")
                        def br = new com.sxh.AppMeta().getEnv("${params.BUILD_ENV}", "${params.BUILD_BRANCH}")
                        log.debug("br: ${br}")
                        git branch: br, credentialsId: 'gitlab', url: map.git
                    }
                }
            }

            stage('编译') {
                steps {
                    script {
                        mvn { settings ->
                            def cmd = isDev() ? 'package' : 'deploy'
                            sh "mvn -s ${settings} clean ${cmd} -B -Dfile.encoding=UTF-8 -Dmaven.test.skip=true -U"
                        }
                    }
                }
            }

            stage('Sonar分析') {
                when {
                    expression {
                        return isDev()
                    }
                }
                steps {
                    script {
                        withSonarQubeEnv('sonar'){
                            docker.image('mercuriete/sonar-scanner:3.2.0.1227').inside('-v /root/.sonar:/root/.sonar') {
                                sh "sonar-scanner -Dsonar.host.url=${SONAR_HOST_URL} -Dsonar.login=${SONAR_AUTH_TOKEN}  -Dsonar.projectKey=${env.APP} -Dsonar.projectName=${env.APP} -Dsonar.sources=. -Dsonar.java.binaries=."
                            }
                        }
                    }
                }
            }

            stage('单元测试') {
                when {
                    expression {
                        return false
                    }
                }
                steps {
                    allure([
                        disabled: false,
                        includeProperties: false,
                        jdk: '',
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'output/allure']]
                    ])
                }
            }

            stage('自动化测试') {
                failFast true
                parallel {
                    stage('UI自动化测试') {
                        steps {
                            echo "并行1"
                        }
                    }
                    stage('性能自动化测试') {
                        steps {
                            echo "并行二"
                        }
                    }
                    stage('接口自动化测试') {
                        steps {
                            echo "In stage Nested 1 within Branch C"
                        }
                    }
                }
            }

            stage('推送镜像') {
                steps {
                    script {
                        configFileProvider([configFile(fileId: 'dockerfile', variable: 'DOCKER_FILE')]) {
                            docker.withRegistry("$HARBOR_URL", "harbor") {
                                def app = docker.build("$IMAGE_NAME", "--no-cache --build-arg JAR_PATH=${ARTIFACT} --build-arg JAR_NAME=${APP} -f ${DOCKER_FILE} .")
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
                        def response = httpRequest(
                            url: "${env.JENKINS_URL}/view/PRD/job/aliyun-harbor/buildWithParameters?token=${env.PORTAL_TOKEN}&app=${env.APP}&imageId=${BUILD_ID}",
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