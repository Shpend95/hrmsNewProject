pipeline {
    agent any
    tools { maven 'Maven3' }
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/Shpend95/hrmsNewProject.git'
            }
        }
        stage('Build & Test') {
            steps {
                sh 'mvn clean test -Dtest=runners.SmokeRunner'
            }
        }
    }
   post {
  always {
    junit 'target/cucumber-reports/*.xml'
  }
}

}
