package TestNG;

import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObject.OrangeHRM.AdminPO.HRMAdminDashboardPO;
import pageObject.OrangeHRM.AdminPO.HRMAdminLoginPO;
import pageObject.OrangeHRM.AdminPO.HRMAdminMyInfoPO;
import pageObject.OrangeHRM.AdminPO.HRMAdminPIMPO;
import pageObject.OrangeHRM.HRMPageGenerator;
import pageObject.WordPress.PageGenerator;
import testData.TestDataUtils;

public class Add_Employee extends BaseTest {

    HRMAdminDashboardPO adminDashboard;
    HRMAdminLoginPO adminLoginPage;
    HRMAdminPIMPO adminPIMPage;
    HRMAdminMyInfoPO adminMyInfoPage;
    String randomEmployeeId = TestDataUtils.generateFourDigitNumber();
    String randomUsername = TestDataUtils.generateUsername();

    @Parameters({"browser", "server"})
    @BeforeClass
    public void beforeClass(String browserName, String serverName) {
        initBrowser(browserName, serverName);
        adminLoginPage = HRMPageGenerator.getAdminLoginPage(getDriver());
    }

    @Test()
    public void TCs01_CreateNewEmployee() throws InterruptedException {
        adminDashboard = adminLoginPage.loginAccount("Pandora", "%Bj21IK7$#pkUuQ1Dq");
        adminDashboard.clickToSideMenu("PIM");
        adminPIMPage = HRMPageGenerator.getAdminPIMPage(getDriver());
        adminPIMPage.clickToAddEmployeeMenu();
        adminPIMPage.inputDataToFullName("Ra", "Do", "Pan");
        adminPIMPage.inputDataToEmployeeId(randomEmployeeId);
        adminPIMPage.clickToCreateLoginDetailsCheckbox();
        adminPIMPage.inputDataToUsername(randomUsername);
        adminPIMPage.inputDataToPassword("Abcd@1234@");
        adminPIMPage.inputDataToConfirmPassword("Abcd@1234@");
        adminPIMPage.clickToSaveButton();
        Assert.assertEquals(adminPIMPage.valueContentMessage(), "Successfully Saved", "Employee create not success!!!");
    }

    @Test()
    public void TCs02_CheckLoginWithEmployee() throws InterruptedException {
        adminPIMPage.clickToProfile();
        adminLoginPage = adminPIMPage.clickToLogoutMenu();
        adminDashboard = adminLoginPage.loginAccount(randomUsername, "Abcd@1234@");
        adminDashboard.clickToSideMenu("My Info");
        adminMyInfoPage = HRMPageGenerator.getMyInfoPage(getDriver());
        Assert.assertEquals(adminMyInfoPage.getEmployeeId(),randomEmployeeId, "ID employee not match!!!");
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        getDriver().quit();
    }
}
