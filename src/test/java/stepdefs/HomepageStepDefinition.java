package stepdefs;

import com.galenframework.api.Galen;
import com.galenframework.reports.GalenTestInfo;
import com.galenframework.reports.HtmlReportBuilder;
import com.galenframework.reports.model.LayoutReport;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class HomepageStepDefinition {
    WebDriver driver;

    @Given("user navigates to homepage of application")
    public void navigateToHomepage(){
             driver=  new ChromeDriver();
        //Set the browser size for desktop
       driver.manage().window().setSize(new Dimension(390, 844));
        //Go to swtestacademy.com
        driver.get("http://www.swtestacademy.com/");
    }

    @Then("validate UI layout of homepage")
    public void validateUILayout() throws IOException {
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
}
