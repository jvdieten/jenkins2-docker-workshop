node {
  stage 'Checkout'
  	checkout scm
  stage 'Build'
  	sh 'mvn -f employees-app clean install'
  stage 'Start App'
	dir('employees-app/target'){
		sh 'nohup java -jar employees-app-1.0-SNAPSHOT-jar-with-dependencies.jar & echo $! > pid.txt'
    }
  stage 'Monkey Test'
	input 'Ready to go?'
  stage 'Destroy App'
        dir('employees-app/target'){
		sh 'kill -9 $(cat pid.txt)'
	} 
}
