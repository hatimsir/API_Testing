READ ME

Project information:

This project created in Java (with RestAssured) to test below API

https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false


Requirement :

Below are the criteria which tested using this automation and also basic API related checks for example response code, status line and important headers values are validated:

1. Name = "Carbon credits"

2. CanRelist = true

3. The Promotions element with Name = "Gallery" has a Description that contains the text "2x larger image"


Pre-requisite

Below tools/softwares should be installed/configured on your machine

- Operating System : Windows (10 recommended)

- Eclipse IDE for Java EE Developers (neon version recommended)

- Java (JDK 12 and JRE 1.8 recommended)

- Maven

- TestNG - TestNG should be installed in eclipse

- GIT (version 2.24 recommended)

GIT URL of Project - https://github.com/hatimsir/API_Testing.git


How to setup this automation project/code

Below is the step by step process to setup the project using Git Bash command prompt (using git clone command)

step 1 : Open Eclipse and go to Window-->Preferences. On left hand side of window you should see Maven and TestNG options. This confirms that both are installed

step 2 : If TestNG option is available then ignore this step. If missing then to install TestNG, in Eclipse go to Help-->Install New Software and enter URL "http://dl.bintray.com/testng-team/testng-eclipse-release/"

step 3 : Go to Eclipse workspace location and right click and select option "Git Bash Here". A git bash command prompt should open

step 4 : On command prompt type command "git init" and click enter. An empty repository should be initialized

step 5 : Now enter command "git clone https://github.com/hatimsir/API_Testing.git"

step 6 : Restart eclipse

step 7 : In Eclipse go to File-->Import-->Git-->Projects from Git and click Next

step 8 : select existing local repository and click Next

step 9 : click Add button and browse and select folder where cloning done in step 5

step 10 : Select checkbox against repository name and click Finish and click Next

step 11: Select option "Import existing Eclipse projects" and click "Next" and then click "Finish"

step 12 : A project in Project Explorer will be added



Steps to run the project or individual test cases

step 13 : To run all test cases in one go - under Project there is file named "testng.xml" right click on file and select Run As-->TestNG Suite

step 14 : To run individual test case expand folder named "com.API_Testing.TestCases"

step 15 : Select the test case you want to run and right click Run As-->TestNG Test

step 16 : Output will be displayed on Console

step 17 : To see TestNG run report go to "test-output" folder location in your computer and open "index.html" and "emailable-report.html" in chrome or IE browser



Test Cases Information:

Test Case 1, 2 and 3 are basic checks related to API and generally performed before actually test API body to ensure API response is being received and headers are correct

Test 4, 5 and 6 are actually checking API response Json payload based on Acceptance Criteria mentioned in requirement section
