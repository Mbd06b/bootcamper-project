pipeline{

    agent any

    stages {

        stage ('Compile Stage') {

            steps {

                withMaven() {
                    sh 'mvn clean install -fae'

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

}