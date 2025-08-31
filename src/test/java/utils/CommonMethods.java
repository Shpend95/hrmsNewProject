
package utils;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.io.FileUtils;
import org.asynchttpclient.Request;
import org.openqa.selenium.*;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;


public class CommonMethods extends PageInitializer {

    public static Response response;
    public static RequestSpecification prepareRequest;

    public static WebDriver driver;
    public static void openBrowserAndLaunchApplication() throws IOException {

        switch (ConfigReader.read("browser")){
            case "Chrome":
                ChromeOptions options=new ChromeOptions();
                options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
                options.addArguments("--remote-allow-origins=*");
                options.addArguments("--user-data-dir=/tmp/chrome-profile-" + System.currentTimeMillis());
                driver=new  ChromeDriver(options);
                break;
            case "FireFox":
                FirefoxOptions firefoxOptions=new FirefoxOptions();
                driver=new FirefoxDriver(firefoxOptions);
                break;
            case "edge":
                EdgeOptions edgeOptions=new EdgeOptions();
                driver=new EdgeDriver(edgeOptions);
                break;
            default:
                throw new RuntimeException("Invalid Browser Name");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(ConfigReader.read("url"));
        initializePageObjects();
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }


    public static WebDriverWait getWait() {
        return new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public static void waitForElementToBeVisible(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForElementToBeClickable(WebElement element) {
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void click(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    public static void sendText(String text, WebElement element) {
        element.clear();
        element.sendKeys(text);
    }

    public static void selectFromDropDown(WebElement dropDown, int index) {
        new Select(dropDown).selectByIndex(index);
    }

    public static void selectFromDropDown(WebElement dropDown, String visibleText) {
        new Select(dropDown).selectByVisibleText(visibleText);
    }

    public static void selectFromDropDown(String value, WebElement dropDown) {
        new Select(dropDown).selectByValue(value);
    }

    public static byte[] takeScreenshot(String fileName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        byte[] picBytes = takesScreenshot.getScreenshotAs(OutputType.BYTES);

        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOTS_PATH +
                fileName + " " + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));

        return picBytes;
    }

    public static String getTimeStamp(String pattern) {
        return new SimpleDateFormat(pattern).format(new Date());
    }

    public static JavascriptExecutor getJSExecutor() {
        return (JavascriptExecutor) driver;
    }

    public static void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

}

