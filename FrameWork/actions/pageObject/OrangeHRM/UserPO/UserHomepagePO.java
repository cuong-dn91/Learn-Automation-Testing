package pageObject.OrangeHRM.UserPO;

import commons.BasePage;
import interfaces.WordPress.UserUI.UserHomepageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserHomepagePO extends BasePage {
    private WebDriver driver;

    public UserHomepagePO(WebDriver driver) {
        this.driver = driver;
    }

    public Boolean isBlogDisplayed(String blogTitle) {
        String locator = String.format(UserHomepageUI.BLOG_TITLE_BY_NAME, blogTitle);
        setImplicitWait(driver, 5);
        List<WebElement> elements = getListWebElement(driver, locator);
        boolean isDisplayed = elements.size() > 0 && elements.get(0).isDisplayed();
        setImplicitWait(driver, 30);
        return isDisplayed;
    }
}
