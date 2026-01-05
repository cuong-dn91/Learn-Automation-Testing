package pageObject.WordPress.AdminPO;

import interfaces.WordPress.AdminUI.AdminPostManagerPageUI;
import org.openqa.selenium.WebDriver;
import pageObject.WordPress.PageGenerator;

public class AdminDashboardPO extends AdminSidebarPO {
    private WebDriver driver;

    public AdminDashboardPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public AdminAddPostPO clickToAddPost() {

        return PageGenerator.getAdminAddPostPage(driver);
    }

    public AdminAddPostPO clickToAddPostButton() {
        waitForElementClickable(driver, AdminPostManagerPageUI.ADD_POST_BUTTON);
        clickToElement(driver, AdminPostManagerPageUI.ADD_POST_BUTTON);
        return PageGenerator.getAdminAddPostPage(driver);
    }
}
