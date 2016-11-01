###To Build
```
docker build -t jenkins2:latest .
```

###To Start
```
docker run -d --name=jenkins-container -p 8080:8080 -v <system dir>:/var/jenkins_home jenkins2:latest  
```

###To Use

```
docker logs jenkins-container 
```
Go to <dockerIP>:8080 Fetch password from logs fill in and unlock. In admin screen click cancel because all plugins we need are installed via our Dockerfile
