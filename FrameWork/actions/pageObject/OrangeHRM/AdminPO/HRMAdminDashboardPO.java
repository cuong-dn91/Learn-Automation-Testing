package pageObject.OrangeHRM.AdminPO;

import org.openqa.selenium.WebDriver;

public class HRMAdminDashboardPO extends HRMAdminSidebarPO {
    private WebDriver driver;

    public HRMAdminDashboardPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }
}
