package interfaces.OrangeHRM.AdminUI;

public class HRMAdminPIMPageUI {
    public static final String ADD_EMPLOYEE_TOP_BAR_MENU = "xpath=//nav[@aria-label='Topbar Menu']//a[text()='Add Employee']";
    public static final String ADD_EMPLOYEE_FIRST_NAME_TEXTBOX = "xpath=//form[@class='oxd-form']//input[@name='firstName']";
    public static final String ADD_EMPLOYEE_MIDDLE_NAME_TEXTBOX = "xpath=//form[@class='oxd-form']//input[@name='middleName']";
    public static final String ADD_EMPLOYEE_LAST_NAME_TEXTBOX = "xpath=//form[@class='oxd-form']//input[@name='lastName']";
    public static final String ADD_EMPLOYEE_EMPLOYEE_ID_TEXTBOX = "xpath=//form[@class='oxd-form']//label[text()='Employee Id']//parent::div//following-sibling::div//input[contains(@class,'oxd-input--active')]";
    public static final String ADD_EMPLOYEE_USERNAME_TEXTBOX = "xpath=//form[@class='oxd-form']//label[text()='Username']//parent::div//following-sibling::div//input[contains(@class,'oxd-input--active')]";
    public static final String ADD_EMPLOYEE_PASSWORD_TEXTBOX = "xpath=//form[@class='oxd-form']//label[text()='Password']//parent::div//following-sibling::div//input[contains(@class,'oxd-input--active')]";
    public static final String ADD_EMPLOYEE_CONFIRM_PASSWORD_TEXTBOX = "xpath=//form[@class='oxd-form']//label[text()='Confirm Password']//parent::div//following-sibling::div//input[contains(@class,'oxd-input--active')]";
    public static final String ADD_EMPLOYEE_CREATE_LOGIN_DETAILS_CHECKBOX = "xpath=//input[@type='checkbox']//following-sibling::span";
    public static final String ADD_EMPLOYEE_SAVE_BUTTON = "xpath=//form[@class='oxd-form']//div[@class='oxd-form-actions']//button[contains(@class,'oxd-button--secondary')]";
    public static final String ADD_EMPLOYEE_CANCEL_BUTTON = "xpath=//form[@class='oxd-form']//div[@class='oxd-form-actions']//button[contains(@class,'oxd-button oxd-button--medium oxd-button--ghost')]";
    public static final String ADD_EMPLOYEE_TOAST_MESSAGE = "xpath=//div[@id='oxd-toaster_1']";
    public static final String ADD_EMPLOYEE_TOAST_MESSAGE_TITLE = "xpath=//div[@id='oxd-toaster_1']//p[contains(@class,'oxd-text--toast-title')]";
    public static final String ADD_EMPLOYEE_TOAST_MESSAGE_CONTENT = "xpath=//div[@id='oxd-toaster_1']//p[contains(@class,'oxd-text--toast-message')]";
}
