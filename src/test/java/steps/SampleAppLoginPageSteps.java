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

    @Step("Check login status")
    public void checkLoginStatus() {
    sampleAppLoginPage.checkLoginStatus();
    }
}
