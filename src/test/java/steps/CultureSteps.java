package steps;

import constants.CulturMenus;
import constants.Menu;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CulturePage;
import pages.MenuPage;

public class CultureSteps {

    MenuPage menuPage = new MenuPage(TestCaseBase.driver);
    CulturePage culturePage = new CulturePage(TestCaseBase.driver);

    @Then("^I click culture (.*)$")
    public void i_click_menu(String menu) {
        culturePage.clickMenuElement(menu);
        culturePage.closeAdversting();
    }

    @Then("^I navigate back to (.*) - Kultur - DER SPIEGEL$")
    public void i_go_back_to_menu_kultur_der_spiegel(String menu) {
        String title;
        if(menu.contains("Kunst") || menu.contains("Streaming"))
            title = menu + " - DER SPIEGEL";
        else title = menu + " - Kultur - DER SPIEGEL";

        culturePage.goBack();
        culturePage.waitForPageToLoad(title);
        //Assert.assertTrue(culturePage.getitle().contains(title));
        Assert.assertTrue(culturePage.getPageVisibleTitle(menu).equals(menu));
        //System.out.println("title:......."+title+"   CulturMenus.KUNST.getTitle() "+CulturMenus.KUNST.getTitle());
        //HelperSteps.i_go_back_to(title);
    }

}
