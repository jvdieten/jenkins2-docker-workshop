## jenkins2-docker-workshop

Example project to play with Docker and Jenkins 2.0. The Docker directory 
has a Dockerfile with Jenkins 2.0 configured on it. To build the docker image manually 
have a look in the docker README.

If you just want to play with the new Jenkins you can grab the docker image from here:

**To Pull Image**

`docker pull jvdieten/alpine-jenkins2`

**To Start Container**

`docker run -d -p 9000:9000 -p 8080:8080 -v <local mount dir>:/var/jenkins_home 
jvdieten/alpine-jenkins2:latest `


###Exercise

Go to < DockerIP >:8080 Fetch password from container log output, fill in and unlock. 
In admin screen click cancel because all plugins we need are installed via our plugins.txt

Click **new Item** in the main menu and select Pipeline as Project.

```node {
   def mvnHome
   stage('Preparation') { // for display purposes
      git 'https://github.com/jvdieten/jenkins2-docker-workshop.git'
   }
   
   //Build the employees app
   
   //Run the employees app
   
   //E2E Test the employees app
   
   //Archive Results
   
   //Release
   
}
```
