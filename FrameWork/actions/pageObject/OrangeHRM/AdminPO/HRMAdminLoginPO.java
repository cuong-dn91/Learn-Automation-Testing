package pageObject.OrangeHRM.AdminPO;

import commons.BasePage;
import interfaces.OrangeHRM.AdminUI.HRMAdminLoginPageUI;
import interfaces.WordPress.AdminUI.AdminLoginPageUI;
import org.openqa.selenium.WebDriver;
import pageObject.OrangeHRM.HRMPageGenerator;

public class HRMAdminLoginPO extends BasePage {
    private WebDriver driver;

    public HRMAdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public HRMAdminDashboardPO loginAccount(String username, String password) {
        waitForElementVisible(driver, HRMAdminLoginPageUI.USERNAME_TEXTBOX);
        sendKeys(driver, HRMAdminLoginPageUI.USERNAME_TEXTBOX, username);
        waitForElementVisible(driver, HRMAdminLoginPageUI.PASSWORD_TEXTBOX);
        sendKeys(driver, HRMAdminLoginPageUI.PASSWORD_TEXTBOX, password);
        waitForElementVisible(driver, HRMAdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, HRMAdminLoginPageUI.LOGIN_BUTTON);
        return HRMPageGenerator.getAdminDashboardPage(driver);
    }
}
