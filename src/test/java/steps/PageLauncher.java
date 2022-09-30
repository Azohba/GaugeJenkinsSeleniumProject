package steps;

import com.thoughtworks.gauge.Step;
import utils.BaseActions;

public class PageLauncher extends BaseActions {
    @Step("Open home page")
    public void goToHomePage() {
       BaseActions.webDriver.navigate().to(System.getenv("URL"));
    }
}
