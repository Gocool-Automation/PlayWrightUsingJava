package stepdefinitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.*;
import utilities.ExtentManager;
import utilities.ScreenshotUtil;

import java.util.HashMap;
import java.util.Map;


public class Hooks implements ConcurrentEventListener {

    public static ExtentReports extent;
    //public static ExtentTest test;
    //public static ExtentTest feature;
    //public static ExtentTest scenarioTest;
    public static Playwright playwright;
    public static Browser browser;
    public static Page page;
    public static BrowserContext context;

    private static final Map<String, ExtentTest> featureMap = new HashMap<>();
    private static final ThreadLocal<ExtentTest> scenarioTestInfo = new ThreadLocal<>();

    @Override
    public void setEventPublisher(EventPublisher publisher) {
        publisher.registerHandlerFor(TestSourceRead.class, this::handleTestSourceRead);
        publisher.registerHandlerFor(TestCaseStarted.class, this::handleTestCaseStarted);
        publisher.registerHandlerFor(TestStepFinished.class, this::handleStepFinished);
        publisher.registerHandlerFor(TestCaseFinished.class, this::handleTestCaseFinished);
    }

    private void handleTestSourceRead(TestSourceRead event) {
        extent = ExtentManager.getInstance();
        String featureName = event.getUri().getPath().substring(event.getUri().getPath().lastIndexOf("/") + 1);
        if (!featureMap.containsKey(featureName)) {
            ExtentTest feature = extent.createTest(featureName);
            featureMap.put(featureName, feature);
        }
    }

    private void handleTestCaseStarted(TestCaseStarted event) {
        String featureName = event.getTestCase().getUri().getPath()
                .substring(event.getTestCase().getUri().getPath().lastIndexOf("/") + 1);
        ExtentTest feature = featureMap.get(featureName);
        ExtentTest scenario = feature.createNode(event.getTestCase().getName());
        scenarioTestInfo.set(scenario);
        scenarioTestInfo.get().info("Test Started");
    }

    @Before
    public void setUp(Scenario scenario) {
        //Reporting
        //extent = ExtentManager.getInstance();
        //feature = extent.createTest("Feature: " + scenario.getUri());
        //scenarioTest = feature.createNode("Scenario: " + scenario.getName());
        //test = extent.createTest(scenario.getName());

        //Playwright Setup
        scenarioTestInfo.get().info("Launching Browser");
        //scenarioTest.info("Launching browser...");
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        page = browser.newPage();
        page.setDefaultTimeout(15000);
    }

    private void handleStepFinished(TestStepFinished event) {
        if (event.getTestStep() instanceof PickleStepTestStep) {
            PickleStepTestStep step = (PickleStepTestStep) event.getTestStep();
            String stepText = step.getStep().getKeyword() + step.getStep().getText();

            // 👇 Mask username/password patterns
            stepText = maskSensitiveData(stepText);

            switch (event.getResult().getStatus()) {
                case PASSED -> scenarioTestInfo.get().pass(stepText);
                case FAILED -> {
                    scenarioTestInfo.get().fail(stepText);
                    if (event.getResult().getError() != null)
                        scenarioTestInfo.get().fail(event.getResult().getError());
                }
                case SKIPPED -> scenarioTestInfo.get().skip(stepText);
                default -> scenarioTestInfo.get().info(stepText);
            }
        }
    }

    private String maskSensitiveData(String text) {
        if (text == null) return text;

        // Mask typical parameter names like password, pwd, secret, token
        text = text.replaceAll("(?i)(password|pwd|secret|token)\\s*\"[^\"]+\"", "$1 \"********\"");

        // Optional: mask emails or usernames partially
        text = text.replaceAll("([a-zA-Z0-9._%+-]+)@([a-zA-Z0-9.-]+)", "*****@$2");

        return text;
    }


    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            scenarioTestInfo.get().info("Test Failed");
            String screenshotPath = ScreenshotUtil.takeScreenshot(page, scenario.getName());
            //System.out.println("Screenshot Path = " + screenshotPath);
            String projectPath = System.getProperty("user.dir");
            String absolutePath = projectPath + "/" + screenshotPath;
            //System.out.println("Absolute Path = " + absolutePath);
            //scenarioTest.addScreenCaptureFromPath(absolutePath, "screenshot");
            scenarioTestInfo.get().addScreenCaptureFromPath(absolutePath, "screenshot");
        } else if (scenario.getStatus().toString().equalsIgnoreCase("passed")) {
            //scenarioTest.pass("Test Passed");
            scenarioTestInfo.get().info("Test Passed");
        } else {
            //scenarioTest.skip("Test Skipped");
            scenarioTestInfo.get().info("Test Skipped");
        }
        //extent.flush();
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
    }

    private void handleTestCaseFinished(TestCaseFinished event) {
        extent.flush();
    }
}

