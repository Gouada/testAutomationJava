package steps;

import constants.CulturMenus;
import constants.Menu;
import io.cucumber.java.en.Then;
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

    @Then("I go back to (.*) - Kultur - DER SPIEGEL")
    public void i_go_back_to_menu_kultur_der_spiegel(String menu) {
        String title = menu + " - Kultur - DER SPIEGEL";
        if(menu.equals(CulturMenus.KUNST.getTitle()) || menu.equals(CulturMenus.STREAMING.getTitle()))
            title = menu + " - DER SPIEGEL";
        HelperSteps.i_go_back_to(title);
    }

}
