node {

  stage 'Checkout'
  	checkout scm
  stage 'Build'
  	sh 'mvn -f employees-app clean install'
  stage 'Start App'
	dir('target'){
		sh 'java -jar employees-app-1.0-SNAPSHOT-jar-with-dependencies.jar'
        } 	 
}
