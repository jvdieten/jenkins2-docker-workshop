--To Build

docker build -t jenkins2:latest .

--To Start

docker run -d --name=jenkins-container -v /tmp/jenkins_home:/var/jenkins_home jenkins2:latest  

