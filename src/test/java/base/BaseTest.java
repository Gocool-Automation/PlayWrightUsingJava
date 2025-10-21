package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.ExtentManager;
import utilities.ScreenshotUtil;

import java.lang.reflect.Method;

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void setUp(Method method) {
        //Reporting
        extent = ExtentManager.getInstance();
        test = extent.createTest(method.getName());

        //Playwright Setup
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        page = browser.newPage();
        page.setDefaultTimeout(5000);
    }

    @AfterMethod
    public void tearDown (ITestResult result) {
        if(result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
            String screenshotPath = ScreenshotUtil.takeScreenshot(page,result.getName());
            test.addScreenCaptureFromPath(screenshotPath,"Screenshots");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else {
            test.skip("Test Skipped");
        }
        extent.flush();
        if(browser != null) browser.close();
        if(playwright != null) playwright.close();
    }
}
