package steps;

import helpers.MyLogger;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import pages.ArticlesListBasePage;

import static java.lang.Thread.sleep;

public class HelperSteps {

    private  ArticlesListBasePage page = new ArticlesListBasePage(TestCaseBase.driver);

    @Then("I scroll to bottom")
    public void i_scroll_to_bottom()
    {
        try {
            page.scrollDownToBottom();
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            page.takeScreenhot("i_scroll_to_bottom");
            e.printStackTrace();
        }
    }

    @Then("I scroll to top")
    public void i_scroll_to_top()
    {
        try{
            page.scrollUpToTop();
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            page.takeScreenhot("i_scroll_to_top");
            e.printStackTrace();
        }
    }

    @Then("I click page down {int}")
    public void i_click_page_down(int count)
    {
        try{
            page.pageDown(count);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            page.takeScreenhot("i_click_page_down");
            e.printStackTrace();
        }
    }

    @Then("I click page up {int}")
    public void i_click_page_up(int count)
    {
        try{
        page.pageUp(count);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            page.takeScreenhot("i_click_page_up");
            e.printStackTrace();
        }
    }

    @Then("I click arrow down {int}")
    public void i_click_arrow_down(int count)
    {
        try {
            page.arrowDown(count);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            page.takeScreenhot("i_click_arrow_down");
            e.printStackTrace();
        }
    }

    @Then("I click arrow up {int}")
    public void i_click_arrow_up(int count)
    {
        try {
            page.arrowUp(count);
        }
        catch (Exception e)
            {
                MyLogger.logger.error(e.getMessage());
                page.takeScreenhot("i_click_arrow_up");
                e.printStackTrace();
            }
    }

    @Then("I go back to {string}")
    public void i_go_back_to(String title) throws Exception {
        try {
            page.goBack();
            sleep(500);
            //spiegelPlus.iClickBackButton();
            page.waitForPageToLoad(title);
            //page.implicitlyWait(5);
            Assert.assertTrue(page.getitle().contains(title));
            //Assert.assertTrue(page.getPageSource().contains("SPIEGEL+"));
        }
        catch (AssertionError  e)
        {
            MyLogger.logger.error("Step 'i_go_back': "+e.getMessage());
            page.takeScreenhot("i_go_back_to_" + title);
            e.printStackTrace();
            throw new AssertionError();
        }
        catch (Exception  e)
        {
            MyLogger.logger.error("Step 'i_go_back': "+e.getMessage());
            page.takeScreenhot("i_go_back_to_" + title);
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
    }

    @Then("I scroll to alle Beitraege {string} article")
    public void  i_scroll_to_alle_Beitraegearticle(String position)
    {
        try {
            if (position.equals("random"))
                page.scrollToRandomArticleOfAlleBeitraegeSection();
            if (position.equals("last"))
                page.scrollToAlleBeitraegeSectionLastArticle();
            //else spiegelPlus.scrollToAlleBeitraegeSectionArticle(Integer.parseInt(position));
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            page.takeScreenhot("i_scroll_to_alle_Beitraegea_random_article");
            e.printStackTrace();
            throw new AssertionError();
        }
    }

    @Then("I click a {string} article of alle Beitraege section")
    public void i_click_article_of_alle_Beitraege_section(String position)
    {
        try {
            if (position.equals("random"))
                page.clickRandomArticleOfAlleBeitraegeSection();
            if (position.equals("last"))
                page.clickAlleBeitraegeSectionLastArticle();
            if (position.equals("first"))
                page.clickAlleBeitraegeElement(1);
            //else spiegelPlus.clickAlleBeitraegeSectionArticle(Integer.parseInt(position));
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            page.takeScreenhot("i_click_article_of_alle_Beitraege_section");
            e.printStackTrace();
            throw new AssertionError();
        }
    }

    @Then("I paginate to {string} page")
    public void i_paginate_to_next_page(String direction)
    {
        try {
            if (direction.equals("next")) {
                page.paginate("right");
                //page.implicitlyWait(5);
                //Assert.assertTrue(page.getCurrentURL().contains("spiegel.de/plus/p2/"));
                Assert.assertTrue(page.isLeftNavigationVisible());
                //sleep(3000);
            } else if (direction.equals("previous")) {
                page.paginate("left");
                //Assert.assertTrue(spiegelPlus.getCurrentURL().equals("https://www.spiegel.de/plus/p2/"));
                //Assert.assertTrue(spiegelPlus.isLeftNavigationVisible());
                //page.implicitlyWait(5);
                //sleep(5000);
            }
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            page.takeScreenhot("i_paginate_to_"+direction+"_page");
            e.printStackTrace();
        }
    }

    @Then("I close the tab")
    public void i_close_the_tab()
    {
        page.switchToTab(0);
        page.switch_back_toDefault();
    }

    @When("A new tab is opened")
    public boolean new_tab_is_opened()
    {
        if(page.getTabCount() > 1)
            return true;
        else return false;
    }
}
