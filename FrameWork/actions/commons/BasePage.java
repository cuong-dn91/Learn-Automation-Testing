package commons;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

//	Kiểu dữ liệu của hàm (Data Type): void/ Int/ String/ Boolean/ WebElement/ List<ƯebElement>
//	Hàm dùng để làm gì?
//	Dùng cái hàm naopf của Selenium
//	Kiểu trả về của hàm đó
//	Các hàm mà tương tác thì hầu như trả về void: Click/ Sendkeys/ Accept/ Cancel/ ...
//	Các hàm lấy dữ liệu thì hầu như trả về: String/ Int/ WebElement/ ...

    /**
     * Không cần khởi tạo đối tượng nhưng vẫn có thể truy cập vào hàm này được
     * Truy cập trực tiếp từ phạm vi class
     * @return
     */
    public static BasePage getBasePage() {
        return new BasePage();
    }

    public Alert waitForAlertPresence (WebDriver driver) {
        return new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.alertIsPresent());
    }

    public String getElementText(WebDriver driver, String locator) {
        return getWebElement(driver, locator).getText();
    }

    public String getCurrentUrl (WebDriver driver) {
        return driver.getCurrentUrl();
    }

    public String getCurrentTitle (WebDriver driver) {
        return driver.getTitle();
    }

    public void openUrl (WebDriver driver, String url) {
        driver.get(url);
    }

    public String getPageSourceCode (WebDriver driver) {
        return driver.getPageSource();
    }

    public void back (WebDriver driver) {
        driver.navigate().back();
    }

    public void foward (WebDriver driver) {
        driver.navigate().forward();
    }

    public void refresh (WebDriver driver) {
        driver.navigate().refresh();
    }

    public void acceptToAlert (WebDriver driver) {
        waitForAlertPresence(driver).accept();
    }

    public void cancelToAlert (WebDriver driver) {
        waitForAlertPresence(driver).dismiss();
    }

    public String getTextInAlert (WebDriver driver) {
        return waitForAlertPresence(driver).getText();
    }

    public Set<Cookie> getCookie (WebDriver driver) {
        return driver.manage().getCookies();
    }

    public void setCookie (WebDriver driver, Set<Cookie> cookies) {
        for (Cookie cookie : cookies) {
            driver.manage().addCookie(cookie);
        }
    }

    public void deleteAllCookie (WebDriver driver) {
        driver.manage().deleteAllCookies();
    }

    public void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void switchTo (WebDriver driver, String title) {
        Set<String> totalIdTab = driver.getWindowHandles();
        for (String idTab: totalIdTab) {
            driver.switchTo().window(idTab);
            String currentTitle = driver.getTitle();
            if (currentTitle.equals(title)) {
                break;
            }
        }
    }

//	Web Element

    public By getByLocator(String locatorValue) {
        By by = null;

        if (locatorValue.toUpperCase().startsWith("XPATH=")) {
            by = By.xpath(locatorValue.substring(6));
        } else if (locatorValue.toUpperCase().startsWith("CSS=")) {
            by = By.cssSelector(locatorValue.substring(4));
        } else if (locatorValue.toUpperCase().startsWith("ID=")) {
            by = By.id(locatorValue.substring(3));
        } else if (locatorValue.toUpperCase().startsWith("NAME=")) {
            by = By.name(locatorValue.substring(5));
        } else if (locatorValue.toUpperCase().startsWith("CLASS=")) {
            by = By.className(locatorValue.substring(6));
        } else if (locatorValue.toUpperCase().startsWith("TAGNAME=")) {
            by = By.tagName(locatorValue.substring(8));
        } else {
            throw new RuntimeException("Locator type is not valid!");
        }
        return by;
    };

    public By getByLocator(String locator, String... dynamicValues) {
        if (dynamicValues.length > 0) {
            locator = String.format(locator, (Object[]) dynamicValues);
        }

        if (locator.toUpperCase().startsWith("ID=")) {
            return By.id(locator.substring(3));
        } else if (locator.toUpperCase().startsWith("CSS=")) {
            return By.cssSelector(locator.substring(4));
        } else if (locator.toUpperCase().startsWith("NAME=")) {
            return By.xpath(locator.substring(5));
        } else if (locator.toUpperCase().startsWith("CLASS=")) {
            return By.xpath(locator.substring(6));
        } else if (locator.toUpperCase().startsWith("TAGNAME=")) {
            return By.xpath(locator.substring(8));
        } else if (locator.toUpperCase().startsWith("XPATH=")) {
            return By.xpath(locator.substring(6));
        } else {
            throw new RuntimeException("Locator type is not supported: " + locator);
        }
    }


    public By getByXpath(String locator) {
        return By.xpath(locator);
    }

    public String getDynamicLocator (String locator, String... restParams) {
        return String.format(locator, (Object[]) restParams);
    }

    public WebElement getWebElement (WebDriver driver, String locator) {
        return driver.findElement(getByLocator(locator));
    }

    public WebElement getWebElement (WebDriver driver, String locator, String... dynamicValues) {
        return driver.findElement(getByLocator(locator, dynamicValues));
    }

    public List<WebElement> getListWebElement (WebDriver driver, String locator) {
        return driver.findElements(getByLocator(locator));
    }

    public List<WebElement> getListWebElement (WebDriver driver, String locator, String... dynamicValues) {
        return driver.findElements(getByLocator(locator, dynamicValues));
    }

    public void clickToElement(WebDriver driver, String locator) {
//        new WebDriverWait(driver, Duration.ofSeconds(30))
//                .until(ExpectedConditions.elementToBeClickable(getByLocator(locator)))
//                .click();
        getWebElement(driver, locator).click();
    }

    public void clickToElement(WebDriver driver, String locator, String... dynamicValues) {
//        new WebDriverWait(driver, Duration.ofSeconds(30))
//                .until(ExpectedConditions.elementToBeClickable(getByLocator(locator, dynamicValues)))
//                .click();
        getWebElement(driver, locator, dynamicValues).click();
    }

    public void sendKeys(WebDriver driver, String locator, String value) {
        getWebElement(driver, locator).clear();
        getWebElement(driver, locator).sendKeys(value);
    }

    public void sendKeys(WebDriver driver, String locator, String value, String... dynamicValues) {
//        String formattedLocator = getDynamicLocator(locator, dynamicValues);
//        getWebElement(driver, formattedLocator).clear();
//        getWebElement(driver, formattedLocator).sendKeys(value);
        getWebElement(driver, locator, dynamicValues).clear();
        getWebElement(driver, locator, dynamicValues).sendKeys(value);
    }

    public void sendkeysToAlert (WebDriver driver, String value) {
        waitForAlertPresence(driver).sendKeys(value);
    }

    //	Hàm thao tác với Default Dropdown
    public void selectItemInDefaultDropdown(WebDriver driver, String locator, String itemValue) {
        new Select(getWebElement(driver, locator)).selectByVisibleText(itemValue);
    }

    public boolean isDefaultDropdownMultiple(WebDriver driver, String locator) {
        return new Select(getWebElement(driver, locator)).isMultiple();
    }

    public String getFirstSelectedTextInDefaultDropdown(WebDriver driver, String locator) {
        return new Select(getWebElement(driver, locator)).getFirstSelectedOption().getText();
    }

    //	Hàm dùng để thao tác với Custom Dropdown
    public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childLocator, String expectedItem) {
        getWebElement(driver, parentLocator).click();
        sleep(1);
        List<WebElement> dropdownItems = new WebDriverWait(driver, Duration.ofSeconds(30)).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
        for (WebElement tempItem : dropdownItems) {
            if (tempItem.getText().trim().equals(expectedItem)) {
                sleep(1);
                tempItem.click();
                break;
            }
        }
    }

    public String getTextElement(WebDriver driver, String locator) {
        return getWebElement(driver, locator).getText();
    }

    public String getTextElement(WebDriver driver, String locator, String... dynamicValues) {
        return getWebElement(driver, locator, dynamicValues).getText();
    }

//    public String getTextElement(WebDriver driver, String locator, String... dynamicValues) {
//        String formattedLocator = getDynamicLocator(locator, dynamicValues);
//        return getWebElement(driver, locator).getText();
//    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
        return getWebElement(driver, locator).getAttribute(attributeName);
    }

    public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... dynamicValues) {
        return getWebElement(driver, locator, dynamicValues).getAttribute(attributeName);
    }

    public String getElementCssValue(WebDriver driver, String locator, String cssPropertyName) {
        return getWebElement(driver, locator).getCssValue(cssPropertyName);
    }

    public String getElementCssValue(WebDriver driver, String locator, String cssPropertyName, String... dynamicValues) {
        return getWebElement(driver, locator,dynamicValues).getCssValue(cssPropertyName);
    }

    public void convertRGBAToHexaBackgroundColor (WebDriver driver, String locator) {
        Color.fromString(getElementCssValue(driver, locator, "background-color")).asHex();
    }

    public int getListElementSize(WebDriver driver, String locator) {
        return getListWebElement(driver, locator).size();
    }

    /**
     * Apply for checkbox and radio button
     * @param driver
     * @param locator
     */
    public void checkToElement ( WebDriver driver, String locator) {
        if (!getWebElement(driver, locator).isSelected()) {
            getWebElement(driver, locator).click();
        }
    }

    public void checkToElement ( WebDriver driver, String locator, String... dynamicValues) {
        if (!getWebElement(driver, locator, dynamicValues).isSelected()) {
            getWebElement(driver, locator, dynamicValues).click();
        }
    }

    /**
     * Apply for checkbox
     * @param driver
     * @param locator
     */
    public void uncheckToElement ( WebDriver driver, String locator) {
        if (getWebElement(driver, locator).isSelected()) {
            getWebElement(driver, locator).click();
        }
    }

    public void uncheckToElement ( WebDriver driver, String locator, String... dynamicValues) {
        if (getWebElement(driver, locator, dynamicValues).isSelected()) {
            getWebElement(driver, locator, dynamicValues).click();
        }
    }

    public boolean isElementDisplayed (WebDriver driver, String locator) {
        return getWebElement(driver, locator).isDisplayed();
    }

    public boolean isElementDisplayed (WebDriver driver, String locator, String... dynamicValues) {
        try {
//            String dynamicLocator = String.format(locator, (Object[]) values);
//            return driver.findElement(By.xpath(dynamicLocator)).isDisplayed();
            return getWebElement(driver, locator, dynamicValues).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public boolean isElementSelected (WebDriver driver, String locator) {
        return getWebElement(driver, locator).isSelected();
    }

    public boolean isElementSelected (WebDriver driver, String locator, String... dynamicValues) {
        return getWebElement(driver, locator, dynamicValues).isSelected();
    }

    public boolean isElementEnable (WebDriver driver, String locator) {
        return getWebElement(driver, locator).isEnabled();
    }

    public boolean isElementEnable (WebDriver driver, String locator, String... dynamicValues) {
        return getWebElement(driver, locator, dynamicValues).isEnabled();
    }

    public void switchToIframe (WebDriver driver, String locator) {
        new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByLocator(locator)));
    }

    public void switchToDefaultContent (WebDriver driver) {
        driver.switchTo().defaultContent();
    }

    //	Hàm cho actions
    public void hoverToElement (WebDriver driver, String locator) {
        new Actions(driver).moveToElement(getWebElement(driver, locator)).perform();
    }

    public void hoverToElement(WebDriver driver, String locator, String... dynamicValues) {
//        String formattedLocator = getDynamicLocator(locator, dynamicValues);
//        Actions action = new Actions(driver);
//        action.moveToElement(getWebElement(driver, formattedLocator)).perform();
        new Actions(driver).moveToElement(getWebElement(driver, locator, dynamicValues)).perform();
    }

    public void doubleClickToElement (WebDriver driver, String locator) {
        new Actions(driver).doubleClick(getWebElement(driver, locator)).perform();
    }

    public void doubleClickToElement (WebDriver driver, String locator, String... dynamicValues) {
        new Actions(driver).doubleClick(getWebElement(driver, locator, dynamicValues)).perform();
    }

    public void rightClickToElement (WebDriver driver, String locator) {
        new Actions(driver).contextClick(getWebElement(driver, locator)).perform();
    }

    public void rightClickToElement (WebDriver driver, String locator, String... dynamicValues) {
        new Actions(driver).contextClick(getWebElement(driver, locator, dynamicValues)).perform();
    }

    //	Chỉ áp dụng cho HTML 4 - Không áp dụng cho HTML 5
    public void dragAndDropElement (WebDriver driver, String sourceLocator, String targetLocator) {
        new Actions(driver).dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
    }

    public void sendKeyBoardToElement (WebDriver driver, String locator, Keys key) {
        new Actions(driver).sendKeys(getWebElement(driver, locator), key).perform();
    }

    public void sendKeyBoardToElement (WebDriver driver, String locator, Keys key, String... dynamicValues) {
        new Actions(driver).sendKeys(getWebElement(driver, locator, dynamicValues), key).perform();
    }

    //	JavaScriptExecuted
    public Object executeForBrowser (WebDriver driver, String javaScript) {
        return ((JavascriptExecutor) driver).executeScript(javaScript);
    }

    public String getInnerText (WebDriver driver, String javaScript) {
        return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
    }

    public boolean areExpectedTextInInnerText (WebDriver driver, String textExpected ) {
        String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0];");
        return textActual.equals(textExpected);
    }

    public void scrollToBottomPage (WebDriver driver) {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
    }

    public void navigateToUrlByJS (WebDriver driver, String url) {
        ((JavascriptExecutor) driver).executeScript("window.location = '" + url + "'");
        sleep(3);
    }

    public void highlightElement (WebDriver driver, String locator) {
        WebElement element = getWebElement(driver, locator);
        String originalStyle = element.getAttribute("style");
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribue('style', arguments[1])", element, "border: 2px solid red, border-style: dashed");
        sleep(1);
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribue('style', arguments[1])", element, originalStyle);
    }

    public void clickToElementByJS (WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator));
    }

    public void clickToElementByJS (WebDriver driver, String locator, String... dynamicValues) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, locator, dynamicValues));
    }

    public void scrollToElementOnTop (WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
    }

    public void scrollToElementOnDown (WebDriver driver, String locator) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, locator));
    }

    public void sendKeyToElementByJS (WebDriver driver, String locator, String value) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribue('value', '" + value + "')", getWebElement(driver, locator));
    }

    public void sendKeyToElementByJS (WebDriver driver, String locator, String value, String... dynamicValues) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].setAttribue('value', '" + value + "')", getWebElement(driver, locator, dynamicValues));
    }

    public void removeAttribueInDOM (WebDriver driver, String locator, String attributeRemove) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
    }

    public String getElementValidationMessageByJS (WebDriver driver, String locator) {
        return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
    }

    public boolean isImageLoaded (WebDriver driver, String locator) {
        return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
    }

    public void waitForElementVisible (WebDriver driver, String locator) {
        new WebDriverWait (driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementVisible (WebDriver driver, String locator, String... dynamicValues) {
        new WebDriverWait (driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator, dynamicValues)));
    }

//    public void waitForElementVisible (WebDriver driver, String locator, String... dynamicValues) {
//        // Bước 1: Gọi hàm format để thay thế các ký tự %s
//        String formattedLocator = getDynamicLocator(locator, dynamicValues);
//
//        // Bước 2: Thực hiện đợi như bình thường với locator đã format
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(formattedLocator)));
//    }

    public void waitForListElementVisible (WebDriver driver, String locator) {
        new WebDriverWait (driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, locator)));
    }

    public void waitForListElementVisible (WebDriver driver, String locator, String... dynamicValues) {
        new WebDriverWait (driver, Duration.ofSeconds(30)).until(ExpectedConditions.visibilityOfAllElements(getListWebElement(driver, locator, dynamicValues)));
    }

    public void waitForElementInvisible (WebDriver driver, String locator) {
        new WebDriverWait (driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
    }

    public void waitForElementInvisible (WebDriver driver, String locator, String... dynamicValues) {
        new WebDriverWait (driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator, dynamicValues)));
    }

    public void waitForListElementInvisible (WebDriver driver, String locator) {
        new WebDriverWait (driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator)));
    }

    public void waitForListElementInvisible (WebDriver driver, String locator, String... dynamicValues) {
        new WebDriverWait (driver, Duration.ofSeconds(30)).until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator, dynamicValues)));
    }

    public void waitForElementClickable (WebDriver driver, String locator) {
        new WebDriverWait (driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
    }

    public void waitForElementClickable (WebDriver driver, String locator, String... dynamicValues) {
        new WebDriverWait (driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(getByLocator(locator, dynamicValues)));
    }

//    public void waitForElementClickable(WebDriver driver, String locator, String... dynamicValues) {
//        // 1. Khởi tạo WebDriverWait (ví dụ 30 giây)
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//        // 2. Format locator nếu nó chứa tham số động (gọi hàm getDynamicLocator đã viết trước đó)
//        String formattedLocator = getDynamicLocator(locator, dynamicValues);
//
//        // 3. Sử dụng ExpectedConditions.elementToBeClickable kết hợp với getByLocator
//        // getByLocator sẽ giúp bóc tách tiền tố "xpath=", "css="...
//        wait.until(ExpectedConditions.elementToBeClickable(getByLocator(formattedLocator)));
//    }

    public boolean isPageLoadedSuccess(WebDriver driver) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        ExpectedCondition<Boolean> jqueryLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return (Boolean) jsExecutor.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
            }
        };

        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return jsExecutor.executeScript("return document.readystate").toString().equals("complete");
            }
        };
        return explicitWait.until(jqueryLoad) && explicitWait.until(jsLoad);
    }

    public void setImplicitWait(WebDriver driver, long timeoutInSeconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeoutInSeconds));
    }
}