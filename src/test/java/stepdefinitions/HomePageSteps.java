package stepdefinitions;

import com.microsoft.playwright.assertions.PlaywrightAssertions;
import io.cucumber.java.en.Then;
import page.HomePage;

import static stepdefinitions.Hooks.page;


public class HomePageSteps {
    HomePage homePage = new HomePage(page);

    @Then("user should see the homepage")
    public void user_on_dashboard() {

        PlaywrightAssertions.assertThat(homePage.dashboardHeader).isVisible();
    }

    @Then("user should see all the Homepage Links")
    public void user_verifies_homepage_links() {
        PlaywrightAssertions.assertThat(homePage.searchBox).isVisible();
        PlaywrightAssertions.assertThat(homePage.adminLink).isVisible();
        PlaywrightAssertions.assertThat(homePage.pimLink).isVisible();
        PlaywrightAssertions.assertThat(homePage.leaveLink).isVisible();
        PlaywrightAssertions.assertThat(homePage.timeLink).isVisible();
        PlaywrightAssertions.assertThat(homePage.recruitLink).isVisible();
        PlaywrightAssertions.assertThat(homePage.myInfoLink).isVisible();
        PlaywrightAssertions.assertThat(homePage.performanceLink).isVisible();
        PlaywrightAssertions.assertThat(homePage.directoryLink).isVisible();
        PlaywrightAssertions.assertThat(homePage.maintenanceLink).isVisible();
        PlaywrightAssertions.assertThat(homePage.claimLink).isVisible();
        PlaywrightAssertions.assertThat(homePage.buzzLink).isVisible();
    }
}
