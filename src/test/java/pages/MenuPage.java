package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class MenuPage extends BasePage{

    private static String navigation_xpath = "//nav[@role='navigation']//parent::div[@class='OffsetContainer bg-white']";
    private static String menu_list_xpath ="//div[@class='OffsetContainer bg-white']//child::nav[@role='navigation']";
    private static String pfeil_nach_recht_xpath = "((//div[@class='OffsetContainer bg-white']//child::nav[@role='navigation']//following-sibling::div)[1]//child::span)[2]";
    private static String pfeil_nach_links_xpath = "((//div[@class='OffsetContainer bg-white']//child::nav[@role='navigation']//preceding-sibling::div)[3]//child::span)[1]";
    private static String meunu_button_xpath = "//button[@data-navbar-el='menuActivator']";
    private static String icon_xpath = "//span[contains(text(), 'Anmelden') and @class='relative bottom-px']";
    private static String search_button_startpage = "//button[@data-search-el='toggle']";
    private static String search_input_field = "search-input-field";
    private static String search_menu_field = "search-menu-field";
    private static String search_main_field = "search-main-field";
    private static String search__button_leftMenu = "//form[@action='https://www.spiegel.de/suche/']//button";

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    private String getTopMenuXpathString(String menuElement)
    {
        return "//div[@class='OffsetContainer bg-white']//child::nav[@role='navigation']//child::a[@title='"+menuElement +"']";
    }

    private String getLeftMenuXpath(String menuElement)
    {
        String str = "//nav[@role='navigation' and @data-menu-el='menuDrawer']/child::ul/li/child::a[@title='"+menuElement+"']";
        System.out.println(str);
        return str;
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

    public void expandLeftMenuElement(String menuElement)
    {
        String myLocator = getLeftMenuexpandingButtonxpath(menuElement);
        WebElement expander = getElementByXpath(myLocator);
        WebElement element = getElementByXpath(getLeftMenuXpath(menuElement));
        if(!isElementDisplayed(element))
            moveMouseOnElement(element);
        if(!isLeftMenuElementExpanded(menuElement)) {
            clickElement(expander);
        }
    }

    public void closeExpandedLeftMenuElement(String menuElement)
    {
        String myLocator = getLeftMenuexpandingButtonxpath(menuElement);
        if(isLeftMenuElementExpanded(menuElement))
            clickElement(myLocator,"xpath");
    }

    public void click_menu_button()
    {
        waitForElementToBeClickable(meunu_button_xpath, "xpath",10);
        clickElement(getElementByXpath(meunu_button_xpath));
    }
    public void clickLeftMenuElement(String menuElement)
    {
        String myLocator = getLeftMenuXpath(menuElement);
        WebElement element = getElementByXpath(myLocator);
        if(!isElementDisplayed(element))
            moveMouseOnElement(element);
        clickElement(element);
    }

    public void clickLeftSubMenuElement(String menuElement, String subMenuElement)
    {
        String myLocator = getLeftMenuSubMenuElement(subMenuElement);
        expandLeftMenuElement(menuElement);
        clickElement(myLocator,"xpath");
    }

    public void clickATopMenu(String menuName)
    {
        String myLocator = getTopMenuXpathString(menuName);
        waitForElementToBeClickable(myLocator,"xpath", 15);
        moveMouseOnElement(getElement(myLocator,"xpath"));
        clickElement(getElement(myLocator, "xpath"));
    }

    public void click_right_arrow()
    {
        for(int i=0; i<3; i++)
            clickElement(getElementByXpath(pfeil_nach_recht_xpath));
    }

    public void click_left_arrow()
    {
        clickElement(getElementByXpath(pfeil_nach_links_xpath));
    }

    public void click_right_arrow_until_is_visible(String menu) {
        WebElement element = getElementByXpath(getTopMenuXpathString(menu));
        WebElement arrow = getElementByXpath(pfeil_nach_recht_xpath);
        waitForElementToBeClickable(arrow,10);
        do {
            clickElement(arrow);
            implicitlyWait(1);
            //waitForElementToBeClickable(element, 1);
        }
        while (!isElementDisplayed(element));
        clickElement(arrow);
    }
    public void click_left_arrow_until_is_visible(String menu)
    {
        WebElement element = getElementByXpath(getTopMenuXpathString(menu));
        WebElement arrow;
        do {
            arrow = getElementByXpath(pfeil_nach_links_xpath);
            clickElement(arrow);
            implicitlyWait(1);
            //waitForElementToBeClickable(element, 1);
        }
        while (!isElementDisplayed(element));
    }

    public void search(String text) throws InterruptedException {
        //sleep(3000);
        WebElement search_button = getElementByXpath(search__button_leftMenu);
        waitForElementToBeClickable(search_button,10);
        if(isElementDisplayed(search_menu_field, "id")) {
            typeTextInField(search_menu_field, "id", text);
            //sleep(5000);
            clickElement(search_button);
        }
        else
        {
            if(isElementDisplayed(search_main_field, "id"))
                typeTextInField(search_main_field, "id", text);
            else {
                if (!isElementDisplayed(search_input_field, "id"))
                    clickElement(search_button_startpage, "xpath");
                typeTextInField(search_input_field, "id", text);
                }
            pressEnter();
        }

    }
}
