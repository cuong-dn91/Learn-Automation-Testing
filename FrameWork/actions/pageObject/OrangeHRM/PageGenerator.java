package pageObject.OrangeHRM;

import org.openqa.selenium.WebDriver;
import pageObject.AddressPageObject;
import pageObject.HomePageObject;
import pageObject.LoginPageObject;
import pageObject.MyAccountPageObject;
import pageObject.OrangeHRM.AdminPO.AdminAddPostPO;
import pageObject.OrangeHRM.AdminPO.AdminDashboardPO;
import pageObject.OrangeHRM.AdminPO.AdminLoginPO;
import pageObject.OrangeHRM.UserPO.UserHomepagePO;

public class PageGenerator{
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

    public static AdminLoginPO getAdminLoginPage(WebDriver driver) {
        return new AdminLoginPO(driver);
    }

    public static AdminDashboardPO getAdminDashboardPage(WebDriver driver) {
        return new AdminDashboardPO(driver);
    }

    public static AdminAddPostPO getAdminAddPostPage(WebDriver driver) {
        return new AdminAddPostPO(driver);
    }
}
