node{
	stage('git checkout') {
		git branch: 'main', url: 'https://github.com/vppmatt/paymentgateway'
	}
	stage('Build') {
            sh 'mvn clean package'
      }
}