Executing a Test from suite:
Run from Command Line  mvn clean test -DsuiteXmlFile=testng.xml
Run from testng.xml file. Rt click → Run As → TestNG Suite  TestNG plugin must be added for this


Record a Login Test using Codegen:
Step 1 - Run Codegen from CLI – mvn exec:java -P run-cli -Dexec.args="codegen https://opensource-demo.orangehrmlive.com"
Step 2 - Record the login scenario and copy the java code in a new class LoginTest.java
Step 3 - Extend from BaseTest, Update @Test annotation from testng
Step 4 - Save and Run
Step 5 - Can also update the testng.xml file and run from command line
mvn clean test -DsuiteXmlFile=E:\Learning\JavaAutomation\PlayWrightUsingJava\testng.xml

Or open the CodeGen using the following command in CLI - npx playwright codegen

CLI:
1. To run a test, navigate to the project directory and run the command - mvn clean test -DsuiteXmlFile=E:\Learning\JavaAutomation\PlayWrightUsingJava\testng.xml
2. mvn clean test
    cleans previous build results
    compiles and runs all @Test classes in src/test/java for running the full suite
    
3. mvn -Dtest=LoginTest test
    run a Specific Test Class
    LoginTest = class name (no .java)
    runs only LoginTest.java

4. mvn -Dtest=LoginTest#loginTest test
    run Specific Method in a Test Class
    Format: ClassName#methodName

5. mvn clean test -DsuiteXmlFile=testng.xml
    run Tests using testng.xml
    Good for running test groups, parallel tests, etc.

GitHub CLI Commands:
1. git config --global user.email "your github email"
2. git config --global user.name "your github password"
3. git init 
4. git add . 
5. git commit -m “my first commit” 
6. git remote add origin url-of-github-repository 
7. git branch -M main 
8. git push -u origin main