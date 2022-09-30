package steps;

import com.thoughtworks.gauge.Step;
import pages.DynamicTablePage;

public class DynamicTableSteps {
    DynamicTablePage dynamicTablePage = new DynamicTablePage();
    @Step("Get Chrome Cpu value")
    public void getCpu() {
dynamicTablePage.getCpuValue();
    }
}
