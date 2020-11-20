package steps;

import constants.Menu;
import helpers.MyLogger;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.SpiegelPlus;
import static java.lang.Thread.sleep;

public class SpiegelPlusSteps{

    private SpiegelPlus spiegelPlus = new SpiegelPlus(TestCaseBase.driver);

    @Then("I click SpiegelPlus")
    public void clickSpiegelPlus()
    {
        try {
            //spiegelPlus = new SpiegelPlus(TestCaseBase.driver);
            MenuSteps.menuPage.clickATopMenu(Menu.SPIEGEL_PLUS);
            spiegelPlus.waitForPageToLoad("Plus - DER SPIEGEL");
            Assert.assertTrue(spiegelPlus.getitle().contains("Plus - DER SPIEGEL"));
            //Assert.assertTrue(spiegelPlus.getPageSource().contains("SPIEGEL+"));
            //sleep(3000);
        }
        catch (AssertionError e)
        {
            MyLogger.logger.error(e.getMessage());
            spiegelPlus.takeScreenhot("i_click_Spiegel_Plus");
            e.printStackTrace();
            //throw new AssertionError();
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            spiegelPlus.takeScreenhot("i_click_Spiegel_Plus");
            e.printStackTrace();
            //throw new AssertionError();
        }
    }

    @Then("I click first article of {string} section")
    public void i_click_first_article_of_section(String section) {
        try {
            //if(spiegelPlus == null)
              //  spiegelPlus = new SpiegelPlus(TestCaseBase.driver);
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
            //throw new AssertionError();
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
            //throw new Exception();
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
            sleep(1000);
            if(spiegelPlus.getTabCount()>1)
                spiegelPlus.switchToTab(0);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            spiegelPlus.takeScreenhot("i_click_an_random_article_of_"+section+"_section");
            e.printStackTrace();
            //throw new AssertionError();
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
            //throw new AssertionError();
        }
    }

}
