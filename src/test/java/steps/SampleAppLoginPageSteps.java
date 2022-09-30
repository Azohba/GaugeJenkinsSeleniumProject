package steps;

import com.thoughtworks.gauge.Step;
import pages.SampleAppLoginPage;

public class SampleAppLoginPageSteps {
    SampleAppLoginPage sampleAppLoginPage = new SampleAppLoginPage();

    @Step("Enter username and password")
    public void enterUserName() {
        sampleAppLoginPage.enterUserNameAndPassword();
    }

    @Step("Click Log In button")
    public void clickLogin() {
        sampleAppLoginPage.clickLoginButton();
    }

    @Step("Check <failedLogin,successLogin,loggedOut> login status")
    public void checkLoginStatus(String status) {
        sampleAppLoginPage.checkLoginStatus(status);
    }

    @Step("Enter <username> and <password>")
    public void implementation1(String username, String pass) {

    }
}
