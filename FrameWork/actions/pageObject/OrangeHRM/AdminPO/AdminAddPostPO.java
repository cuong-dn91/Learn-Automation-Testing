package pageObject.OrangeHRM.AdminPO;

import commons.BasePage;
import interfaces.WordPress.AdminUI.AdminAddPostPageUI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AdminAddPostPO extends BasePage {
    private WebDriver driver;

    public AdminAddPostPO(WebDriver driver) {
        this.driver = driver;
    }

    public void inputTitlePost(String titlePost) {
        switchToIframe(driver, "xpath=//iframe[@name='editor-canvas']");
        waitForElementVisible(driver, AdminAddPostPageUI.TITLE_TEXTBOX);
        sendKeys(driver, AdminAddPostPageUI.TITLE_TEXTBOX, titlePost);
        switchToDefaultContent(driver);
    }

    public void inputContentPost(String contentValue) {
        switchToIframe(driver, "xpath=//iframe[@name='editor-canvas']");
        waitForElementVisible(driver, AdminAddPostPageUI.CONTENT_DOCUMENT);
        clickToElement(driver, AdminAddPostPageUI.CONTENT_DOCUMENT);
        Actions action = new Actions(driver);
        action.sendKeys(contentValue).perform();
        switchToDefaultContent(driver);
    }

    public void clickToPublishPost() {
        waitForElementVisible(driver, AdminAddPostPageUI.PUBLISH_BUTTON);
        clickToElement(driver, AdminAddPostPageUI.PUBLISH_BUTTON);
        clickToElement(driver, AdminAddPostPageUI.CONFIRM_PUBLISH_BUTTON);
        sleep(3);
    }
}
