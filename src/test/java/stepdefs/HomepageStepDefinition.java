package stepdefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import utilties.Context;
import utilties.GalenChecks;
import java.io.IOException;


public class HomepageStepDefinition {
WebDriver driver;
    public HomepageStepDefinition() {
        this.driver=Context.getDriver();
    }

    @Given("user navigates to homepage of application")
    public void navigateToHomepage(){
;        driver.get("http://www.swtestacademy.com/");
    }

    @Then("validate UI layout of homepage")
    public void validateUILayout() throws IOException {
         new GalenChecks().performGalenChecks("homepage.gspec");
    }
}
