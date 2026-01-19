package pageObject.OrangeHRM.AdminPO;

import interfaces.OrangeHRM.AdminUI.HRMAdminMyInfoPageUI;
import org.openqa.selenium.WebDriver;

public class HRMAdminMyInfoPO extends HRMAdminSidebarPO {
    private WebDriver driver;

    public HRMAdminMyInfoPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public String getEmployeeId() {
        waitForElementVisible(driver, HRMAdminMyInfoPageUI.PERSONAL_DETAILS_EMPLOYEE_ID);
        return getDOMProperty(driver, HRMAdminMyInfoPageUI.PERSONAL_DETAILS_EMPLOYEE_ID, "value");
    }
}
