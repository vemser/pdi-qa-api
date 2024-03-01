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
                script {
                    bat "mvn -e clean test -Dmaven.test.failure.ignore=true"
                }
            }
        }
    }
}
