package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import utilties.Context;
import utilties.Devices;

import java.io.IOException;
import java.util.Properties;


@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty" },
features = {"classpath:features/homepage.feature"},
glue={"stepdefs"},
tags = "@GalenTest",
monochrome = true)
public class TestRunner{
    @BeforeClass
    public static void setup() throws IOException {
        Properties properties =Context.readPropertiesFile("src/test/resources/configs/Config.properties");
        Context.properties=properties;
        Devices device= Devices.DESKTOP.getLabelByOption(properties.getProperty("Device"));
        String browser=properties.getProperty("Browser");
        Context.initiateDriver(browser,device);

    }

}