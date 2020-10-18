package core;

import helpers.MyLogger;
import helpers.PropertiesFilesLoader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

public class FirefoxDriverManager extends DriverManager {

    private FirefoxDriver driver;
    public WebDriver createDriver() throws ClassNotFoundException {
        PropertiesFilesLoader.getSingleInstance().loadPropertiesFile("environment.properties");
        String firefoxDiverLocation = PropertiesFilesLoader.singleInstance.getPropertyByKey("FIREFOX_DRIVER_LOCATION");
        MyLogger.logger.info("FirefoxDriverLocation is: "+firefoxDiverLocation);
        System.setProperty("webdriver.gecko.driver", firefoxDiverLocation);

        FirefoxOptions options = new FirefoxOptions();
        //options.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        //options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        this.driver = new FirefoxDriver(options);
        this.driver.manage().window().maximize();
        return driver;
    }
}
