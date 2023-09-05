package galenClasses;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import io.cucumber.java.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.*;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.*;


public class WelcomePageTest  {
    private WebDriver driver;
    @Before
    public void setUp()
    {

        ChromeOptions chromeOptions= new ChromeOptions();
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 390);
        deviceMetrics.put("height", 844);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        chromeOptions.addArguments("--window-size=");
        driver= new ChromeDriver(chromeOptions);
        driver.get("http://www.swtestacademy.com/");
    }
    @Test
    public void homePageLayoutTest() throws IOException
    {
        //Create a layoutReport object
        //checkLayout function checks the layout and returns a LayoutReport object
        LayoutReport layoutReport = Galen.checkLayout(driver, "specs/homepage.gspec", Arrays.asList("desktop"));
        //Create a tests list
        List<GalenTestInfo> tests = new LinkedList<GalenTestInfo>();
        //Create a GalenTestInfo object
        GalenTestInfo test = GalenTestInfo.fromString("homepage layout");
        //Get layoutReport and assign to test object
        test.getReport().layout(layoutReport, "check homepage layout");
        //Add test object to the tests list
        tests.add(test);
        //Create a htmlReportBuilder object
        HtmlReportBuilder htmlReportBuilder = new HtmlReportBuilder();
        //Create a report under /target folder based on tests list
        htmlReportBuilder.build(tests, "target");
        //If layoutReport has errors Assert Fail
        if (layoutReport.errors() > 0)
        {
            Assert.fail("Layout test failed");
        }
    }
    @After
    public void tearDown()
    {
        driver.quit();
    }
}
