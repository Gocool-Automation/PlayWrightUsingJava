package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    private final String adminLink = "oxd-text oxd-text--span oxd-main-menu-item--name";
    //private final String adminLink = "//a[@href='/web/index.php/admin/viewAdminModule']";
    private final String pimLink = "//a[@href='/web/index.php/pim/viewPimModule']";
    private final String timeLink = "//a[@href='/web/index.php/time/viewTimeModule']";


    public void clickTimeLink() {
        page.locator(timeLink).click();
    }

    public void clickAdminLink() {
        page.locator(adminLink).click();
    }
}
