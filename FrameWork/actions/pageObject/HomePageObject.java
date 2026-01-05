package pageObject;

import commons.BasePage;
import interfaces.WordPress.HomePageUI;
import org.openqa.selenium.WebDriver;
import pageObject.WordPress.PageGenerator;

public class HomePageObject extends BasePage {
    WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }

    public MyAccountPageObject clickToMyAccountLink() {
        waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
        clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
        return new MyAccountPageObject(driver);
    }

    public LoginPageObject clickToLoginLink() {
        waitForElementClickable(driver, HomePageUI.LOGIN_LINK);
        clickToElement(driver, HomePageUI.LOGIN_LINK);
        return new LoginPageObject(driver);
    }

    public String getUserValue() {
        waitForElementVisible(driver, HomePageUI.USER_DROPDOWN);
        return getTextElement(driver, HomePageUI.USER_DROPDOWN);
    }

    public void clickToDropdownName() {
        waitForElementVisible(driver, HomePageUI.USER_DROPDOWN_TAB);
        clickToElement(driver, HomePageUI.USER_DROPDOWN_TAB);
    }

    public LoginPageObject clickToLogout() {
        waitForElementVisible(driver, HomePageUI.USER_DROPDOWN_TAB_LOGOUT_OPTION);
        clickToElement(driver, HomePageUI.USER_DROPDOWN_TAB_LOGOUT_OPTION);
        return PageGenerator.getLoginPage(driver);
    }
}
