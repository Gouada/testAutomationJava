package steps;

import helpers.MyLogger;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.MenuPage;
import pages.SearchPage;

import static java.lang.Thread.sleep;

public class SearchPageSteps {

    private MenuPage menuPage = new MenuPage(TestCaseBase.driver);
    private SearchPage searPage = new SearchPage(TestCaseBase.driver);

    @Then("I click weiter {int}")
    public void i_click_weiter(int clicks) throws Exception {
        try {
            searPage.clickWeiter(clicks);
            Assert.assertTrue(searPage.i_am_on_results_page());
           // sleep(3000);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            searPage.takeScreenhot("clicking_Weiter_");
            throw new Exception(e.getMessage());
        }
    }

    @Then("I click zurück {int}")
    public void i_click_zurück(int clicks) throws Exception {
        try {
            searPage.clickZurueck(clicks);
            Assert.assertTrue(searPage.i_am_on_results_page());
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            searPage.takeScreenhot("clicking_Zurueck_");
            throw new Exception(e.getMessage());
        }
    }

    @Then("I click a {string} article on search results page")
    public void i_click_a_article_on_search_results_page(String position) throws Throwable{
        try {
            if (position.equals("random"))
                searPage.clickRandomArticle();
            //Assert.assertTrue(searPage.i_am_on_results_page());
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
            searPage.takeScreenhot("clicking_"+position+"_article");
            throw new Exception(e.getMessage());
        }
    }

    @Then("I filter results by {string}")
    public void i_filter_results_by(String text) {
        searPage.selectFilterResultsBy(text);
        Assert.assertTrue(searPage.i_am_on_results_page());
    }
}
