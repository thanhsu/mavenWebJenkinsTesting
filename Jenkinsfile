pipeline {
    agent any

    stages {
        stage('Delivery') {
            steps {
                dir ('ver01-CICD') {
		    echo 'Deploying package...'
		    echo '== Clean port 8089'
                    echo '== Deploy package'
					mvn install
					mvn clean
					mvn deploy
                    java -jar target/SocialNetworkSPlaces-0.0.1-SNAPSHOT.jar 
		}
		input message: 'Shutdown Webtrade (Force to stop now)?'
            }
        }
    }
}
