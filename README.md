## jenkins2-docker-workshop

Example project to play with Docker and Jenkins 2.0. The Docker directory 
has a Dockerfile with Jenkins 2.0 configured on it. To build the docker image manually 
have a look in the docker README.

If you just want to play with the new Jenkins you can grab the docker image from here:


###Exercise0

**To Pull Image From Docker**

`docker pull jvdieten/alpine-jenkins2`

**To Start Container**

`docker run -d -p 9000:9000 -p 8080:8080 --env JAVA_OPTS=-Djenkins.install.runSetupWizard=false -v <local mount dir>:/var/jenkins_home 
jvdieten/alpine-jenkins2:latest `


###Exercise1


Click **new Item** in the main menu and select Pipeline as Project. Fill in the comments

```
node {

    
   stage 'Preparation' 
   
   //Set discard old builds max 3 items max 3 days HINT look in Pipeline Syntax

   git 'https://github.com/jvdieten/jenkins2-docker-workshop.git'
   
   stage 'Build'

   //Build the employees app
   
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
```

###Exercise2

Because we are not monkey Testers we are going to replace the Monkey Test stage from pipeline script above with a automated e2e test. 
For this we will setup a selenium hub grid with docker and integrate E2E test (located in the employees-app/src/test folder) into your pipeline. Solve the comments.


We create a docker network to be able to communicate between containers jenkins/hub/node

```
docker network create my-fancy-network
```

Run the selenium hub

```
docker run -d -P --net=my-fancy-network --net-alias=hub --name=hub selenium/hub
```

Run the seleniumm phantomjs node
```
docker run -d --net=my-fancy-network --net-alias=node --name=node akeem/selenium-node-phantomjs
```

Remove jenkins container and spin up again
```
docker run -d --net=my-fancy-network --net-alias=jenkins --name=jenkins -p 9000:9000 -p 8080:8080 --env JAVA_OPTS=-Djenkins.install.runSetupWizard=false -v /tmp/jenkins_home:/var/jenkins_home jvdieten/alpine-jenkins2:latest
To run the tests 
```

```
sh 'mvn -f employees-app/src/test verify -Dwebdriver.remote.url=http://hub:4444/wd/hub -Dwebdriver.remote.driver=phantomjs'
```

//Publish the results of the test HINT html publisher plugin
