jenkins: 
	@docker run -d --net=my-fancy-network --net-alias=jenkins --name=jenkins -p 9000:9000 -p 8080:8080 --env JAVA_OPTS=-Djenkins.install.runSetupWizard=false -v /tmp/jenkins_home:/var/jenkins_home jvdieten/alpine-jenkins2:latest
hub:
	@docker run -d -P --net=my-fancy-network --net-alias=hub --name=hub selenium/hub
node:
	@docker run -d --net=my-fancy-network --net-alias=node --name=node akeem/selenium-node-phantomjs

