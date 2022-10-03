package pageObjects;

import org.openqa.selenium.By;
import utils.BaseActions;

public class HomePage extends BaseActions {

    public void clickHrefLink(String link){
        logger.info("Click Href...");
        By testLink = By.xpath("//*[@href='/"+link+"']");
        clickWithAction(testLink);
    }

}
