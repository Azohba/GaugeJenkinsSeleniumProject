#Sprite Cloud Test Automation Framework

Prerequisite
JAVA
MAVEN
IDE (IntelliJ Idea / Eclipse)
Jenkins
Gauge

Local project setup:
Git clone repository to your local
Clone repository
Navigate to project root
cd <path.to.repo.root>
Verify Jenkins has launched successfully
URL: http://localhost:8080

Jenkins login
Username: onurt
Password: 123456oT
Usage
From intellij IDE:
Step 1: Every Spec can run dependently
Step 2: Right click and run
From CLI:
Step 1: Navigate to project root
Step 2: Run command - java -jar jenkins-cli.jar -s http://localhost:8080/ -auth onurt:546271oT build SpriteCloud
From Jenkins:
Step 1: Login to Jenkins (localhost:8080)
Step 2: Go into job
Step 3: Select build with parameters
Step 4: Select a option and run

*NOTE* Initial run may take up to 5 minutes to resolve dependencies
Reporting
Currently Calliope upload will only trigger automatically through Jenkins pipeline build

Calliope Dashboard
