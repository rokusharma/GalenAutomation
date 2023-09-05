package runner;

import io.cucumber.testng.*;


@CucumberOptions(
features = {"src/test/resources/features"},
        glue = {"stepdefs"},
        tags = "@GalenTest",
        plugin = "json:target/cucumber-reports/CucumberTestReport.json")

public class TestRunner extends AbstractTestNGCucumberTests{



}