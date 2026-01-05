package pageObject;

import commons.BasePage;
import interfaces.WordPress.LoginPageUI;
import org.openqa.selenium.WebDriver;
import pageObject.WordPress.PageGenerator;

public class LoginPageObject extends BasePage {
    WebDriver driver;

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public void inputDataToUsername(String username) {
        waitForElementVisible(driver, LoginPageUI.USERNAME_TEXTBOX);
        sendKeys(driver, LoginPageUI.USERNAME_TEXTBOX, username);
    }

    public void inputDataToPassword (String dataPassword) {
        waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
        sendKeys(driver, LoginPageUI.PASSWORD_TEXTBOX, dataPassword);
    }

    public HomePageObject clickToLoginButton () {
        waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
        clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
        return PageGenerator.getHomePage(driver);
    }
}
