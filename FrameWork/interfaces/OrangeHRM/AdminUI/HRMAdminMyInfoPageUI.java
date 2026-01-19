package interfaces.OrangeHRM.AdminUI;

public class HRMAdminMyInfoPageUI {
    public static final String PERSONAL_DETAILS_EMPLOYEE_ID = "xpath=//label[@class='oxd-label' and text()='Employee Id']//parent::div//following-sibling::div//input[contains(@class,'oxd-input')]";
    public static final String PERSONAL_DETAILS_FIRST_NAME = "xpath=//div[@class='--name-grouped-field']//input[@name='firstName']";
    public static final String PERSONAL_DETAILS_MIDDLE_NAME = "xpath=//div[@class='--name-grouped-field']//input[@name='middleName']";
    public static final String PERSONAL_DETAILS_LAST_NAME = "xpath=//div[@class='--name-grouped-field']//input[@name='lastName']";
}
