package steps;

import constants.CultureBestsellerMenus;
import constants.Menu;
import helpers.MyLogger;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.BestSellerBasePage;
import pages.MenuPage;

import java.util.Random;

import static java.lang.Thread.sleep;

public class BestsellerSteps {

    private MenuPage menuPage = new MenuPage(TestCaseBase.driver);
    private BestSellerBasePage bestSellerBasePage = new BestSellerBasePage(TestCaseBase.driver);
    private static Random rnd = new Random();
    private  static int rndNr = rnd.nextInt(10);

    /*
    @Then("I bring culture menu into view")
    public void i_bring_culture_menu_into_view() {
        menuPage.click_right_arrow_until_is_visible(Menu.KULTUR);
        //menuPage.click_right_arrow();
    }

    @Then("I click TopMenu culture")
    public void i_click_culture_menu() {
        menuPage.clickATopMenu(Menu.KULTUR);
    }
    @Then("^I click culture (.*)$")
    public void i_click_menu(String menu) {
        culturePage.clickMenuElement(menu);
    }
*/

    @Then("^I click bestseller (.*)$")
    public void i_click_bestseller_menu(String menu) { //throws InterruptedException
        //try {
            bestSellerBasePage.clickBestSellerMenuElement(menu);
            bestSellerBasePage.closeAdversting();
            //sleep(1000);
            Assert.assertTrue(bestSellerBasePage.getPageTitle().contains("Bestseller"));
            System.out.println(menu);
            //System.out.println(menu.split(" ")[1]);
            if (menu.contains("Jugend"))
                Assert.assertTrue(bestSellerBasePage.getPageTitle().contains("Kinderbücher ") || bestSellerBasePage.getPageTitle().contains("Bilderbücher"));
            else if (menu.equals(CultureBestsellerMenus.DVD.getTitle()))
                Assert.assertTrue(bestSellerBasePage.getPageTitle().contains("DVD-Charts - die Top 20 "));
            else if (!menu.contains("Jugend") && !menu.contains("DVD"))
                Assert.assertTrue(bestSellerBasePage.getPageTitle().contains(menu));
       /* }
        catch(Exception e)
        {
            MyLogger.logger.error("Step 'clicking BestSeller Menu': "+e.getMessage());
            bestSellerBasePage.takeScreenhot("i_go_back_to_" + menu);
            e.printStackTrace();
            throw new AssertionError();
        }*/
    }

    @Then("I scroll to a random bestseller")
    public void i_scroll_to_random_bestseller_element() {
        //try {
            bestSellerBasePage.scrollToBestSellerElement(rndNr);
       /* }
        catch (Exception e)
        {
            MyLogger.logger.error("Step 'scrolling to random bestseller element': "+e.getMessage());
            bestSellerBasePage.takeScreenhot("scrolling_to_random_bestseller_element");
            e.printStackTrace();
            throw new AssertionError();
        }
        */
    }

    @Then("I click mehr anzeigen")
    public void i_click_mehr_anzeigen() {
        bestSellerBasePage.clickElementElementExpandButton(rndNr);
    }

    @Then("I move mouse over kaufen")
    public void i_move_mouse_over_kaufen() {
        bestSellerBasePage.moveMouseOnKaufenButton(rndNr);
    }

    @Then("^I click bei (.*) kaufen$")
    public void i_click_bei_vendor_kaufen(String vendor) {
        if(vendor.toUpperCase().equals("AMAZON"))
            bestSellerBasePage.clickBeiAmazonBestellenButton(rndNr);
        else
            bestSellerBasePage.clickBeiThailaBestellenButton(rndNr);
        Assert.assertTrue(bestSellerBasePage.getTabCount() > 1);
    }

    @Then("^I close the (.*) tab$")
    public void i_close_vendor_tab(String vendor) {
        bestSellerBasePage.close_tab();
        Assert.assertTrue(bestSellerBasePage.getPageTitle().contains("Bestseller") && bestSellerBasePage.getPageTitle().contains("DER SPIEGEL"));
    }

    @Then("^I click the bestseller sub_menu (.*)$")
    public void i_click_bestseller_sub_menu(String submenu)  {
        bestSellerBasePage.clickBestSellerSubMenuElement(submenu);
        bestSellerBasePage.waitForPageToLoad("Bestseller");
        bestSellerBasePage.closeAdversting();
        Assert.assertTrue(bestSellerBasePage.getPageTitle().contains("Bestseller"));
    }
}
