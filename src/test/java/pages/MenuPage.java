package pages;

import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.WebDriver;

public class MenuPage extends BasePage{

    private static String navigation_xpath = "//nav[@role='navigation']//parent::div[@class='OffsetContainer bg-white']";
    private static String menu_list_xpath ="//div[@class='OffsetContainer bg-white']//child::nav[@role='navigation']";
    private static String pfeil_nach_recht_xpath = "((//div[@class='OffsetContainer bg-white']//child::nav[@role='navigation']//following-sibling::div)[1]//child::span)[2]";
    private static String pfeil_nach_links_xpath = "((//div[@class='OffsetContainer bg-white']//child::nav[@role='navigation']//preceding-sibling::div)[3]//child::span)[1]";
    private static String meunu_button_xpath = "//button[@data-navbar-el='menuActivator']";
    private static String icon_xpath = "//span[contains(text(), 'Anmelden') and @class='relative bottom-px']";

    private static String akzeptieren_btn = "//button[contains(@title, 'Akzeptieren und weiter')]";
    private static String iframe = "//iframe[contains(@id, 'sp_message_iframe')]";
    public MenuPage(WebDriver driver) {
        super(driver);
    }

    private String getTopMenuXpathString(String menuElement)
    {
        return "//div[@class='OffsetContainer bg-white']//child::nav[@role='navigation']//child::li[@title='"+menuElement +"']";
    }

    private String getLeftMenuXpath(String menuElement)
    {
        return "//nav[@role='navigation' and @data-menu-el='menuDrawer']/child::ul/li/child::a[@title='"+menuElement+"']";
    }

    private String getLeftMenuSubMenuElement(String subMenuElement)
    {
        return "//nav[@role='navigation' and @data-menu-el='menuDrawer']/child::ul/li[@data-component='MenuAccordionSection']/ul//a[@title='" + subMenuElement + "']";
    }

    private String getLeftMenuexpandingButtonxpath(String menuElement)
    {
        return "//nav[@role='navigation' and @data-menu-el='menuDrawer']/child::ul/li[@data-component='MenuAccordionSection']//button[contains(@aria-label, 'Menü " + menuElement + " aufklappen')]";
    }

    private boolean isLeftMenuElementExpanded(String menuElement)
    {
        String myLocator = "(//nav[@role='navigation' and @data-menu-el='menuDrawer']/child::ul/li[@data-component='MenuAccordionSection']//button[contains(@aria-label, 'Menü " + menuElement + " aufklappen')])/ancestor::li[@aria-expanded='true']";
        return getElement(myLocator, "xpath") != null;
    }

    private void expandLeftMenuElement(String menuElement)
    {
        String myLocator = getLeftMenuexpandingButtonxpath(menuElement);
        if(!isLeftMenuElementExpanded(menuElement)) {
            clickElement(myLocator,"xpath", null);
        }
    }

    public void closeExpandedLeftMenuElement(String menuElement)
    {
        String myLocator = getLeftMenuexpandingButtonxpath(menuElement);
        if(isLeftMenuElementExpanded(menuElement))
            clickElement(myLocator,"xpath", null);
    }

    public void clickLeftMenuElement(String menuElement)
    {
        String myLocator = getLeftMenuXpath(menuElement);
        clickElement(myLocator,"xpath", null);
    }

    public void clickSubMenuElement(String menuElement, String subMenuElement)
    {
        String myLocator = getLeftMenuSubMenuElement(subMenuElement);
        expandLeftMenuElement(menuElement);
        clickElement(myLocator,"xpath", null);
    }

    public void clickAkzeptieren()
    {
        switch_toFrame(iframe, "xpath");
        waitForElementToBeClickable(akzeptieren_btn, "xpath",10,null);
        clickElement(akzeptieren_btn,"xpath", null);
        switch_back_toDefault();
    }


}