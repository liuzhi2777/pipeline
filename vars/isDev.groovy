def call() {
    def flag = "${params.BUILD_ENV}" == 'dev'
    log.debug("is dev dev ${flag}")
    return flag
}