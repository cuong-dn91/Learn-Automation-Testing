package pageObject.WordPress.AdminPO;

import commons.BasePage;
import interfaces.WordPress.AdminUI.AdminSideMenuUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AdminSidebarPO extends BasePage {
    private WebDriver driver;

    public AdminSidebarPO(WebDriver driver) {
        this.driver = driver;
    }

    public void hoverToElement(WebDriver driver, String locator, String... values) {
        String dynamicLocator = getDynamicLocator(locator, values);
        WebElement element = driver.findElement(getByLocator(dynamicLocator));
        Actions action = new Actions(driver);
        action.moveToElement(element).perform();
    }

    public void clickToSideMenu(String menuName) {
        waitForElementClickable(driver, AdminSideMenuUI.MENU_BY_NAME, menuName, menuName);
        clickToElement(driver, AdminSideMenuUI.MENU_BY_NAME, menuName, menuName);
    }
}
