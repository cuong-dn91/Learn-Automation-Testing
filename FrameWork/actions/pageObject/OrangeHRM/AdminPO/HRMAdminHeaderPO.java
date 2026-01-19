package pageObject.OrangeHRM.AdminPO;

import commons.BasePage;
import interfaces.OrangeHRM.AdminUI.HRMAdminHeaderPageUI;
import org.openqa.selenium.WebDriver;
import pageObject.OrangeHRM.HRMPageGenerator;
import pageObject.WordPress.PageGenerator;

public class HRMAdminHeaderPO extends BasePage {
    private WebDriver driver;

    public HRMAdminHeaderPO(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToProfileDropdown() {
        waitForElementClickable(driver, HRMAdminHeaderPageUI.HEADER_PROFILE_DROPDOWN);
        clickToElement(driver, HRMAdminHeaderPageUI.HEADER_PROFILE_DROPDOWN);
    }

    public HRMAdminLoginPO clickToLogoutMenu() {
        clickToProfileDropdown();
        waitForElementClickable(driver, HRMAdminHeaderPageUI.HEADER_PROFILE_DROPDOWN_LOGOUT_MENU);
        clickToElement(driver, HRMAdminHeaderPageUI.HEADER_PROFILE_DROPDOWN_LOGOUT_MENU);
        return HRMPageGenerator.getAdminLoginPage(driver);
    }
}
