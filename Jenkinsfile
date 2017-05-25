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
		}

	}
}
