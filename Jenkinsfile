#!groovy

pipeline {
	agent {
		label 'java'
	}

	stages {
        stage('Build') {
			steps {
                sh './gradlew tasks'
			}
			post {
				success {
					archive('**/build/reports/jmh/human.txt')
				}
			}
		}
	}
}
