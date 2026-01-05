package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_01_Excercises_Xpath_Css_Selector {
    WebDriver driver;
    String name, email, confirmEmail, pass, confirmPass, phone;
    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    @BeforeTest
    public void beforeClass() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
        driver.get("https://alada.vn/tai-khoan/dang-ky.html");
        name = "txtFirstname";
        email = "txtEmail";
        confirmEmail = "txtCEmail";
        pass = "txtPassword";
        confirmPass = "txtCPassword";
        phone = "txtPhone";
    }

    @Test
    public void TC_01_Register_With_Empty_Data() {
        driver.findElement(By.cssSelector("div>button[type='submit']")).click();
        Assert.assertEquals(driver.findElement(By.id("txtFirstname-error")).getText(), "Vui lòng nhập họ tên");
        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Vui lòng nhập lại địa chỉ email");
        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Vui lòng nhập mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Vui lòng nhập lại mật khẩu");
        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Vui lòng nhập số điện thoại.");
        sleep(2);
    }

    @Test
    public void TC_02_Register_With_Invalid_Email() {
        driver.findElement(By.id(name)).sendKeys("abc");
        driver.findElement(By.id(email)).sendKeys("abc.xyz");
        driver.findElement(By.id(confirmEmail)).sendKeys("abc.xyz");
        driver.findElement(By.id(pass)).sendKeys("abcd1234");
        driver.findElement(By.id(confirmPass)).sendKeys("abcd1234");
        driver.findElement(By.id(phone)).sendKeys("0123456789");

        Assert.assertEquals(driver.findElement(By.id("txtEmail-error")).getText(), "Vui lòng nhập email hợp lệ");
        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
        sleep(2);
    }

    @Test
    public void TC_03_Register_With_Invalid_Confirm_Email() {
        driver.findElement(By.id(email)).clear();
        driver.findElement(By.id(email)).sendKeys("abc@gmail.com");
        driver.findElement(By.id(confirmEmail)).clear();
        driver.findElement(By.id(confirmEmail)).sendKeys("abc1@gmail.com");

        Assert.assertEquals(driver.findElement(By.id("txtCEmail-error")).getText(), "Email nhập lại không đúng");
        sleep(2);
    }

    @Test
    public void TC_04_Register_With_Password_Less_Than_6_Characters() {
        driver.findElement(By.id(confirmEmail)).clear();
        driver.findElement(By.id(confirmEmail)).sendKeys("abc@gmail.com");
        driver.findElement(By.id(pass)).clear();
        driver.findElement(By.id(pass)).sendKeys("1234");
        driver.findElement(By.id(confirmPass)).clear();
        driver.findElement(By.id(confirmPass)).sendKeys("1234");

        Assert.assertEquals(driver.findElement(By.id("txtPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu phải có ít nhất 6 ký tự");
        sleep(2);
    }
    @Test
    public void TC_05_Register_With_Incorrect_Confirm_Password() {
        driver.findElement(By.id(pass)).clear();
        driver.findElement(By.id(pass)).sendKeys("abcd1234");
        driver.findElement(By.id(confirmPass)).clear();
        driver.findElement(By.id(confirmPass)).sendKeys("xyza1234");

        Assert.assertEquals(driver.findElement(By.id("txtCPassword-error")).getText(), "Mật khẩu bạn nhập không khớp");
        sleep(2);
    }

    @Test
    public void TC_06_Register_With_Invalid_Phone_Number() {
        driver.findElement(By.id(confirmPass)).clear();
        driver.findElement(By.id(confirmPass)).sendKeys("abcd1234");
        driver.findElement(By.id(phone)).clear();
        driver.findElement(By.id(phone)).sendKeys("012345");

        Assert.assertEquals(driver.findElement(By.id("txtPhone-error")).getText(), "Số điện thoại phải từ 10-11 số.");
        sleep(2);
    }

    @AfterTest
    public void AfterClass() {
        driver.quit();
    }
}