#  Java & Gauge & Selenium

UI Test cases were implemented by using Gauge within BDD test methodology, Selenium, Java language and Maven framework.

# Requirement/s

Gauge path&variables

Java path&variables

Jenkins local

Calliope account

# Versions / Dependencies

Java: 17.03

Gauge: 1.4.3

Selenium: 3.141.59

Junit: 4.13.1

Apache-Maven: 3.8.4

Jenkins: 2.361.1


# Setup

Precondition: Ensure all required dependencies are installed

1: Java& Gauge and Maven have to be installed and configured path variables for Windows

2: Clone the repository

3: Install dependencies

$ gauge init java

4: Install Jenkins to run the tests in a CI/CD environment

$ Follow the steps in the article for Windows setup -> https://www.blazemeter.com/blog/how-to-install-jenkins-on-windows

$ Follow the steps in the article for Mac setup -> https://www.knowledgehut.com/blog/devops/install-jenkins-on-mac

5: Install Jenkins plugins in order to trigger for creating test results

$ Maven plugin 

$ Junit report plugin

# Run

Runs the test locally, below command triggers to run all test cases
``` mvn test ```

Runs the tests on Jenkins
``` java -jar jenkins-cli.jar -s http://localhost:8080/ -auth {{jenkins_username}}:{{jenkins_password}} build SpriteCloud ```

 
# Project Structure

All BDD Features (test cases) are stored in here.   

$ /specs  

Storage of static data (some constants) such as website base Url. Can be accessed by the following path

$ env/default/user.properties

Page helpers are stored in here. This is where custom Selenium commands locate

$ utils/BaseActions.java

All page related element selectors are stored in here.  

$ src/test/java/pageObjects

 
# Calliope
Here is the link to go to results in Calliope.pro

$ https://app.calliope.pro/profiles/4508

# Findings
- There might be a page to create tables or charts like in the Jira dashboards.

- Adding some comments relating to the report

- Viewing result history of the spesific test case
 

# Test Case Selection
- Login Scenario
I chose this scenario because login steps are the most important steps to access other important features of application

- Wait Scenario
These kind of cases are so valueble considering automating the test for an app because if the app has a good technical design you don't need to control each wait for a spesific test step. Implementing some common wait methods/functions is easier and managable for a well-developed application.

- Dynamic Table
I chose this one only to challenge myself. :) The values in the each cells were changing constantly and catching the aimed value was tricky.

# Future Tasks
The purpose of the enhancement tasks can be accomplish about following issues;
Gauge-Maven-Plugin has execution failure when test result has failed scenarios.This issue could be handled.
Report can be beatufied.

# Contribution

Feel free to contribute to this test automation case study.
