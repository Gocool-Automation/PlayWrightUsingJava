package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    public HomePage(Page page) {
        this.page = page;
    }

    private final String timeLink = "//a[@href='/web/index.php/time/viewTimeModule']";

    public void clickTimeLink() {
        page.locator(timeLink).click();
    }
}
