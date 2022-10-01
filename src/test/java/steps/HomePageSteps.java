package steps;

import com.thoughtworks.gauge.Step;
import pageObjects.HomePage;


public class HomePageSteps {
    HomePage homePage = new HomePage();
    @Step("Click <sampleapp,dynamictable,clientdelay> href link")
    public void clickTestLink(String link) {
        homePage.clickHrefLink(link);
    }
}
