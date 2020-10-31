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
        sleep(3000);
    }

    @Then("I paginate to {string} page")
    public void i_paginate_to_next_page(String String) throws Throwable
    {
        if(String.equals("next")) {
            spiegelPlus.paginate("right");
            Assert.assertTrue(spiegelPlus.getCurrentURL().equals("https://www.spiegel.de/plus/p2/"));
            Assert.assertTrue(spiegelPlus.isLeftNavigationVisible());
            sleep(9000);
        }
        else if(String.equals("previous"))
        {
            spiegelPlus.paginate("left");
            //Assert.assertTrue(spiegelPlus.getCurrentURL().equals("https://www.spiegel.de/plus/p2/"));
            //Assert.assertTrue(spiegelPlus.isLeftNavigationVisible());
            sleep(9000);
        }
    }

    @Then("I scroll down")
    public void i_scroll_down() throws InterruptedException {
        spiegelPlus.pageDown();
        sleep(3000);
    }

    @Then("I click first article of {string} section")
    public void i_click_first_article_of_section(String section) throws InterruptedException {
        MyLogger.logger.info("section..........:" + section);
        int sectionNr = 0;
        if (section.equals("first")) sectionNr = 1;
        if(section.equals("random")) sectionNr = spiegelPlus.getRandomSectionNr();
        if(section.equals("audio")) sectionNr = spiegelPlus.getSectionsCount();
        spiegelPlus.clickSectionArticle(sectionNr,1);
        sleep(5000);
    }

    @Then("I go back")
    public void i_go_back() throws Throwable
    {
        spiegelPlus.goBack();
        //spiegelPlus.iClickBackButton();
        //Assert.assertTrue(spiegelPlus.getitle().contains("Plus - DER SPIEGEL"));
        Assert.assertTrue(spiegelPlus.getPageSource().contains("SPIEGEL+"));
        sleep(3000);

    }

    @Then("I click last article of {string} section")
    public void i_click_last_article_of_section(String section) throws Throwable
    {
        int sectionNr = 0;
        if(section.equals("first"))
            sectionNr=1;
        if(section.equals("random"))
            sectionNr = spiegelPlus.getRandomSectionNr();
        if(section.equals("audio"))
            sectionNr = spiegelPlus.getSectionsCount();
        spiegelPlus.clickSectionLastArticle(sectionNr);
        sleep(3000);
    }

    @Then("I click a random article of {string} section")
    public void i_click_an_random_article_of_section(String section) throws Throwable
    {
        int sectionNr =0;
        if(section.equals("first"))
            sectionNr=1;
        if(section.equals("random"))
            sectionNr = spiegelPlus.getRandomSectionNr();
        if(section.equals("audio"))
            sectionNr = spiegelPlus.getSectionsCount();

        System.out.println("section..........:" + section + "sectionNr......:"+sectionNr);
        spiegelPlus.clickSectionRandomArticle(sectionNr);
        sleep(3000);
    }

    @Then("I scroll to {string} section")
    public void i_scroll_to_section(String section)
    {
        if(section.equals("alle_Beitraege"))
        {
            spiegelPlus.scrollto(section);
        }
        else {
            int sectionNr =0;
            if (section.equals("first"))
                sectionNr = 1;
            if (section.equals("random"))
                sectionNr = spiegelPlus.getRandomSectionNr();
            if (section.equals("audio"))
                sectionNr = spiegelPlus.getSectionsCount();
            spiegelPlus.scrollToSection(sectionNr);
        }
    }

    @Then("I scroll to alle Beitraege {string} article")
    public void  i_scroll_to_alle_Beitraegearticle(String position)throws Throwable
    {
        if(position.equals("random"))
            spiegelPlus.scrollToRandomArticleOfAlleBeitraegeSection();
        if(position.equals("last"))
            spiegelPlus.scrollToAlleBeitraegeSectionLastArticle();
        //else spiegelPlus.scrollToAlleBeitraegeSectionArticle(Integer.parseInt(position));
    }

    @Then("I click a {string} article of alle Beitraege section")
    public void i_click_article_of_alle_Beitraege_section(String position) throws Throwable
    {
        if(position.equals("random"))
            spiegelPlus.clickRandomArticleOfAlleBeitraegeSection();
        if(position.equals("last"))
            spiegelPlus.clickAlleBeitraegeSectionLastArticle();
        //else spiegelPlus.clickAlleBeitraegeSectionArticle(Integer.parseInt(position));
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
