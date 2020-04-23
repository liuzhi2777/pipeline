package com.mw

class AppMeta {

    def meta = [
            //  jar
            [
                    app: "feign-spring-boot-starter",
                    lang: 'jar',
                    git: 'http://gitlab.top.mw/starter/feign-spring-boot-starter.git'
            ],
            [
                    app: "redis-spring-boot-starter",
                    lang: 'jar',
                    git: 'http://gitlab.top.mw/starter/redis-spring-boot-starter.git'
            ],
            [
                    app: "mw-parent",
                    lang: 'jar',
                    git: 'http://gitlab.top.mw/mw-core/mw-parent.git'
            ],
            [
                    app: "mw-core-base",
                    lang: 'jar',
                    git: 'http://gitlab.top.mw/mw-core/mw-core-base.git'
            ],
            [
                    app: "mqcenter",
                    lang: 'jar',
                    git: 'http://gitlab.top.mw/base/mqcenter-spring-boot-starter.git'
            ],
            [
                    app: "public-pom",
                    lang: 'jar',
                    git: 'http://gitlab.top.mw/base/public-pom.git'
            ],
            
            //  distribution
            [
                    app: "distribution",
                    lang: 'java',
                    namespace: 'default',
                    artifact: 'distribution-service/target/distribution-service.jar',
                    git: 'http://gitlab.top.mw/distribution/distribution.git'
            ],
			
            //  production
            [
                    app: "production-base",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'production-base-service-provider/target/production-base-service.jar',
                    git: 'http://gitlab.top.mw/production-management/production-base.git'
            ],
            [
                    app: "production-task",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'production-task-service-provider/target/production-task-service.jar',
                    git: 'http://gitlab.top.mw/production-management/production-task.git'
            ],
            [
                    app: "mrp",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'mrp-service-provider/target/mrp-service.jar',
                    git: 'http://gitlab.top.mw/production-management/mrp.git'
            ],
			
            //  base
            [
                    app: "base",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'base-service/target/base-service.jar',
                    git: 'http://gitlab.top.mw/base/base.git'
            ],
            [
                    app: "gateway",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'gateway-service/target/gateway-service.jar',
                    git: 'http://gitlab.top.mw/base/gateway.git'
            ],
            [
                    app: "job",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'job-service/target/job-service.jar',
                    git: 'http://gitlab.top.mw/base/job.git'
            ],
            [
                    app: "msgcenter",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'msgcenter-service/target/msgcenter-service.jar',
                    git: 'http://gitlab.top.mw/base/msgcenter.git'
            ],
            [
                    app: "businessmsg",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'businessmsg-service/target/businessmsg-service.jar',
                    git: 'http://gitlab.top.mw/base/businessmsg.git'
            ],
            [
                    app: "point",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'point-service-provider/target/point-service-provider.jar',
                    git: 'http://gitlab.top.mw/salepoint/point.git'
            ],
			
            //  account
            [
                    app: "user-account",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'user-account-service/target/user-account-service.jar',
                    git: 'http://gitlab.top.mw/user-account/user-account.git'
            ],
			
            //  admincenter
            [
                    app: "admincenter-approval",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'admin-center-approval-service/target/admincenter-approval-server.jar',
                    git: 'http://gitlab.top.mw/adminCenter/pay-approval-center.git'
            ],
			[
                    app: "admincenter-intangible-assets",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'admincenter-intangible-assets-service/target/admincenter-intangible-assets-service.jar',
                    git: 'http://gitlab.top.mw/adminCenter/intangibleAssets.git'
            ],
			[
                    app: "admincenter-approval-manage",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'admincenter-approval-manage-service/target/admincenter-approval-manage-service.jar',
                    git: 'http://gitlab.top.mw/adminCenter/approval-manage.git'
            ],
			
			//  bill
		    [
                    app: "billcenter",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'bill-center-service/target/bill-center-service.jar',
                    git: 'http://gitlab.top.mw/bill-center/bill-center.git'
            ],
			
			//  finance
		    [
                    app: "finance",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'finance-service/target/finance-service.jar',
                    git: 'http://gitlab.top.mw/finance/finance-base.git'
            ],
		    [
                    app: "finance-attribute",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'finance-attribute-service/target/finance-attribute-service.jar',
                    git: 'http://gitlab.top.mw/finance/finance-attribute.git'
            ],
		    [
                    app: "finance-cashbank",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'finance-cashbank-service/target/finance-cashbank-service.jar',
                    git: 'http://gitlab.top.mw/finance/finance-cashBank.git'
            ],
		    [
                    app: "finance-costing",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'finance-costing-service/target/finance-costing-service.jar',
                    git: 'http://gitlab.top.mw/finance/finance-costing.git'
            ],
		    [
                    app: "finance-invoice",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'finance-invoice-service/target/finance-invoice-service.jar',
                    git: 'http://gitlab.top.mw/finance/finance-invoice.git'
            ],
		    [
                    app: "finance-profitallot",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'finance-profitallot-service/target/finance-profitallot-service.jar',
                    git: 'http://gitlab.top.mw/finance/finance-profitallot.git'
            ],
		    [
                    app: "finance-tax",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'finance-tax-service/target/finance-tax-service.jar',
                    git: 'http://gitlab.top.mw/finance/finance-tax.git'
            ],
		    [
                    app: "finance-cashier",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'finance-cashierAccount-service/target/finance-cashierAccount-service.jar',
                    git: 'http://gitlab.top.mw/finance/finance-cashierAccount.git'
            ],
		    [
                    app: "finance-obligation",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'finance-obligation-service/target/finance-obligation-service.jar',
                    git: 'http://gitlab.top.mw/finance/finance-obligation.git'
            ],
		    [
                    app: "finance-processproject",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'finance-profitallot-service/target/finance-profitallot-service.jar',
                    git: 'http://gitlab.top.mw/finance/finance-profitAllot.git'
            ],
		    [
                    app: "finance-settleaccounts",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'finance-settleaccounts-service/target/finance-settleaccounts-service.jar',
                    git: 'http://gitlab.top.mw/finance/finance-settleaccounts.git'
            ],
		    [
                    app: "finance-pay-receive",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'finance-pay-receive-service/target/finance-pay-receive-service.jar',
                    git: 'http://gitlab.top.mw/finance/finance-paymentRreceipts.git'
            ],
			
			//  hr
		    [
                    app: "hr-base",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'hr-base-service-provider/target/hr-base-service-provider.jar',
                    git: 'http://gitlab.top.mw/hr/hr-base.git'
            ],
		    [
                    app: "hr-assess",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'hr-assess-service-provider/target/hr-assess-service-provider.jar',
                    git: 'http://gitlab.top.mw/hr/hr-assess.git'
            ],
		    [
                    app: "hr-arrangework",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'hr-arrangework-service-provider/target/hr-arrangework-service-provider.jar',
                    git: 'http://gitlab.top.mw/hr/hr-arrangework.git'
            ],
		    [
                    app: "hr-business-events",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'hr-business-events-service-provider/target/hr-business-events-service-provider.jar',
                    git: 'http://gitlab.top.mw/hr/business-events.git'
            ],
		    
			//  invoicing
		    [
                    app: "invoicing-base",
                    lang: 'jar',
                    git: 'http://gitlab.top.mw/jinxiao/java/invoicing-base.git'
            ],
		    [
                    app: "invoicing-merchandise",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'invoicing-web-merchandise/target/invoicing-web-merchandise.jar',
                    git: 'http://gitlab.top.mw/jinxiao/java/invoicing-merchandise-provider.git'
            ],
		    [
                    app: "invoicing-order",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'invoicing-web-order/target/invoicing-web-order.jar',
                    git: 'http://gitlab.top.mw/jinxiao/java/invoicing-order-provider.git'
            ],
		    [
                    app: "invoicing-policy",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'invoicing-web-policy/target/invoicing-web-policy.jar',
                    git: 'http://gitlab.top.mw/jinxiao/java/invoicing-policy-provider.git'
            ],
		    [
                    app: "invoicing-simple",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'invoicing-web-simple/target/invoicing-web-simple.jar',
                    git: 'http://gitlab.top.mw/jinxiao/java/invoicing-simple-provider.git'
            ],
			
			//  person-plat
		    [
                    app: "person-plat-base",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'person-plat-base-service/target/person-plat-base-service.jar',
                    git: 'http://gitlab.top.mw/person-plat/person-plat-base.git'
            ],
			
			//  storage
		    [
                    app: "storage-input",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'storage-stockInput-service-provider/target/storage-input-service.jar',
                    git: 'http://gitlab.top.mw/storage/storage-stockInput.git'
            ],
		    [
                    app: "barcode",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'barcode-service-provider/target/barcode-service.jar',
                    git: 'http://gitlab.top.mw/storage/barcode.git'
            ],
		    [
                    app: "entrust-material",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'entrust-material-service-provider/target/entrust-material-service.jar',
                    git: 'http://gitlab.top.mw/storage/entrust-material.git'
            ],
		    [
                    app: "mw-storage-web",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'mw-storage-web/target/mw-storage-web.jar',
                    git: 'http://gitlab.top.mw/mw-surmax/mw-storage.git'
            ],
		    [
                    app: "storage-out",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'storage-out-service-provider/target/storage-out-service-provider.jar',
                    git: 'http://gitlab.top.mw/storage/storage-stockOut.git'
            ],
		    [
                    app: "storage-stock",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'storage-stock-service-provider/target/storage-stock-service.jar',
                    git: 'http://gitlab.top.mw/storage/storage-stock.git'
            ],
		    [
                    app: "storage-transport",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'storage-transport-service-provider/target/storage-transport-service-provider.jar',
                    git: 'http://gitlab.top.mw/storage/storage-transport.git'
            ],
			
			//  international			
		    [
                    app: "international",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'international-business-service-provider/target/international-business-service-provider.jar',
                    git: 'http://gitlab.top.mw/international-business/international.git'
            ],
			
			//  mw-logistics
		    [
                    app: "logistics-admin-web",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'logistics-admin-web/target/logistics-admin-web-1.0.0-SNAPSHOT.jar',
                    git: 'http://gitlab.top.mw/mw-logistics/logistics-admin.git'
            ],
		    [
                    app: "logistics-web",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'logistics-web/target/logistics-web-1.0.0-SNAPSHOT.jar',
                    git: 'http://gitlab.top.mw/mw-logistics/logistics-service.git'
            ],
			
			//  mw-microshop
		    [
                    app: "mw-microshop-bm",
                    lang: 'java',
                    namespace: 'dev',
                    artifact: 'mw-microshop-bm/target/mw-microshop-bm.jar',
                    git: 'http://gitlab.top.mw/mw-microshop/mw-microshop.git'
            ],
			
            //  front
            [
                    app: "surmax-admin-vue",
                    namespace: "dev",
                    lang: 'nodejs',
                    artifact: 'dist',
                    git: 'http://gitlab.top.mw/front/surmax-admin-vue.git'
            ],
            [
                    app: "surmax-manager-vue",
                    namespace: "dev",
                    lang: 'nodejs',
                    artifact: 'dist',
                    git: 'http://gitlab.top.mw/front/surmax-manager-vue.git'
            ],
            [
                    app: "components",
                    namespace: "dev",
                    lang: 'nodejs',
                    artifact: 'dist',
                    git: 'http://gitlab.top.mw/front/components.git'
            ],
            [
                    app: "logistics-admin-vue",
                    namespace: "dev",
                    lang: 'nodejs',
                    artifact: 'dist',
                    git: 'http://gitlab.top.mw/front/logistics-admin-vue.git'
            ],
            [
                    app: "logistics-h5-vue",
                    namespace: "dev",
                    lang: 'nodejs',
                    artifact: 'dist',
                    git: 'http://gitlab.top.mw/front/logistics-h5-vue.git'
            ],
            [
                    app: "mw-login-vue",
                    namespace: "dev",
                    lang: 'nodejs',
                    artifact: 'dist',
                    git: 'http://gitlab.top.mw/front/mw-login-vue.git'
            ],
            [
                    app: "pos-manager-vue",
                    namespace: "dev",
                    lang: 'nodejs',
                    artifact: 'dist',
                    git: 'http://gitlab.top.mw/front/pos-manager-vue.git'
            ],
            [
                    app: "supply-manager-vue",
                    namespace: "dev",
                    lang: 'nodejs',
                    artifact: 'dist',
                    git: 'http://gitlab.top.mw/front/supply-manager-vue.git'
            ],
            [
                    app: "surmax-manager-h5",
                    namespace: "dev",
                    lang: 'nodejs',
                    artifact: 'build',
                    git: 'http://gitlab.top.mw/front/surmax-manager-h5.git'
            ],
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
