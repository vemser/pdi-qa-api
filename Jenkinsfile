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
                    sh 'mvn -e clean test'
                }
            }
        }
        stage('Publish Allure Report') {
                   steps {
                       script {
                           bat 'allure generate allure-results -o allure-report'


                           archiveArtifacts 'allure-report/**'
                       }
                   }
               }

    }
}
