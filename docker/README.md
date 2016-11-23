##Exercise
Build a docker image containing Jenkins2.0 with maven with a Dockerfile.

###To Build

```
docker build -t jenkins2:latest .
```

###To Start

```
docker run -d --name=jenkins-container -p 8080:8080 -v <system dir>:/var/jenkins_home jenkins2:latest 
 
On Windows, mount directories using:
 
docker run -v c:\<path>:/c:\<container path>
```

