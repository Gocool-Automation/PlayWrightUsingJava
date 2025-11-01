package stepdefinitions;


import com.microsoft.playwright.assertions.PlaywrightAssertions;
import io.cucumber.java.en.*;
import page.LoginPage;

import static stepdefinitions.Hooks.page;


public class LoginSteps {
    LoginPage loginPage = new LoginPage(page);


    @Given("user navigates to {string}")
    public void user_navigates_to(String url) {
        page.navigate(url);
    }

    @Then("user lands on Login page")
    public void users_lands_on_login_page() {
        PlaywrightAssertions.assertThat(loginPage.loginPageTitle).isVisible();
    }

    @When("user enters username {string} and password {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.userNameTxtBox.fill(username);
        loginPage.passwordTxtBox.fill(password);
    }

    @When("user clicks login button")
    public void user_clicks_login() {
        PlaywrightAssertions.assertThat(loginPage.loginBtn).isVisible();
        loginPage.loginBtn.click();
        //page.click(loginPage.loginBtn);
    }

    @Then("user should see the error message")
    public void user_see_login_error() {
        //String errorMsg = loginPage.loginError.innerText();
        //assert errorMsg.contains("Invalid");
        PlaywrightAssertions.assertThat(loginPage.loginError).isVisible();
        //page.isVisible();
    }

}
