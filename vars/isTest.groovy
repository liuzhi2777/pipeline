def call() {
    def flag = "${params.BUILD_BRANCH}" == 'test'
    return flag
}