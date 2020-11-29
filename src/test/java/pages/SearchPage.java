package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;


public class SearchPage extends BasePage{


    private static final String search_main_field_id = "search-main-field";
    private static final String search_results_text = "//section[@id='suchergebnisse']/div[1]//h2//span//span//span";
    private static final String search_results_section = "//section[@id='suchergebnisse']/section[1]";
    private static final String search_results_title_list = "//section[@id='suchergebnisse']/section[1]//article//header//h2//a";
    private static final String search_results_weiter_button = "//button[@title='Weiter']//span";
    private static final String search_results_zurueck_button = "//button[@title='Zurück']";
    private static final String search_results_filter_id = "timespanSelect";
    private static final String search_results_nav = "//section[@id='suchergebnisse']//following-sibling::nav[@role='navigation']";
    public SearchPage(WebDriver driver) {
        super(driver);
    }

    private int getRandNumber()
    {
        //System.out.println("Test.1..................");
        int article_count = getElementsByXpath(search_results_title_list).size();
        //System.out.println("Test.2.................");

        Random rnd = new Random();
        int rndNbr = rnd.nextInt(article_count);
        if(rndNbr >0)
            rndNbr= rndNbr-1;
        //System.out.println("rndNbr:........"+ rndNbr);
        return rndNbr;
    }

    public void clickRandomArticle()
    {
        waitForPageToLoad("Suche - DER SPIEGEL");
        //moveMouseOnElement(getElementByXpath(search_results_text));
        pageUp(3);
        int i = getRandNumber();
        //System.out.println("i:       "+i);
        //System.out.println("size:  "+ getElementsByXpath(search_results_title_list).size());

        WebElement element = getElementsByXpath(search_results_title_list).get(i);
        moveMouseOnElement(element);
        arrowDown(2);
        clickElement(element);
    }

    public void clickArticle(int i)
    {
        WebElement element = getElementsByXpath(search_results_title_list).get(i);
        moveMouseOnElement(element);
        clickElement(element);
    }

    public void selectFilterResultsBy(String text)
    {
        WebElement selectElement = getElement(search_results_filter_id, "id");
        selectDropDownElementByVisibleText(selectElement, text);
    }

    public void clickWeiter(int clicks) throws InterruptedException {

       int i = 0;
       WebElement navSection = getElementByXpath(search_results_nav);
       WebElement weiter_btn = getElementByXpath(search_results_weiter_button);
       while (i < clicks) {
           //waitForElementToBeClickable(weiter_btn, 3);
           moveMouseOnElement(navSection);
           if (isElementDisplayed(weiter_btn))
           {
               moveMouseOnElement(weiter_btn);
               clickElement(weiter_btn);
        }
            i = i + 1;
        }
    }

    public void clickZurueck(int clicks)
    {
        int i = 0;
        while (i < clicks) {
            moveMouseOnElement(getElement(search_results_nav,"xpath"));
            if (isElementDisplayed(search_results_zurueck_button, "xpath"))
            {
                moveMouseOnElement(getElementByXpath(search_results_zurueck_button));
                clickElement(search_results_zurueck_button, "xpath");
            }
            i = i + 1;
        }
    }

    public void search(String text)
    {
        typeTextInField(search_main_field_id, "id", text);
        pressEnter();
    }

    public boolean i_am_on_results_page()
    {
        WebElement element = getElementByXpath(search_results_text);
        //return getElementText(element).contains("Ergebnisse für")
        if(getElementText(element).contains("Ergebnisse für"))
            return true;
        else return false;
    }
}
