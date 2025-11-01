package page;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class HomePage {
    private Page page;

    //Locators
    public final Locator dashboardHeader;
    public final Locator searchBox;
    public final Locator adminLink;
    public final Locator pimLink;
    public final Locator leaveLink;
    public final Locator timeLink;
    public final Locator recruitLink;
    public final Locator myInfoLink;
    public final Locator performanceLink;
    public final Locator directoryLink;
    public final Locator maintenanceLink;
    public final Locator claimLink;
    public final Locator buzzLink;

    public HomePage(Page page) {
        this.page = page;

        //Locators
        this.dashboardHeader = page.locator("//h6[text()='Dashboard']");
        this.searchBox = page.locator("//input[@class='oxd-input oxd-input--active']");
        this.adminLink = page.locator("//a[@href='/web/index.php/admin/viewAdminModule']");
        this.pimLink = page.locator("//a[@href='/web/index.php/pim/viewPimModule']");
        this.leaveLink = page.locator("//a[@href='/web/index.php/leave/viewLeaveModule']");
        this.timeLink = page.locator("//a[@href='/web/index.php/time/viewTimeModule']");
        this.recruitLink = page.locator("//a[@href='/web/index.php/recruitment/viewRecruitmentModule']");
        this.myInfoLink = page.locator("//a[@href='/web/index.php/pim/viewMyDetails']");
        this.performanceLink = page.locator("//a[@href='/web/index.php/performance/viewPerformanceModule']");
        this.directoryLink = page.locator("//a[@href='/web/index.php/directory/viewDirectory']");
        this.maintenanceLink = page.locator("//a[@href='/web/index.php/maintenance/viewMaintenanceModule']");
        this.claimLink = page.locator("//a[@href='/web/index.php/claim/viewClaimModule']");
        this.buzzLink = page.locator("//a[@href='/web/index.php/buzz/viewBuzz']");

    }

}
