pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test with Maven') {
            steps {
                script {
                    bat 'mvn test'
                }
            }
        }
        stage('Generate and Serve Allure Report') {
            steps {
                script {
                    bat "allure generate allure-results -o allure-report"

                    bat "allure open allure-report"
                }
            }
        }
    }
}
