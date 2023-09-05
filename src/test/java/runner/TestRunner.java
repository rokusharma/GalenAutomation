package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty"},
features = {"classpath:features"},
glue={"stepdefs"},
tags = "@GalenTest",
monochrome = true)
public class TestRunner{




}