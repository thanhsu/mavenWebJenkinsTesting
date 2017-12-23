pipeline {
    agent any

    stages {
        stage('Delivery') {
            steps {
                dir ('ver01-CICD') {
		    echo 'Deploying package...'
		    echo '== Clean port 8089'
	            sh 'nohup fuser -k 8089/tcp &'
                    echo '== Deploy package'
                    sh 'nohup java -jar target/Itrade-0.0.1-SNAPSHOT-fat.jar &' 
		}
		input message: 'Shutdown Webtrade (Force to stop now)?'
                sh 'nohup fuser -k 8089/tcp &'
            }
        }
    }
}
