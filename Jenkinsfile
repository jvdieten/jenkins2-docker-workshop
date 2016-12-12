node {
  try{
      properties([buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '3', numToKeepStr: '3')), pipelineTriggers([])])

      stage 'Checkout'
        git 'https://github.com/jvdieten/jenkins2-docker-workshop.git'
      stage 'Build'
        sh 'mvn -f employees-app clean install'
      stage 'Start App'
        dir('employees-app/target'){
            sh 'nohup java -jar employees-app-1.0-SNAPSHOT-jar-with-dependencies.jar & echo $! > pid.txt'
        }
      stage 'Test'
        sh 'mvn -f employees-app/src/test verify -Dwebdriver.remote.url=http://hub:4444/wd/hub -Dwebdriver.remote.driver=phantomjs'

        publishHTML (target: [
            allowMissing: false,
            alwaysLinkToLastBuild: false,
            keepAll: true,
            reportDir: 'employees-app/src/test/target/site/serenity',
            reportFiles: 'index.html',
            reportName: "E2E Report"
        ])
      stage 'Destroy App'
        dir('employees-app/target'){
            sh 'kill -9 $(cat pid.txt)'
        }
  }catch(Exception ex){
    dir('employees-app/target'){
        sh 'kill -9 $(cat pid.txt)'
    }
  }
}