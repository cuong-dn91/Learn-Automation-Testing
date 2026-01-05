package pageObject;

import commons.BasePage;
import interfaces.WordPress.MyAccountPageUI;
import org.openqa.selenium.WebDriver;

public class MyAccountPageObject extends BasePage {
    WebDriver driver;


    public MyAccountPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public HomePageObject clickToLogoutLink() {
        waitForElementClickable(driver, MyAccountPageUI.LOGOUT_LINK);
        clickToElement(driver, MyAccountPageUI.LOGOUT_LINK);
        return new HomePageObject(driver);
    }
}
