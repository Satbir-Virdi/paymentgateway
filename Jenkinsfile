node{
	stage('git checkout') {
		git branch: 'main', url: 'https://github.com/vppmatt/paymentgateway'
	}
	stage('Build') {
		def mvnHome = tool name: 'maven-3.8.1', type: 'maven'
            sh "${mvnHome}/build/mvn clean package"
      }
}