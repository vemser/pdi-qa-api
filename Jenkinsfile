pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build test maven') {
            steps {
                tool 'Maven'

                script {
                    def mavenHome = tool 'Maven'
                    def mavenCMD = "${mavenHome}/bin/mvn"

                    sh "${mavenCMD} -e clean test -Dmaven.test.failure.ignore=true"
                }
            }
        }
    }
}
