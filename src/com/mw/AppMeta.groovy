package com.mw

class AppMeta {

    def meta = [
            [
                    app: "feign-spring-boot-starter",
                    lang: 'jar',
                    git: 'https://github.com/mogu1986/feign-spring-boot-starter.git'
            ],
            [
                    app: "redis-spring-boot-starter",
                    lang: 'jar',
                    git: 'https://github.com/mogu1986/redis-spring-boot-starter.git'
            ],
            [
                    app: "framework-parent",
                    lang: 'jar',
                    git: 'https://github.com/mogu1986/framework-parent.git'
            ],
            [
                    app: "distribution",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'distribution-service/target/distribution-service.jar',
                    git: 'http://gitlab.top.mw/distribution/distribution.git'
            ],
            [
                    app: "point",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'point-service-provider/target/point-service-provider.jar',
                    git: 'http://gitlab.top.mw/salepoint/point.git'
            ],
            //  portal-ui
            [
                    app: "portal-ui",
                    namespace: "frame",
                    lang: 'nodejs',
                    group: 'vue',
                    appPort: 80,
                    artifact: 'dist',
                    git: 'http://gitlab.shixhlocal.com/frame/portal-ui.git',
                    run: 'docker'
            ]
    ]

    def getMeta(String app) {
        def result = meta.find { value ->

            if (value.app.equals(app)) {
                return value
            }
            return null
        }
        return result
    }

    def getNamespace(String app) {
        def meta = this.getMeta(app)
        if (meta == null) {
            return null
        }
        return meta.get('namespace')
    }

    def getJavaOpts(Map map, String env) {
        def optsMap = map.get('javaOpts')
        def opts = optsMap.get(env)
        map.put('javaOpts', opts)
    }

    def getEnv(String env, String branch) {
        if (env.equals("dev")) {
            return branch
        }
        return "release"
    }

    def getStr(String json) {
        def jsonSlpuer = new groovy.json.JsonSlurperClassic()
        def rs = jsonSlpuer.parseText(json)
        return rs
    }

}