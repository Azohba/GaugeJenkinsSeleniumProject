package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import utils.BaseActions;

public class DynamicTablePage extends BaseActions {

    private static By valueLBL = By.cssSelector(".bg-warning");

    public void getCpuValue(){
        String columnNumber =null;
        for (int i=1;i<=5;i++){
          if (BaseActions.webDriver.findElement(By.xpath("//*[@role=\"columnheader\"]["+i+"]")).getText().equalsIgnoreCase("CPU")){
              columnNumber = String.valueOf(i);
              logger.info("Find CPU column : ..." + columnNumber);
              break;
          }
       }
       String getChromeCpuValue = BaseActions.webDriver.findElement(By.xpath("//span[contains(text(),'Chrome')]/..//span["+columnNumber+"]")).getText();
        String yellowCpuValur = getText(valueLBL).split(": ")[1];
        Assert.assertEquals("CPU VALUE didn't match",getChromeCpuValue,yellowCpuValur);
    }
}
