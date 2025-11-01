package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

@CucumberOptions(
        features = "src/test/java/features", // Path to your feature files
        glue = "stepdefinitions", // Path to your step definition classes
        plugin = {"pretty", "stepdefinitions.Hooks" },
                //"html:target/cucumber-reports/cucumber-html-report.html", "json:target/cucumber-reports/cucumber.json"},
        monochrome = true, // Makes the console output more readable
        tags = "@Test1", // Optionally specify tags to run specific scenarios/features
        dryRun = false // Set to true to check for un-implemented steps without executing
)
public class TestRunner extends AbstractTestNGCucumberTests {

   /* // Enables running scenarios in parallel if needed
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }*/

    @BeforeClass(alwaysRun = true)
    public void setUpClass() {
        System.out.println(">>> Test suite starting...");
    }

    @AfterClass(alwaysRun = true)
    public void tearDownClass() {
        System.out.println(">>> Test suite completed.");
    }

}