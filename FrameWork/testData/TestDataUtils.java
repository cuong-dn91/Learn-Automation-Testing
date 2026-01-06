package testData;

import commons.BaseTest;
import graphql.language.StringValue;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class TestDataUtils extends BaseTest {
    WebDriver driver;
    public TestDataUtils(WebDriver driver) {
        this.driver = driver;
    }

    public static String generateRandomEmail() {
        return "pandora" + System.currentTimeMillis() + "@yopmail.com";
    }

    public static String generateUsername() {
        return "pandora" + System.currentTimeMillis();
    }

    public static String generateFourDigitNumber() {
        return String.valueOf(1000 + new Random().nextInt(9000));
    }
}
