node{
	stage('git checkout') {
		git branch: 'main', url: 'https://github.com/vppmatt/paymentgateway'
	}
	stage('Build') {
		def mvnHome = tool name: 'maven-3.8.1', type: 'maven'
            sh "${mvnHome}/bin/mvn clean package"
      }
     stage('Deploy') {
		def server_port = 8001
		def jar_file = 'paymentgateway'
		def props_file = 'application.live.properties'

		sh "JENKINS_NODE_COOKIE=dontKillMe /home/ec2-user/deploy.sh ${server_port} ${jar_file} ${props_file}"
      }
}
