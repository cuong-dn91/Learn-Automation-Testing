package pageObject.OrangeHRM.AdminPO;

import interfaces.OrangeHRM.AdminUI.HRMAdminPIMPageUI;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class HRMAdminPIMPO extends HRMAdminSidebarPO {
    private WebDriver driver;

    public HRMAdminPIMPO(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void clickToAddEmployeeMenu() {
        waitForElementClickable(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_TOP_BAR_MENU);
        clickToElement(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_TOP_BAR_MENU);
    }

    public void inputDataToFirstName(String firstName) {
        waitForElementVisible(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_FIRST_NAME_TEXTBOX);
        sendKeys(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_FIRST_NAME_TEXTBOX, firstName);
    }

    public void inputDataToMiddleName(String middleName) {
        waitForElementVisible(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_MIDDLE_NAME_TEXTBOX);
        sendKeys(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_MIDDLE_NAME_TEXTBOX, middleName);
    }

    public void inputDataToLastName(String lastName) {
        waitForElementVisible(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_LAST_NAME_TEXTBOX);
        sendKeys(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_LAST_NAME_TEXTBOX, lastName);
    }

    public void inputDataToFullName(String firstName, String middleName, String lastName) {
        waitForElementVisible(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_FIRST_NAME_TEXTBOX);
        sendKeys(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_FIRST_NAME_TEXTBOX, firstName);
        waitForElementVisible(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_MIDDLE_NAME_TEXTBOX);
        sendKeys(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_MIDDLE_NAME_TEXTBOX, middleName);
        waitForElementVisible(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_LAST_NAME_TEXTBOX);
        sendKeys(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_LAST_NAME_TEXTBOX, lastName);
    }

    public void inputDataToEmployeeId(String employeeId) {
        waitForElementVisible(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_EMPLOYEE_ID_TEXTBOX);
        sendKeys(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_EMPLOYEE_ID_TEXTBOX, employeeId);
    }

    public void inputDataToUsername(String username) {
        waitForElementVisible(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_USERNAME_TEXTBOX);
        sendKeys(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_USERNAME_TEXTBOX, username);
    }

    public void inputDataToPassword(String password) {
        waitForElementVisible(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_PASSWORD_TEXTBOX);
        sendKeys(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_PASSWORD_TEXTBOX, password);
    }

    public void inputDataToConfirmPassword(String confirmPassword) {
        waitForElementVisible(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_CONFIRM_PASSWORD_TEXTBOX);
        sendKeys(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_CONFIRM_PASSWORD_TEXTBOX, confirmPassword);
    }

    public void clickToCreateLoginDetailsCheckbox() {
        waitForElementClickable(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_CREATE_LOGIN_DETAILS_CHECKBOX);
        clickToElement(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_CREATE_LOGIN_DETAILS_CHECKBOX);
    }

    public void clickToSaveButton() {
        waitForElementClickable(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_SAVE_BUTTON);
        clickToElement(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_SAVE_BUTTON);
    }

    public void clickToCancelButton() {
        waitForElementClickable(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_CANCEL_BUTTON);
        clickToElement(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_CANCEL_BUTTON);
    }

    public String valueContentMessage() {
        return getTextElement(driver, HRMAdminPIMPageUI.ADD_EMPLOYEE_TOAST_MESSAGE_CONTENT);
    }
}
