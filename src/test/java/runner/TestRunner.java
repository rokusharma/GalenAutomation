package runner;

import cucumber.api.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import utilties.Context;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
features = {"resources/features"},
glue={"stepdefs"},
tags={"@GalenTest"})
public class TestRunner{
    WebDriver driver;
    private Context context;




}