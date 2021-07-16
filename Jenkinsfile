node{
	stage('git checkout') {
		git 'https://github.com/vppmatt/paymentgateway'
	}
	stage('Build') {
         steps {
            sh 'mvn clean package'
         }
      }
}