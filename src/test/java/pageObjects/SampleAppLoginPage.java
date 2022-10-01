package pageObjects;

import models.UserInfoModel;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.BaseActions;

import java.util.logging.Logger;

public class SampleAppLoginPage extends BaseActions {

    private static Logger logger = Logger.getLogger(String.valueOf(BaseActions.class));
    UserInfoModel userInfoModel = new UserInfoModel();

    private static By usernameTXT = By.name("UserName");
    private static By passwordTXT = By.name("Password");
    private static By logInBTN = By.id("login");
    private static By logInStatusLBL = By.id("loginstatus");

    public void enterUserNameAndPassword(){
        waitUntilElementVisible(usernameTXT);
        String loginStatus = getText(logInStatusLBL);
        if (loginStatus.equalsIgnoreCase("User logged out.")) {
            logger.info("User logged out...  You can login if you want...");
            sendKeys(usernameTXT,System.getenv("username"));
            userInfoModel.setUserName(System.getenv("username"));
            sendKeys(passwordTXT,System.getenv("password"));
            userInfoModel.setPassword(System.getenv("password"));
        }
    }

    public void clickLoginButton(){
        waitUntilVisibleAndClick(logInBTN);
    }

    public void checkLoginStatus(String status){
        waitUntilElementVisible(logInStatusLBL);
        String loginStatus = getText(logInStatusLBL);
        switch (status){
            case "successLogin":
                Assert.assertEquals("Invalid Username/Password",loginStatus,"Welcome, "+userInfoModel.getUserName()+"!");
                break;
            case "failedLogin":
                Assert.assertEquals("Error message did not match!!!","Invalid username/password",loginStatus);
                break;
            case "loggedOut":
                Assert.assertEquals("Error message did not match!!!","User logged out.",loginStatus);
                break;
        }

        }
    }

