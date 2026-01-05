package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class BaseTest {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected WebDriver getDriver() {
        return driver.get();
    }
    protected final String PROJECT_PATH = System.getProperty("user.dir");
    protected void initBrowser(String browserName, String server) {

        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        WebDriver webDriver;


        switch (browser) {
            case FIREFOX:
                webDriver = new FirefoxDriver();
                break;
            case EDGE:
//                String projectPath = System.getProperty("user.dir");
                System.setProperty("webdriver.edge.driver",
                        PROJECT_PATH + "/selenium/browserDrivers/msedgedriver.exe");
                webDriver = new EdgeDriver();
                break;
            case SAFARI:
                webDriver = new SafariDriver();
                break;
            case CHROME:
            default:
                webDriver = new ChromeDriver();
                break;
        }

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        webDriver.manage().window().maximize();
        webDriver.get(getEnvironmentUrl(server));

        driver.set(webDriver);
    }

    protected void closeBrowser() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }

    private String getEnvironmentUrl(String server) {
        switch (server) {
            case "Local":
                return "http://localhost/orangehrm/orangehrm-5.8/web/index.php/auth/login";
            case "Dev":
                return "https://demo.nopcommerce.com/";
            case "Staging":
                return "https://staging.nopcommerce.com/";
            case "Prod":
                return "https://nopcommerce.com/";
            default:
                throw new RuntimeException("Server name is invalid!");
        }
    }

    protected void getBrowserDriver(String browserName, String url) {

        BrowserList browser = BrowserList.valueOf(browserName.toUpperCase());
        WebDriver webDriver;


        switch (browser) {
            case FIREFOX:
                webDriver = new FirefoxDriver();
                break;
            case EDGE:
//                String projectPath = System.getProperty("user.dir");
                System.setProperty("webdriver.edge.driver",
                        PROJECT_PATH + "/selenium/browserDrivers/msedgedriver.exe");
                webDriver = new EdgeDriver();
                break;
            case SAFARI:
                webDriver = new SafariDriver();
                break;
            case CHROME:
            default:
                webDriver = new ChromeDriver();
                break;
        }

        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        webDriver.manage().window().maximize();
        webDriver.get(url);
        driver.set(webDriver);
    }
}
