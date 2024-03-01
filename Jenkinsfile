pipeline {
    agent any

    stages {

        stage('Hello world') {
            steps {
                script{
                    bat 'mvn -e clean test -Dmaven.test.failure.ignore=true'
                }
            }
        }

        // ...
    }
}