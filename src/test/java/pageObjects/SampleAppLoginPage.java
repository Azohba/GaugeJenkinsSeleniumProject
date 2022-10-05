package pageObjects;

import models.UserInfoModel;
import org.junit.Assert;
import org.openqa.selenium.By;
import utils.BaseActions;

import java.util.logging.Logger;

public class SampleAppLoginPage extends BaseActions {


    UserInfoModel userInfoModel = new UserInfoModel();

    private static By usernameTXT = By.name("UserName");
    private static By passwordTXT = By.name("Password");
    private static By logInBTN = By.id("login");
    private static By logInStatusLBL = By.id("loginstatus");

    public void enterUserNameAndPassword(){
        logger.info("Insert Login credentials...");
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
        logger.info("Click Login Button...");
        waitUntilVisibleAndClick(logInBTN);
    }

    public void checkLoginStatus(String status){
        logger.info("Check login status...");
        waitUntilElementVisible(logInStatusLBL);
        String loginStatus = getText(logInStatusLBL);
        switch (status){
            case "successLogin":
                Assert.assertEquals("Invalid Username/Password",loginStatus,"Welcome, "+userInfoModel.getUserName()+"!");
                break;
            case "failedDLogin":
                Assert.assertEquals("Error message did not match!!!","Invalid username/password",loginStatus);
                break;
            case "loggedOut":
                Assert.assertEquals("Error message did not match!!!","User logged out.",loginStatus);
                break;
            default:
                    Assert.fail("Are you sure your status text" + status);

        }

        }
    }

