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
                    def mavenHome = tool 'maven 3.9.3'
                    def mavenCMD = "${mavenHome}/bin/mvn"

                    sh "${mavenCMD} -e clean test -Dmaven.test.failure.ignore=true"
                }
            }
        }
    }
}
