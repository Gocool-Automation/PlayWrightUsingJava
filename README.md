Executing a Test from suite:
Run from Command Line  mvn clean test -DsuiteXmlFile=testng.xml
Run from testng.xml file. Rt click → Run As → TestNG Suite  TestNG plugin must be added for this


Record a Login Test using Codegen:
Step 1 - Run Codegen from CLI – mvn exec:java -P run-cli -Dexec.args="codegen https://opensource-demo.orangehrmlive.com"
Step 2 - Record the login scenario and copy the java code in a new class LoginTest.java
Step 3 - Extend from BaseTest, Update @Test annotation from testng
Step 4 - Save and Run
Step 5 - Can also update the testng.xml file and run from command line
mvn clean test -DsuiteXmlFile=testng.xml

Or open the CodeGen using the following command in CLI - npx playwright codegen