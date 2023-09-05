package utilties;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class Context {
    private WebDriver driver;

    public void setDriver(WebDriver driver){
       this.driver=driver;
    }
    public WebDriver getDriver() {
        return driver;
    }
}
