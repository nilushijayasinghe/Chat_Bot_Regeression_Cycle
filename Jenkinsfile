pipeline {
    agent any

    options{
        timestamps()}

    stages{
        stage('Compile Stage'){

            steps {

                sh 'mvn clean compile'
             }
        }

            stage('Testing stage'){
                steps {
                     sh 'mvn test'
                    }
                }

            stage ('Package stage'){
                steps{
                    sh 'mvn package'
                    }
                }

            }

         }