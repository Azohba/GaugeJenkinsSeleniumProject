package utils;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSuite;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.logging.Logger;

public class BaseActions {
    Calliope calliope = new Calliope();
    public static Logger logger = Logger.getLogger(String.valueOf(BaseActions.class));
    public static WebDriver webDriver;
    public static WebDriverWait wait;

    @BeforeSuite
    public WebDriver getWebDriver(){
        webDriver = DriverSetup.initializeDriver();
        wait = new WebDriverWait(webDriver, 30);
        return webDriver;
    }

    @BeforeScenario
    public void goTo(){
        logger.info("Open to " + System.getenv("URL"));
        webDriver.navigate().to(System.getenv("URL"));
    }

    @AfterSuite
    public void tearDrop() throws IOException {
        webDriver.quit();
        logger.info("Webdriver closed!!");

    }

    @AfterAll
    public void sendCalliopeReport() throws IOException {
        calliope.sendResultsToCalliope();
    }
    public void waitUntilElementVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public String getText(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return webDriver.findElement(by).getText();
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public void waintUntilElementInvisible(By by){
        wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }
    public void waitUntilVisibleAndClick(By by){
        waitUntilElementVisible(by);
        webDriver.findElement(by).click();
    }

    public void sendKeys(By by,String keys){
        webDriver.findElement(by).sendKeys(keys);
    }

    public void clickWithAction(By by){
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webDriver.findElement(by)).click().build().perform();
    }


    public WebElement swipeUntilElement(By by){
        org.openqa.selenium.interactions.Actions actions = new org.openqa.selenium.interactions.Actions(getWebDriver());
        actions.moveToElement(getWebDriver().findElement(by)).build().perform();
        return getWebDriver().findElement(by);
    }

}
