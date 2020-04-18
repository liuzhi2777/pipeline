def call() {
    def flag = "${params.BUILD_ENV}" == 'dev'
    log.debug("is dev ${flag}")
    return flag
}