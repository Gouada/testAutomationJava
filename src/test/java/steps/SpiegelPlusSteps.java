package steps;

import constants.Menu;
import helpers.MyLogger;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.SpiegelPlus;
import static java.lang.Thread.sleep;

public class SpiegelPlusSteps{

    private SpiegelPlus spiegelPlus;

    @Then("I click SpiegelPlus")
    public void clickSpiegelPlus()
    {
        try {
            spiegelPlus = new SpiegelPlus(TestCaseBase.driver);
            MenuSteps.menuPage.clickATopMenu(Menu.SPIEGEL_PLUS);
            Assert.assertTrue(spiegelPlus.getitle().contains("Plus - DER SPIEGEL"));
            Assert.assertTrue(spiegelPlus.getPageSource().contains("SPIEGEL+"));
            //sleep(3000);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            spiegelPlus.takeScreenhot("i_click_Spiegel_Plus");
            e.printStackTrace();
            throw new AssertionError();
        }
    }

    @Then("I paginate to {string} page")
    public void i_paginate_to_next_page(String direction) throws Throwable
    {
        //try {
            if (direction.equals("next")) {
                spiegelPlus.paginate("right");
                spiegelPlus.implicitlyWait(5);
                Assert.assertTrue(spiegelPlus.getCurrentURL().contains("spiegel.de/plus/p2/"));
                Assert.assertTrue(spiegelPlus.isLeftNavigationVisible());
                //sleep(3000);
            } else if (direction.equals("previous")) {
                spiegelPlus.paginate("left");
                //Assert.assertTrue(spiegelPlus.getCurrentURL().equals("https://www.spiegel.de/plus/p2/"));
                //Assert.assertTrue(spiegelPlus.isLeftNavigationVisible());
                spiegelPlus.implicitlyWait(5);
            }
        //}
        /*catch (Exception e)
            {
                MyLogger.logger.error(e.getMessage());
                spiegelPlus.takeScreenhot("i_paginate_to_"+direction+"_page");
                e.printStackTrace();
                throw new Exception();
            }
         */
    }

    @Then("I scroll down")
    public void i_scroll_down() throws Exception {
        try {
            spiegelPlus.pageDown();
            //sleep(3000);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            spiegelPlus.takeScreenhot("i_scroll_down");
            e.printStackTrace();
            throw new Exception();
        }
    }

    @Then("I click first article of {string} section")
    public void i_click_first_article_of_section(String section) {
        try {
            int sectionNr = 0;
            if (section.equals("first")) sectionNr = 1;
            if (section.equals("random")) sectionNr = spiegelPlus.getRandomSectionNr();
            if (section.equals("audio")) sectionNr = spiegelPlus.getSectionsCount();
            spiegelPlus.clickSectionArticle(sectionNr, 1);
            //sleep(3000);
        }catch (Exception e)
        {
            MyLogger.logger.error("Step: i_click_first_article_of_"+section+"_section: " + e.getMessage());
            spiegelPlus.takeScreenhot("i_click_first_article_of_"+section+"_section");
            e.printStackTrace();
            throw new AssertionError();
        }
    }

    @Then("I go back to {string}")
    public void i_go_back_to(String title) {
        try {
            spiegelPlus.goBack();
            //spiegelPlus.iClickBackButton();
            spiegelPlus.waitForPageToLoad(title);
            //spiegelPlus.implicitlyWait(5);
            Assert.assertTrue(spiegelPlus.getitle().contains(title));
            Assert.assertTrue(spiegelPlus.getPageSource().contains("SPIEGEL+"));
            //sleep(10000);
        }catch (Exception e)
        {
            MyLogger.logger.error("Step 'i_go_back': "+e.getMessage());
            spiegelPlus.takeScreenhot("i_go_back");
            e.printStackTrace();
            throw new AssertionError();
        }

    }

    @Then("I click last article of {string} section")
    public void i_click_last_article_of_section(String section) throws Exception {
        try {
            int sectionNr = 0;
            if (section.equals("first"))
                sectionNr = 1;
            if (section.equals("random"))
                sectionNr = spiegelPlus.getRandomSectionNr();
            if (section.equals("audio"))
                sectionNr = spiegelPlus.getSectionsCount();
            spiegelPlus.clickSectionLastArticle(sectionNr);
            //sleep(3000);
        }catch (Exception e)
        {
            MyLogger.logger.error("Step 'i_click_last_article_of_"+section+"_section': " +e.getMessage());
            spiegelPlus.takeScreenhot("i_click_last_article_of_"+section+"_section");
            e.printStackTrace();
            throw new Exception();
        }
    }

    @Then("I click a random article of {string} section")
    public void i_click_an_random_article_of_section(String section)
    {
        try {
            int sectionNr = 0;
            if (section.equals("first"))
                sectionNr = 1;
            if (section.equals("random"))
                sectionNr = spiegelPlus.getRandomSectionNr();
            if (section.equals("audio"))
                sectionNr = spiegelPlus.getSectionsCount();
            spiegelPlus.clickSectionRandomArticle(sectionNr);
            //sleep(3000);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            spiegelPlus.takeScreenhot("i_click_an_random_article_of_"+section+"_section");
            e.printStackTrace();
            throw new AssertionError();
        }
    }

    @Then("I scroll to {string} section")
    public void i_scroll_to_section(String section)
    {
        try {
            if (section.equals("alle_Beitraege")) {
                spiegelPlus.scrollto(section);
            } else {
                int sectionNr = 0;
                if (section.equals("first"))
                    sectionNr = 1;
                if (section.equals("random"))
                    sectionNr = spiegelPlus.getRandomSectionNr();
                if (section.equals("audio"))
                    sectionNr = spiegelPlus.getSectionsCount();
                spiegelPlus.scrollToSection(sectionNr);
            }
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            spiegelPlus.takeScreenhot("i_click_an_random_article_of_"+section+"_section");
            e.printStackTrace();
            throw new AssertionError();
        }
    }

    @Then("I scroll to alle Beitraege {string} article")
    public void  i_scroll_to_alle_Beitraegearticle(String position)
    {
        try {
            if (position.equals("random"))
                spiegelPlus.scrollToRandomArticleOfAlleBeitraegeSection();
            if (position.equals("last"))
                spiegelPlus.scrollToAlleBeitraegeSectionLastArticle();
            //else spiegelPlus.scrollToAlleBeitraegeSectionArticle(Integer.parseInt(position));
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            spiegelPlus.takeScreenhot("i_scroll_to_alle_Beitraegea_random_article");
            e.printStackTrace();
            throw new AssertionError();
        }
    }

    @Then("I click a {string} article of alle Beitraege section")
    public void i_click_article_of_alle_Beitraege_section(String position)
    {
        try {
            if (position.equals("random"))
                spiegelPlus.clickRandomArticleOfAlleBeitraegeSection();
            if (position.equals("last"))
                spiegelPlus.clickAlleBeitraegeSectionLastArticle();
            //else spiegelPlus.clickAlleBeitraegeSectionArticle(Integer.parseInt(position));
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            spiegelPlus.takeScreenhot("i_click_article_of_alle_Beitraege_section");
            e.printStackTrace();
            throw new AssertionError();
        }
    }
}
