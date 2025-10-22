package page;

import com.microsoft.playwright.Page;

public class LoginPage {
    private Page page;

    //Constructor
    public LoginPage(Page page) {
        this.page = page;
    }

    //Locators
    private final String userNameTxtBox = "input[name='username']";
    private final String passwordTxtBox = "input[name='password']";
    private final String loginBtn = "button[type='submit']";

    //MethodDefinition
    public void goTo() {
        page.navigate("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    public void enterUserName(String username) {
        page.fill(userNameTxtBox, username);
    }

    public void enterPassword(String password) {
        page.fill(passwordTxtBox, password);
    }

    public void clickLogin() {
        //page.click(loginBtn);
        page.locator(loginBtn).click();
    }
}
