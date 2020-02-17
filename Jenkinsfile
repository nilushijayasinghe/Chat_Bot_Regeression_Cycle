pipeline {
    agent any
    stages{
        stage('Compile Stage'){
            steps {
                sh 'git clone https://github.com/nilushijayasinghe/Chat_Bot_Regeression_Cycle.git chat_bot_rc'
                sh 'cd chat_bot_rc'
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