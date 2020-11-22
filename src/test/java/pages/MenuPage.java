package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MenuPage extends BasePage{

    private static String navigation_xpath = "//nav[@role='navigation']//parent::div[@class='OffsetContainer bg-white']";
    private static String menu_list_xpath ="//div[@class='OffsetContainer bg-white']//child::nav[@role='navigation']";
    private static String pfeil_nach_recht_xpath = "((//div[@class='OffsetContainer bg-white']//child::nav[@role='navigation']//following-sibling::div)[1]//child::span)[2]";
    private static String pfeil_nach_links_xpath = "((//div[@class='OffsetContainer bg-white']//child::nav[@role='navigation']//preceding-sibling::div)[3]//child::span)[1]";
    private static String meunu_button_xpath = "//button[@data-navbar-el='menuActivator']";
    private static String icon_xpath = "//span[contains(text(), 'Anmelden') and @class='relative bottom-px']";

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
        waitForElementToBeClickable(arrow,3);
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
}
