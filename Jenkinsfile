pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Checkout the source code from the version control system
                checkout scm
            }
        }

        stage('Build and Test with Maven') {
            steps {
                script {
                    // Set up Maven
                    tool 'Maven'

                    // Run Maven command
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
