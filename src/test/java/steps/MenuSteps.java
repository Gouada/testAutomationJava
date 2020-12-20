package steps;

import helpers.MyLogger;

import constants.Urls;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MenuPage;
import pages.SearchPage;
import pages.StartPage;

import static java.lang.Thread.sleep;

//Menu steps
public class MenuSteps{

    private WebDriver driver = TestCaseBase.driver;
    public static MenuPage menuPage;
    public static StartPage startPage;
    public static SearchPage searchPage;
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
        //MyLogger.logger.info("starting Spiegel");
        driver.get(String.valueOf(Urls.STARTSEITE.getUrl()));
        menuPage = new MenuPage(driver);
        startPage = new StartPage(driver);
        startPage.waitForPageToLoad("DER SPIEGEL | Online-Nachrichten");
        startPage.closeAdversting();

        sleep(3000);
    }

    @Then("I click Akzeptieren und weiter")
    public void i_click_Akzeptieren_und_weiter() throws InterruptedException
    {
        //MyLogger.logger.info("accepting conditions");
        startPage.clickAkzeptieren();
        //sleep(3000);
    }

    @Then("I bring {string} menu into view")
    public void i_bring_top_menu_into_view(String menu) {
        //if(menuPage == null)
          //  menuPage = new MenuPage(driver);
        //try {
            menuPage.click_right_arrow_until_is_visible(menu);
        /*}
        catch (Exception e)
        {
            menuPage.takeScreenhot("bringing_"+menu+"_into_view_");
            MyLogger.logger.error(e.getMessage());
            new Exception(e);
        }
        */

        //menuPage.click_right_arrow();
    }

    @Then("I click TopMenu {string}")
    public void i_click_top_menu(String menu) throws Exception
    {
        try {
            menuPage.clickATopMenu(menu);
            menuPage.closeAdversting();
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            startPage.takeScreenhot("clicking_top_menu");
            throw new Exception(e.getMessage());
        }
    }

    @And("I click TopMenuButton")
    public void i_click_top_menu_button() throws Exception
    {
        try {
            menuPage.click_menu_button();
            //sleep(1000);
            //menuPage.implicitlyWait(3);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            startPage.takeScreenhot("clicking_top_Menu_Button");
            throw new Exception();
        }
    }

    @Then("^I click leftMenu (.*)$")
    public void i_click_leftMenu(String menu ) throws Exception
    {
        try{
            menuPage.clickLeftMenuElement(menu);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            startPage.takeScreenhot("clicking_left_Menu");
            throw new Exception(e.getMessage());
        }
    }

    @Then("^I click leftSubMenu (.*) in (.*)$")
    public void i_click_leftSubMenu(String subMenu, String menu ) throws Exception
    {
        try{
            menuPage.clickLeftSubMenuElement(menu, subMenu);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            startPage.takeScreenhot("clicking_left_subMenu");
            throw new Exception(e.getMessage());
        }
    }

    @Then("^I enter (.*) and press enter$")
    public void i_enter_search_word_and_press_enter(String text) throws Exception {
        try {
            menuPage.search(text);
            searchPage = new SearchPage(driver);
            searchPage.waitForPageToLoad("Suche - DER SPIEGEL");
            Assert.assertTrue(searchPage.i_am_on_results_page());
            //sleep(1000);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            startPage.takeScreenhot("searching_"+text+"_");
            //throw new Exception(e.getMessage());
        }

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
