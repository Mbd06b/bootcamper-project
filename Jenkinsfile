pipeline{

    agent any

    stages {

        stage ('Compile Stage') {

            steps {

                withMaven() {
                    sh 'mvn clean compile -fae'

                }

            }
        }
    stage ('Test Stage') {

            steps {

                withMaven() {
                    sh 'mvn test -fae'

                }

            }
        }


        stage ('Cucumber Reports') {

            steps {
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber.json",
                    jsonReportDirectory: 'target'

            }

        }

    }
    
    post {
	    always {
	      junit(
	        allowEmptyResults: true,
	        testResults: '**/test-reports/*.xml'
	      )
	    }
	 }

}