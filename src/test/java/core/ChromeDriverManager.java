package core;

import helpers.PropertiesFilesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;

public class ChromeDriverManager extends DriverManager{

    private ChromeDriver driver;
    public WebDriver createDriver() {
        try {
            PropertiesFilesLoader.getSingleInstance().loadPropertiesFile("environment.properties");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String CHROME_DRIVER_LOCATION = PropertiesFilesLoader.getSingleInstance().getPropertyByKey("CHROME_DRIVER_LOCATION");
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_LOCATION);
        ChromeOptions options = new ChromeOptions();
        options.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        this.driver = new ChromeDriver(options);
        this.driver.manage().window().maximize();

        return this.driver;
    }
}
