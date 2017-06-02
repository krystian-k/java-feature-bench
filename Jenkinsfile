#!groovy

pipeline {
	agent {
		label 'java'
	}

	stages {
        stage('JMH') {
			steps {
                sh './gradlew jmh -PbenchSpec="IntAdderBenchmark"'
			}
			post {
				success {
					archive('**/build/reports/jmh/human.txt')
				}
			}
		}
	}
}
