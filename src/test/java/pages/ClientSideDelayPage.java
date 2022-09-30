package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import utils.BaseActions;

public class ClientSideDelayPage extends BaseActions {

    private static By triggerBTN = By.cssSelector("[id='ajaxButton']");
    private static By loadingIcon = By.id("spinner");
    private static By successMessageLBL = By.cssSelector(".bg-success");


     Integer timez;
    public void clickTriggerButton(Integer times){
        timez = times;
        String pageTitle = getTitle();
        Assert.assertEquals("You're in the wrong page","Client Side Delay",pageTitle);
        int i = 1;
        while (i<=times){
           waitUntilVisibleAndClick(triggerBTN);
           waintUntilElementInvisible(loadingIcon);
           i++;
        }
    }

     public void checkSuccessMessage(){
        Integer messageCount = webDriver.findElements(successMessageLBL).size();
        Assert.assertEquals("Message Count did not match",timez,messageCount);
        String message = getText(successMessageLBL);
        Assert.assertEquals("Success Message cannot displayed","Data calculated on the client side.",message);
     }
}
