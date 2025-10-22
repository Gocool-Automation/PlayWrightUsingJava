package tests;

import base.BaseTest;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.testng.SkipException;
import org.testng.annotations.Test;
import page.HomePage;
import page.LoginPage;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest1() {
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);

        test.info("Loading the Application");
        loginPage.goTo();

        test.info("Entering Username");
        loginPage.enterUserName("Admin");

        test.info("Entering Password");
        loginPage.enterPassword("admin123");

        test.info("Clicking Logging button");
        loginPage.clickLogin();

        test.info("Asserting all the Dashboard page elements");
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Admin"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("PIM"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Leave"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Time"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Recruitment"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My Info"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Performance"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Directory"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Maintenance"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Claim"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Buzz"))).isVisible();

        test.info("Clicking Time Link");
        homePage.clickTimeLink();
    }

    @Test
    public void loginTest2() {
        test.skip("Skill the test");
        throw new SkipException("Skipping this test");
    }

    @Test
    public void loginTest3() {
        LoginPage loginPage = new LoginPage(page);
        HomePage homePage = new HomePage(page);

        test.info("Loading the Application");
        loginPage.goTo();

        test.info("Entering Username");
        loginPage.enterUserName("Admin");

        test.info("Entering Password");
        loginPage.enterPassword("admin123");

        test.info("Clicking Logging button");
        loginPage.clickLogin();

        test.info("Asserting all the Dashboard page elements");
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Admin"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("PIM"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Leave"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Time"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Recruitment"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("My Info"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Performance"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Dashboard"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Directory"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Maintenance"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Claim"))).isVisible();
        assertThat(page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Buzz"))).isVisible();

        test.info("Clicking Admin Link");
        homePage.clickAdminLink();
    }
}
