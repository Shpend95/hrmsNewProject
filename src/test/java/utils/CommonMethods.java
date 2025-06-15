package utils;

import io.cucumber.java.ja.且つ;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods extends PageInitializer {
    public static WebDriver driver;

    public static void launchBrowser() {
        switch (ConfigReader.read("browser")) {
            case "chrome":
                driver = new ChromeDriver();
                break;
            case "edge":
                driver = new EdgeDriver();
                break;
            case "fireFox":
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("Invalid Browser Name");
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        driver.get(ConfigReader.read("url"));
        initializePageObjects();
    }

    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait;
    }

    public static void waitForElementToBeVisible(WebElement element){
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
        Select select = new Select(dropDown);
        select.selectByIndex(index);
    }

    public static void selectFromDropDown(WebElement dropDown, String visibleText) {
        Select select = new Select(dropDown);
        select.selectByVisibleText(visibleText);
    }

    public static void selectFromDropDown(String value, WebElement dropDown) {
        Select select = new Select(dropDown);
        select.selectByValue(value);
    }

    public static byte[] takeScreenshot(String fileName) throws IOException {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        byte[] picBytes = takesScreenshot.getScreenshotAs(OutputType.BYTES);

        //below: takes screenshot
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        try {
            //below: saves  the screenshot
            FileUtils.copyFile(sourceFile, new File
                    (Constants.SCREENSHOTS_PATH + fileName + " " + getTimeStamp("yyyy-MM-dd-HH-mm-ss") + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picBytes;
    }

    public static String getTimeStamp(String pattern) {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);

    }

    public static JavascriptExecutor getJSExecutor() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }

    public static JavascriptExecutor sendJSExecutorText(String script,WebElement element){
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript(script,element);
        return js;
    }

    public static void jsClick(WebElement element) {
        getJSExecutor().executeScript("arguments[0].click();", element);
    }


}
