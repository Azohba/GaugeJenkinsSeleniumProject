package steps;

import com.thoughtworks.gauge.Step;
import pageObjects.ClientSideDelayPage;

public class ClientDelayPageSteps {
    ClientSideDelayPage clientDelayPage = new ClientSideDelayPage();

    @Step("Check success messages")
    public void checkSuccessMessages() {
        clientDelayPage.checkSuccessMessage();
    }

    @Step("Click <> times to Client Side button")
    public void clickTriggerBtn(Integer times) {
        clientDelayPage.clickTriggerButton(times);
    }
}
