pipeline {
    agent any
    stage('Checkout') {
           steps {
               script {
                   checkout scm
               }
           }
    }

    stages {
        stage('Hello world') {
            steps {
                script{
                    bat 'mvn -e clean test -Dmaven.test.failure.ignore=true'
                }
            }
        }
    }
}