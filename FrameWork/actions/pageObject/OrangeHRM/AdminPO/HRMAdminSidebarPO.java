package pageObject.OrangeHRM.AdminPO;

import commons.BasePage;
import interfaces.OrangeHRM.AdminUI.HRMAdminSideMenuUI;
import interfaces.WordPress.AdminUI.AdminSideMenuUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HRMAdminSidebarPO extends HRMAdminHeaderPO {
    private WebDriver driver;

    public HRMAdminSidebarPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToSideMenu(String menuName) {
        waitForElementClickable(driver, HRMAdminSideMenuUI.MENU_BY_NAME, menuName, menuName);
        clickToElement(driver, HRMAdminSideMenuUI.MENU_BY_NAME, menuName, menuName);
    }
}
