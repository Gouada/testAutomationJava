package steps;

import constants.Constants;
import core.DriverFactory;
import helpers.MyLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.logging.log4j.Level;
import org.openqa.selenium.WebDriver;
import pages.MenuPage;

public class TestCaseBase {

    public static WebDriver driver;
    //public static MenuPage menuPage;

    @Before //("@start")
    public void setup()
    {
        //MyLogger.logger.isEnabled(Level.DEBUG);
        MyLogger.logger.trace("start logging");
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
