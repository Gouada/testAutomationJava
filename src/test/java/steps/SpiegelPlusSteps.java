package steps;

import com.fasterxml.jackson.databind.jsontype.impl.AsPropertyTypeSerializer;
import constants.Constants;
import constants.Menu;
import core.DriverFactory;
import helpers.MyLogger;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import org.apache.logging.log4j.Level;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.MenuPage;
import pages.SpiegelPlus;

import static java.lang.Thread.sleep;

public class SpiegelPlusSteps {

    private SpiegelPlus spiegelPlus;

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
        spiegelPlus = new SpiegelPlus(TestCaseBase.driver);
        MenuSteps.menuPage.clickATopMenu(Menu.SPIEGEL_PLUS);
        Assert.assertTrue(spiegelPlus.getitle().contains("Plus - DER SPIEGEL"));
        Assert.assertTrue(spiegelPlus.getPageSource().contains("SPIEGEL+"));
        sleep(5000);
    }

    @Then("I paginate to next page")
    public void i_paginate_to_next_page() throws Throwable
    {
        spiegelPlus.paginate("right");
        sleep(5000);
    }

    @Then("I scroll down")
    public void i_scroll_down() throws InterruptedException {
        spiegelPlus.pageDown();
        sleep(5000);
    }

    @Then("I click first article of first section")
    public void i_click_first_article_of_first_section()
    {
        spiegelPlus.clickSectionArticle(1,1);
    }

    @Then("I go back")
    public void i_go_back() throws Throwable
    {
        spiegelPlus.goBack();
    }

    @Then("I click last article of first section")
    public void i_click_last_article_of_first_section() throws Throwable
    {
        spiegelPlus.clickSectionArticle(1,5);
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
