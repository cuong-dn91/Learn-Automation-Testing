package pageObject.OrangeHRM.AdminPO;

import commons.BasePage;
import interfaces.WordPress.AdminUI.AdminLoginPageUI;
import org.openqa.selenium.WebDriver;
import pageObject.OrangeHRM.PageGenerator;

public class AdminLoginPO extends BasePage {
    private WebDriver driver;

    public AdminLoginPO(WebDriver driver) {
        this.driver = driver;
    }

    public AdminDashboardPO loginAccount(String username, String password) {
        waitForElementVisible(driver, AdminLoginPageUI.USERNAME_TEXTBOX);
        sendKeys(driver, AdminLoginPageUI.USERNAME_TEXTBOX, username);
        waitForElementVisible(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
        sendKeys(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);
        waitForElementVisible(driver, AdminLoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getAdminDashboardPage(driver);
    }
}
