package utils;

import com.thoughtworks.gauge.BeforeSuite;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverSetup {
    private static WebDriver webDriver;
    static String browser = System.getenv("browser");
    static String env = System.getenv("environment");

    public static WebDriver setup() {
        switch (env) {
            case "MobileWeb":
                if (browser.equalsIgnoreCase("Chrome")) {
                    System.setProperty("webdriver.chrome.driver", "src//test//java//resources//chromedriver.exe");
                    Map<String, String> mobileEmulation = new HashMap<>();
                    mobileEmulation.put("deviceName", "Nexus 5");
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                    chromeOptions.addArguments("start-maximized");
                    chromeOptions.addArguments("enable-automation");
                    chromeOptions.addArguments("--disable-popup-blocking");
                    chromeOptions.addArguments("--disable-notifications");
                    webDriver = (new ChromeDriver(chromeOptions));

                }
                break;
            case "Web":
                if (browser.equalsIgnoreCase("Chrome")) {
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("start-maximized");
                    chromeOptions.addArguments("enable-automation");
                    chromeOptions.addArguments("--disable-popup-blocking");
                    chromeOptions.addArguments("--disable-notifications");
                    webDriver = (new ChromeDriver(chromeOptions));
                }else if (browser.equalsIgnoreCase("Mozilla")){
                    WebDriverManager.firefoxdriver().setup();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("start-maximized");
                    firefoxOptions.addArguments("enable-automation");
                    firefoxOptions.addArguments("--disable-popup-blocking");
                    firefoxOptions.addArguments("--disable-notifications");
                    webDriver = (new FirefoxDriver(firefoxOptions));
                }
                break;

        }
        return webDriver;
    }


}
