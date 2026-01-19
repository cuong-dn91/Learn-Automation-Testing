package pageObject.OrangeHRM;

import org.openqa.selenium.WebDriver;
import pageObject.AddressPageObject;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyAccountPageObject;
import pageObject.OrangeHRM.AdminPO.HRMAdminDashboardPO;
import pageObject.OrangeHRM.AdminPO.HRMAdminLoginPO;
import pageObject.OrangeHRM.AdminPO.HRMAdminMyInfoPO;
import pageObject.OrangeHRM.AdminPO.HRMAdminPIMPO;
import pageObject.OrangeHRM.UserPO.UserHomepagePO;

public class HRMPageGenerator {
    public static AddressPageObject getAddressPage (WebDriver driver) {
        return new AddressPageObject(driver);
    }

    public static HomePageObject getHomePage (WebDriver driver) {
        return new HomePageObject(driver);
    }

    public static LoginPageObject getLoginPage(WebDriver driver) {
        return new LoginPageObject(driver);
    }

    public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
        return new MyAccountPageObject(driver);
    }

    public static UserHomepagePO getUserHomepage(WebDriver driver) {
        return new UserHomepagePO(driver);
    }

    public static HRMAdminLoginPO getAdminLoginPage(WebDriver driver) {
        return new HRMAdminLoginPO(driver);
    }

    public static HRMAdminDashboardPO getAdminDashboardPage(WebDriver driver) {
        return new HRMAdminDashboardPO(driver);
    }

    public static HRMAdminPIMPO getAdminPIMPage(WebDriver driver) {
        return new HRMAdminPIMPO(driver);
    }

    public static HRMAdminMyInfoPO getMyInfoPage(WebDriver driver) {
        return new HRMAdminMyInfoPO(driver);
    }
}
