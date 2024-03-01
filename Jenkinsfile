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
                    bat 'mvn -e clean test'
                }
            }
        }
        stage('Generate and Serve Allure Report') {
            steps {
                script {
                    bat "allure generate allure-results -o allure-report"
                   archiveArtifacts 'allure-report/**'
                }
            }
        }
    }
    post {
        always {
            allure(
                includeProperties: false,
                jdk: '',
                results: [[path: 'allure-results']]
            )
            script {
                def buildUrl = env.BUILD_URL
                def buildResult = currentBuild.currentResult
                def branchName = env.BRANCH_NAME
                def buildNumber = env.BUILD_NUMBER

                def message = "# TESTE Relatorio de Testes/API PDI\n"
               message += "**Branch:** docs/jenkins-test\n"
               message += "**Build:** ${buildNumber}\n"
               message += "**Status:** ${buildResult}\n"

            discordSend description: message,
                    webhookURL: "https://discord.com/api/webhooks/1212758842560090172/7aBSJN1WFHafMg8OQ8lbKcQyPoKC6NzgZCVcGWojZ_4CTZkzuo0LpenVGdx3kqRf80Hz"
            }
        }
    }
}
