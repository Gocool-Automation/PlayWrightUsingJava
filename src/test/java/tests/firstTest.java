package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class firstTest extends BaseTest {

    @Test
    public void verifyTitle() {
        page.navigate("https://www.google.com/ncr");
        if (page.isVisible("button:has-text('Accept all')")) {
            page.click("button:has-text('Accept all')");
        }
        System.out.println("The page title is " + page.title());
    }
}
