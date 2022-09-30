package pages;

import org.openqa.selenium.By;
import utils.BaseActions;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DynamicTablePage extends BaseActions {


    public void getCpuValue(){
        int columnNumber;
       for (int i=1;i<=5;i++){
          if (webDriver.findElement(By.xpath("//*[@role=\"columnheader\"]["+i+"]")).getText().equalsIgnoreCase("CPU")){
              columnNumber = i;
              break;
          }
       }
       int i = 1;
       while ()

    }
}
