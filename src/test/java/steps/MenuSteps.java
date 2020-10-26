package steps;

import helpers.MyLogger;

import constants.Constants;
import constants.Urls;
import core.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Level;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;
import pages.MenuPage;

import static java.lang.Thread.sleep;

//Menu steps
public class MenuSteps{

    private WebDriver driver = TestCaseBase.driver;
    public static MenuPage menuPage;
/*
    @Before
    public void init()
    {
        MyLogger.logger.isEnabled(Level.DEBUG);
        //MyLogger.logger.info("starting test ...");
        driver = DriverFactory.getDriverManager(Constants.CHROME).getDriver();
        menuPage = new MenuPage(driver);
    }
*/

    @Given("I start Spiegel")
    public void i_start_Spiegel() throws Throwable
    {
        //driver = DriverFactory.getDriverManager(Constants.CHROME).getDriver();
        MyLogger.logger.info("starting Spiegel");
        TestCaseBase.driver.get(String.valueOf(Urls.STARTSEITE.getUrl()));
        menuPage = new MenuPage(driver);
        sleep(3000);

    }

    @Then("I click Akzeptieren und weiter")
    public void i_click_Akzeptieren_und_weiter() throws InterruptedException
    {
        MyLogger.logger.info("accepting conditions");
        menuPage.clickAkzeptieren();
        sleep(3000);
    }

/*
    @After
    public void endsTest()
    {
        if(driver != null) {
            driver.quit();
        }
    }
*/
}
