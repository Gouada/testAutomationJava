package steps;

import helpers.MyLogger;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.StartPage;

import static java.lang.Thread.sleep;

public class StartpageSteps{

    StartPage startPage = new StartPage(TestCaseBase.driver);

    @Then("I click start page main_article")
    public void i_click_start_page_main_article() throws Exception {
        try{
            startPage.clickOnStarPage("main_article");
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            startPage.takeScreenhot("click_main_article");
            throw new Exception(e.getMessage());
        }
    }

    @And("I scroll to {string} on start page")
    public void i_scroll_to_section_on_start_page(String section) throws Exception {
        try {
            startPage.scrollOnStartPageToSection(section);
            sleep(1000);
            //startPage.takeScreenhot("scrolled_");
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            startPage.takeScreenhot("scrolling_to_section_"+section);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^On start page I click (.*) article of (.*)$")
    public void i_click_article_of(String article, String section) throws Exception {
        try {
            startPage.clickSectionArticle(article, section);
            //sleep(1000);
            //startPage.takeScreenhot("clicking_article_");
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            startPage.takeScreenhot("on:start_page_clicking_"+article+"_article_of_"+section);
            throw new Exception(e.getMessage());
        }
    }

    @Then("^I scroll to (.*) article of (.*)$")
    public void i_scroll_to_article_section(String article, String section) throws Exception {
        try {
            startPage.scrollToSectionArticle(article,section);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            startPage.takeScreenhot("scrolling_to"+article+"_article_of_"+section);
            throw new Exception(e.getMessage());
        }
    }

    @Then("I click {int} times {string} section arrow {string}")
    public void i_click_section_arrow(int clicks, String section, String direction) throws Exception {
        try {
            startPage.clickSectionRightLeftArrow(section, direction, clicks);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            startPage.takeScreenhot("clicking_arrow_"+direction+"_"+section);
            throw new Exception(e.getMessage());
        }
    }

    @Then("I click dow jones")
    public void i_click_dow_jones() throws Exception {
        try {
            startPage.clickStockSectionElement(1);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            startPage.takeScreenhot("clicking_dow_jones_");
            throw new Exception(e.getMessage());
        }
    }

    @Then("I switch to {string} tab")
    public void switch_to_stock_tab(String tab) throws Exception {
        try {
            if (tab.equals("dow jones"))
                startPage.switchToTab(1);
            if (tab.equals("spiegel"))
                startPage.switchToTab(0);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            startPage.takeScreenhot("switching_tab");
            throw new Exception(e.getMessage());
        }
    }
}
