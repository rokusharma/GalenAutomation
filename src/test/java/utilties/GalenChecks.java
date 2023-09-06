package utilties;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.collections.CollectionUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class GalenChecks {

    WebDriver driver=Context.getDriver();


    public  void performGalenChecks(String gspecFile) throws IOException {
        //Create a layoutReport object
        //checkLayout function checks the layout and returns a LayoutReport object
        LayoutReport layoutReport = Galen.checkLayout(driver, "specs/"+gspecFile, Arrays.asList(Context.getCurrentDevice().getDeviceName()));
        //Create a tests list
        layoutReport.setTitle("Galen Test Report for : "+gspecFile);
        List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();
        //Create a GalenTestInfo object
        GalenTestInfo test = GalenTestInfo.fromString(layoutReport.getTitle()+ " report");
        //Get layoutReport and assign to test object
        test.getReport().layout(layoutReport, layoutReport.getTitle()+ " validating page layout");
        //Add test object to the tests list
        tests.add(test);
        //Create a htmlReportBuilder object
        boolean errors= CollectionUtils.hasElements(layoutReport.getValidationErrorResults());
        HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
        //Create a report under /target folder based on tests list
        htmlReportBuilder.build(tests, "target");
        //If layoutReport has errors Assert Fail
        if (errors)
        {
            Assert.fail("Layout test failed");
        }
    }
}
