package steps;

import constants.Constants;
import constants.Menu;
import core.DriverFactory;
import helpers.MyLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Level;

import org.openqa.selenium.WebDriver;
import pages.MenuPage;

import static java.lang.Thread.sleep;

public class SpiegelPlusSteps {

    /*
    private WebDriver driver;
    private MenuPage menuPage;

    @Before
    public void init()
    {
        MyLogger.logger.isEnabled(Level.DEBUG);
        MyLogger.logger.info("starting test ...");
        driver = DriverFactory.getDriverManager(Constants.CHROME).getDriver();
        menuPage = new MenuPage(driver);
    }
*/
    @Then("I click SpiegelPlus")
    public void clickSpiegelPlus()  throws Throwable
    {
        MenuSteps.menuPage.clickATopMenu(Menu.SPIEGEL_PLUS);
        sleep(5000);
    }
/*
    @After
    public void endsTest()
    {
        if(driver != null) {
            driver.close();
            //driver.quit();
        }
    }
*/
}
