package utilties;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Context {
    private  static WebDriver driver;
    private  static Devices currentDevice;
    public static Properties properties;

    public static Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }

    public String getReportConfigPath(){
        String reportConfigPath = properties.getProperty("reportConfigPath");
        if(reportConfigPath!= null) return reportConfigPath;
        else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
    }

    public static WebDriver initiateDriver(String browser, Devices device) throws IOException {
        if(driver==null) {
            if(browser.equalsIgnoreCase("Chrome")) {
                currentDevice=device;
                ChromeOptions chromeOptions = new ChromeOptions();
                Map<String, Object> deviceMetrics = new HashMap<>();
                deviceMetrics.put("width", device.getWidth());
                deviceMetrics.put("height",device.getHeight());
                Map<String, Object> mobileEmulation = new HashMap<>();
                mobileEmulation.put("deviceMetrics", deviceMetrics);
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                chromeOptions.addArguments("--window-size=");
                driver = new ChromeDriver(chromeOptions);
                driver.manage().window().setSize(new Dimension(device.getWidth(),device.getHeight()));
            }
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static Devices getCurrentDevice(){
       return currentDevice;
    }
}
