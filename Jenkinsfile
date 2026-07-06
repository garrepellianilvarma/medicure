pipeline {
    agent any

    tools {
        jdk 'jdk21'
        maven 'maven3'
    }

    environment {
        IMAGE_NAME = "anilvarma753/medicure:v1"
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/garrepellianilvarma/medicure.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Docker Build') {
            steps {
                sh 'docker build -t medicure:v1 .'
            }
        }

        stage('Docker Tag') {
            steps {
                sh 'docker tag medicure:v1 $IMAGE_NAME'
            }
        }

        stage('Docker Push') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'dockerhub',
                        usernameVariable: 'DOCKER_USER',
                        passwordVariable: 'DOCKER_PASS')]) {

                    sh '''
                    echo $DOCKER_PASS | docker login -u $DOCKER_USER --password-stdin
                    docker push $IMAGE_NAME
                    '''
                }
            }
        }

        stage('Deploy Container') {
            steps {
                sh '''
                docker rm -f medicure-app || true
                docker run -d -p 8081:8081 --name medicure-app $IMAGE_NAME
                '''
            }
        }
    }
}
