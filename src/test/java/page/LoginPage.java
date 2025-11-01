package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;


public class LoginPage {
    private Page page;

    //Locators
    public final Locator loginPageTitle;
    public final Locator userNameTxtBox;
    public final Locator passwordTxtBox;
    public final Locator loginBtn;
    public final Locator loginError;


    public LoginPage(Page page) {
        this.page = page;

        //Locators
        this.userNameTxtBox = page.locator("input[name='username']");
        this.passwordTxtBox = page.locator("input[name='password']");
        this.loginBtn = page.locator("button[type='submit']");
        this.loginError = page.locator("//p[text()='Invalid credentials']");
        this.loginPageTitle = page.locator("//h5[@class='oxd-text oxd-text--h5 orangehrm-login-title']");
    }
    //Locators
    //public final String userNameTxtBox = "input[name='username']";
    //public final String passwordTxtBox = "input[name='password']";
    //public final String loginBtn = "button[type='submit']";
    //public final String loginErrorMsg = "//*[text()='Invalid credentials']";
}
