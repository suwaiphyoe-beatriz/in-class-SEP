pipeline {
    agent any

    tools {
        maven 'Maven 3'  
    }

    environment {
        DOCKER_IMAGE = 'suph03/speedconverter:latest'
    }

    stages {

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Generate JaCoCo Report') {
            steps {
                sh 'mvn jacoco:report'
            }
        }

        stage('Publish Test Results') {
            steps {
                junit 'target/surefire-reports/*.xml'
            }
        }

        stage('Publish Coverage Report') {
            steps {
                jacoco(
                    execPattern: '**/target/jacoco.exec',
                    classPattern: '**/target/classes',
                    sourcePattern: '**/src/main/java'
                )
            }
        }

        stage('Build Docker Image') {
            steps {
                sh '/usr/local/bin/docker build -t suph03/speedconverter:latest .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([usernamePassword(
                    credentialsId: 'docker-hub',
                    usernameVariable: 'DOCKER_USER',
                    passwordVariable: 'DOCKER_PASS'
                )]) {
                    sh '/usr/local/bin/docker login -u $DOCKER_USER -p $DOCKER_PASS'
                    sh '/usr/local/bin/docker push suph03/speedconverter:latest'
                }
            }
        }
    }
}
