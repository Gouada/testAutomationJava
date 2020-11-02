package steps;

import constants.Constants;
import core.DriverFactory;
import helpers.MyLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class TestCaseBase {

    public static WebDriver driver;

    @Before //("@start")
    public void setup()
    {
        MyLogger.logger.info("starting test ...");
        driver = DriverFactory.getDriverManager(Constants.CHROME).getDriver();
        //menuPage = new MenuPage(driver);
    }

    @After("@end")
    public void tearDown()
    {
        if(driver != null) {
            driver.quit();
        }
    }
}
