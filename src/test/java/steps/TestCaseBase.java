package steps;

import constants.Constants;
import core.DriverFactory;
import core.DriverManager;
import helpers.MyLogger;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class TestCaseBase {

    public static WebDriver driver;
    public Step step;
    @Before(value="@start")
    public void setup()
    {
        MyLogger.logger.info("starting test ...");
        System.out.println("starting test ...");
        //if(driver == null)
            driver = DriverFactory.getDriverManager(Constants.CHROME).getDriver();
        //menuPage = new MenuPage(driver);
    }

    @After(value="@end")
    public void tearDown()
    {
        if(driver != null) {
            driver.quit();
            DriverManager.driver = null;
            driver=null;
        }
    }

    @AfterStep
    public void takeScreenShotOnError(Scenario scenario)
    {
        if(scenario.isFailed())
        {
            BasePage page = new BasePage(driver);
            System.out.println("screenshot name ist: ");
            String stepName = scenario.getName().replace(" ", "_")+ "_at_line_"+scenario.getLine().toString();

            System.out.println(stepName);
            page.takeScreenhot("from_hook_error"+stepName);
        }
    }

}
