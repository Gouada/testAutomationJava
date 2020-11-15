package pages;

import helpers.MyLogger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class BestSellerBasePage extends BasePage{

    private static final String menus = "(//div[@data-component='SwiperBar'])[1]//ul//li";
    private static final String sub_menus = "(//div[@data-component='SwiperBar'])[2]//ul//li";
    private static final String element_lits = "//div[@data-component='BestsellerAccordionSection']";
    //private static final String add_close_btn = "//button[@id='btnClose']";

    //private static final String bei_thaila_bestellen_button =
    //private static final String bei_amazon_bestellen_button =

    public BestSellerBasePage(WebDriver driver) {
        super(driver);
    }

    private String getBestsellerMenuElementXpath(String menuElement)
    {
        return menus+"//a[contains(@title,'"+menuElement+"')]";
    }

    private String getBestsellerSubMenuElementXpath(String subMenuElement)
    {
        return sub_menus+"//a[contains(@title,'"+subMenuElement+"')]";
    }

    private String getElementKaufenButtonXpath(int elementNr)
    {
        return "(//div[@data-component='BestsellerAccordionSection'])["+elementNr+"]//button//span[@class='relative bottom-px']";
    }

    private String getElementExpandButtonXpath(int elementNr)
    {
        return "(//div[@data-component='BestsellerAccordionSection'])["+elementNr+"]//button[@data-accordion-el='expandIcon']";
    }

    private String getBeiAmazonBestellenXpath(int elementNr)
    {
        return "(//div[@class='Tooltip-content invisible absolute bg-white shadow p-8 border border-shade-lighter rounded z-10'])["+elementNr+"]//a[@title='Bei Amazon bestellen']";
    }

    private String getBeiThailaXpath(int elementNr)
    {
        return "(//div[@class='Tooltip-content invisible absolute bg-white shadow p-8 border border-shade-lighter rounded z-10'])["+elementNr+"]//a[@title='Bei Thalia bestellen']";
    }

    //get page title
    public String getPageVisibleTitle()
    {
        return getElementText(getElementByXpath("(//main[@id='Inhalt']//h2//span)[1]"));
    }

    public void clickBestSellerMenuElement(String menuElement)
    {
        WebElement element = getElementByXpath(getBestsellerMenuElementXpath(menuElement));
        closeAdversting();
        clickElement(element);
    }

    public void clickBestSellerSubMenuElement(String subMenuElement) throws NoSuchElementException {
        MyLogger.logger.warn(getBestsellerSubMenuElementXpath(subMenuElement));
        System.out.println(getBestsellerSubMenuElementXpath(subMenuElement));
        WebElement element = getElementByXpath(getBestsellerSubMenuElementXpath(subMenuElement));
        closeAdversting();
        if (isElementDisplayed(element))
            clickElement(element);
        else throw new NoSuchElementException("Element was not found on page ");
    }

    public void clickElementElementKaufenButton(int elementNr)
    {
        WebElement element = getElementByXpath(getElementKaufenButtonXpath(elementNr));
        moveMouseOnElement(element);
        clickElement(element);
    }

    public void clickElementElementExpandButton(int elementNr)
    {
        WebElement element = getElementByXpath(getElementExpandButtonXpath(elementNr));
        //moveMouseOnElement(element);
        closeAdversting();
        if(!isElementDisplayed(element))
            scrollIntoView(element);
        clickElement(element);
    }

    public void clickBeiAmazonBestellenButton(int elementNr)
    {
        WebElement element = getElementByXpath(getBeiAmazonBestellenXpath(elementNr));
        if(!isElementDisplayed(element))
            scrollIntoView(element);
        //openElementInNewTab(element);
        clickElement(element);
        switchToTab(1);
    }

    public void clickBeiThailaBestellenButton(int elementNr)
    {
        WebElement element = getElementByXpath(getBeiThailaXpath(elementNr));
        moveMouseOnElement(element);
        if(!isElementDisplayed(element))
            scrollIntoView(element);
        //openElementInNewTab(element);
        clickElement(element);
        switchToTab(1);
    }

    public void moveMouseOnKaufenButton(int elementNr)
    {
        WebElement element = getElementByXpath(getElementKaufenButtonXpath(elementNr));
        closeAdversting();
        if(!isElementDisplayed(element))
            scrollIntoView(element);
        moveMouseOnElement(element);
    }

    public void scrollToRandomBestSellerElement()
    {
        Random rnd = new Random();
        int i = rnd.nextInt(20);
        if (i ==0)
            i=i+1;
        scrollToBestSellerElement(i);
    }

    public void scrollToBestSellerElement(int i)
    {
        String xpath = "("+element_lits+")["+i+"]";
        WebElement element = getElementByXpath(xpath);
        closeAdversting();
        moveMouseOnElement(element);
        if(isElementDisplayed(getElementByXpath(adversting_close_btn)))
            clickElement(getElementByXpath(adversting_close_btn));

    }
}
