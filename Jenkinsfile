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
                    sh 'mvn -e clean test'
                }
            }
        }

        stage('Generate and Serve Allure Report') {
            steps {
                script {
                    tool 'allure-local'

                    sh "allure generate target/allure-results -o target/allure-report"

                    sh "allure open target/allure-report"
                }
            }
        }
    }
}
