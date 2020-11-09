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

    @Then("^I navigate back to (.*) - Kultur - DER SPIEGEL$")
    public void i_go_back_to_menu_kultur_der_spiegel(String menu) {
        String title;
        if(menu.contains("Kunst") || menu.contains("Streaming"))
            title = menu + " - DER SPIEGEL";
        else title = menu + " - Kultur - DER SPIEGEL";
        System.out.println("title:......."+title+"   CulturMenus.KUNST.getTitle() "+CulturMenus.KUNST.getTitle());
        culturePage.goBack();
        culturePage.waitForPageToLoad(title);
        Assert.assertTrue(culturePage.getitle().contains(title));
        //System.out.println("title:......."+title+"   CulturMenus.KUNST.getTitle() "+CulturMenus.KUNST.getTitle());
        //HelperSteps.i_go_back_to(title);
    }

}
