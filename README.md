# CodingChallenge
Sample UI automation of ebay site and few open APIs
This repo consists a customized automation framework for executing the test cases on web browser , 
the framework uses Serenity BDD libraries for integrating Jbehave, REST-Assured, Selenium and Appium.
This maven project demonstrates various styles of writing jbehave scenarios within Serenity BDD framework


Please Install below
> Install java
> Install brew or home-brew:
> Install Maven


Set up instructions :

1. Download and install IntelliJ Idea Community version 


2. Clone the below repository in IntelliJ Idea : https://github.com/vinodpasalkar/SampleWebTest/ (Just clone this project in InteliJ idea community Edition 
and Go to Menu > Build > Build Project Once the build is completed/compiled successfully)

3. Ensure you have maven installed in your system - command from terminal -> brew install maven

4. Install below IntelliJ plugins by going to below navigation

IntelliJ Idea > Menu > IntelliJ Idea > Preferences > Plugins > Marketplace 

Search below plugins one by one and install them 
>Cucumber for java 
>Gherkin
>Jbehave BDD Plugin
>Jbehave Support 


5. Running your first test

To execute a particular test by tag run below command on terminal by going to the project directory

mvn clean verify -Dmetafilter="+scenario name"

For e.g. In our framework to execute the onlinePurchase , Execute below command

mvn clean verify -Dmetafilter="+onlinePurchase"

Meta filtering the stories/scenario mvn clean verify -Dmetafilter="+SmokeTest" -- This command will run the scenarios with the tag, "SmokeTest" This way we can use this on CI-CD by tagging the test case under the different tags like regression , smoke , sanity etc...

To see the Results after execution

Go to /SampleWebTest/Reports/Today's date time For E.g the folder name will be "report - 09-11-2019_16-06-36" Every time you run a scenario or scenarios , it will generate the report folder with current date and time

Open index.html file in any browser to see the results.

Below are sample report snapshots


I have used serenity framework here.

Serenity documentation Below can be referred for a further reading on serenity libraries http://thucydides.info/docs/serenity-staging/

