# CodingChallenge
Sample UI automation of ebay site and few open APIs
This repo consists a customized automation framework for executing the test cases on web browser , 
the framework uses Serenity BDD libraries for integrating Jbehave, REST-Assured, Selenium and Appium.
This maven project demonstrates various styles of writing jbehave scenarios within Serenity BDD framework


Please Install below
# Install java
# Install brew or home-brew:
# Install Maven


Set up instructions :

1. Download and install IntelliJ Idea Community version 

2. Clone the below repository in IntelliJ Idea : https://github.com/vinodpasalkar/CodingChallenge (Just clone this project in InteliJ idea community Edition 
and Go to Menu > Build > Build Project Once the build is completed/compiled successfully)

3. Ensure you have maven installed in your system - command from terminal -> brew install maven

4. Install below IntelliJ plugins by going to below navigation ( This will help in code navigation)

IntelliJ Idea > Menu > IntelliJ Idea > Preferences > Plugins > Marketplace 

Search below plugins one by one and install them 
>Cucumber for java 
>Gherkin
>Jbehave BDD Plugin
>Jbehave Support 


5. Running your first test

Please download the appropriate chromedriver file depending on your OS type and provide correct path for the same in the serenity.properties file.

To execute a particular test by tag run below command on terminal by going to the project directory

mvn clean verify -Dmetafilter="+scenario name"

For e.g. In our framework to execute the scenario 001 , Execute below command

mvn clean verify -Dmetafilter="+001"

Multiple scenarios can be run with below command:

mvn clean verify -Dmetafilter="+001 && +002 && +003"

Meta filtering the stories/scenario mvn clean verify -Dmetafilter="+SmokeTest" -- This command will run the scenarios with the tag, "SmokeTest" This way we can use this on CI-CD by tagging the test case under the different tags like regression , smoke , sanity etc...

To see the Results after execution

Go to /SampleWebTest/Reports/Today's date time For E.g the folder name will be "report - 09-11-2019_16-06-36" Every time you run a scenario or scenarios , it will generate the report folder with current date and time

Open index.html file in any browser to see the results.

Below are sample report snapshots

![Summary 1 screencapture-localhost-63342-websample-testsuite-Reports-report-01-12-2019-12-29-08-index-html-2019-12-01-11_31_21](https://user-images.githubusercontent.com/9302926/69921487-e697bb00-1489-11ea-99f8-6fb7339e5acc.png)

![Summary 2 screencapture-localhost-63342-websample-testsuite-Reports-report-01-12-2019-12-29-08-index-html-2019-12-01-11_31_32](https://user-images.githubusercontent.com/9302926/69921489-e8fa1500-1489-11ea-911e-2a3e837bfb25.png)

![Detailed Report screencapture-localhost-63342-websample-testsuite-Reports-report-01-12-2019-12-29-08-9d38dd95c0ef5363523b1afe6b113a16b3e9b8515a8fe9c16558c3d3b5e98e8b-html-2019-12-01-11_31_45](https://user-images.githubusercontent.com/9302926/69921491-edbec900-1489-11ea-97d2-fa96b052a1ff.png)

![API Test Detailed Report screencapture-localhost-63342-websample-testsuite-Reports-report-01-12-2019-15-43-49-4cace042654761c4b57dac21d0683de7dd8a290e6aa0fa4d36b481c727f0baa9-html-2019-12-01-14_45_02](https://user-images.githubusercontent.com/9302926/69921492-f1525000-1489-11ea-95f2-073c70be0574.png)


I have used serenity framework here.

Serenity documentation Below can be referred for a further reading on serenity libraries http://thucydides.info/docs/serenity-staging/

