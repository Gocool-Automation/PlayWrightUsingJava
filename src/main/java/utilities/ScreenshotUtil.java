package utilities;

import com.microsoft.playwright.Page;

import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {
    public static String takeScreenshot(Page page, String testName) {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String path = "test-output/screenshots/" + testName + "_" + timeStamp + ".jpg";
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get(path)).setFullPage(false));
        return path;
    }
}
