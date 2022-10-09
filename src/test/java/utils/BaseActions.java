package utils;

import com.thoughtworks.gauge.AfterSuite;
import com.thoughtworks.gauge.BeforeScenario;
import com.thoughtworks.gauge.BeforeSuite;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class BaseActions {
    public static Logger logger = Logger.getLogger(String.valueOf(BaseActions.class));
    public static WebDriver webDriver;
    public static WebDriverWait wait;

    @BeforeSuite
    public WebDriver getWebDriver(){
        deleteScreenShots();
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
        if (webDriver!=null){
            webDriver.quit();
        }
        logger.info("Webdriver closed!!");
        Calliope calliope = new Calliope();
        calliope.zipSS();
        calliope.setRequest();

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

     void deleteScreenShots(){
        try{
            File folder = new File(".gauge/screenshots");
            File fList[] = folder.listFiles();

            for (File f : fList) {
                if (f.getName().endsWith(".png")) {
                    f.delete();
                }}
        }catch (Exception e){
            logger.info("Screenshots cannot deleted");
        }
    }

}
