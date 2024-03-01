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
    }
}
