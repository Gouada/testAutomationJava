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

        options.addArguments("start-maximized"); // https://stackoverflow.com/a/26283818/1689770
        options.addArguments("enable-automation"); // https://stackoverflow.com/a/43840128/1689770
        //options.addArguments("--headless"); // only if you are ACTUALLY running headless
        options.addArguments("--no-sandbox"); //https://stackoverflow.com/a/50725918/1689770
        options.addArguments("--disable-infobars"); //https://stackoverflow.com/a/43840128/1689770
        options.addArguments("--disable-dev-shm-usage"); //https://stackoverflow.com/a/50725918/1689770
        options.addArguments("--disable-browser-side-navigation"); //https://stackoverflow.com/a/49123152/1689770
        options.addArguments("--disable-gpu"); //https://stackoverflow.com/questions/51959986/how-to-solve-selenium-chromedriver-timed-out-receiving-message-from-renderer-exc

        this.driver = new ChromeDriver(options);
        //this.driver.manage().window().maximize();

        return this.driver;
    }
}
