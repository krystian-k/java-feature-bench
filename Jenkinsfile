#!groovy

pipeline {
	agent {
		label 'java'
	}

	stages {
        stage('Build') {
			steps {
				dir('.') {
					gradlew('tasks')
				}
			}
		}

	}
}
