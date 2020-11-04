package pages;

import helpers.MyLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class ArticlesListBasePage extends BasePage{

    private static final String alle_Beitrege_section = "//section[@data-area='article-teaser-list']";
    private static final String alle_beitraege_list = "//section[@data-area='article-teaser-list']//div[@data-block-el='articleTeaser']";
    private static final String nav_right = "//span[contains(@title, 'ltere Artikel')]";
    private static final String nav_left = "//span[@title='Neuere Artikel']";

    public ArticlesListBasePage(WebDriver driver) {
        super(driver);
    }

    //gets the xpath of an article within alle Beiträge section
    private String getAllebeitraegeElementXpath(int articleNr)
    {
        return "//section[@data-area='article-teaser-list']//div[@data-block-el='articleTeaser']["+articleNr+"]";
    }

    //click randomly an article within alle Beiträge section
    public void clickRandomArticleOfAlleBeitraegeSection()
    {
        //article count in alle Beiträge section
        int articleCount = getElementsByXpath(alle_beitraege_list).size();
        Random rnd = new Random();
        int rndId = rnd.nextInt(articleCount);
        clickElement(getElementsByXpath(alle_beitraege_list).get(rndId));
    }

    //click an specified article within alle Beiträge section
    public void clickAlleBeitraegeSectionArticle(int articleNr)
    {
        clickElement(getElementsByXpath(alle_beitraege_list).get(articleNr));
    }

    //click last article of alle Beiträge section
    public void clickAlleBeitraegeSectionLastArticle()
    {
        int articleNr = getElementsByXpath(alle_beitraege_list).size()-1;
        clickElement(getElementsByXpath(alle_beitraege_list).get(articleNr));
    }


    public void clickAlleBeitraegeElement(int articleNr)
    {
        String myLocator = getAllebeitraegeElementXpath(articleNr);
        moveToElement(getElementByXpath(myLocator));
        //scrollIntoView(getElementByXpath(myLocator));
        clickElement(myLocator, "xpath");
    }


    public void scrollToRandomArticleOfAlleBeitraegeSection()
    {
        int articleCount = getElementsByXpath(alle_beitraege_list).size()-1;
        Random rnd = new Random();
        int rndId = rnd.nextInt(articleCount);
        moveToElement(getElementsByXpath(alle_beitraege_list).get(rndId));
    }

    public void scrollToAlleBeitraegeSectionArticle(int articleNr)
    {
        moveToElement(getElementsByXpath(alle_beitraege_list).get(articleNr));
    }

    public void scrollToAlleBeitraegeSectionLastArticle()
    {
        int articleNr = getElementsByXpath(alle_beitraege_list).size() -1;
        moveToElement(getElementsByXpath(alle_beitraege_list).get(articleNr));
    }

    //paginate to left or right according to specified direction
    public void paginate(String direction)
    {
        WebElement element=null;
        if(direction.equals("right"))
            element = getElementByXpath(nav_right);
        else if(direction.equals("left"))
            element = getElementByXpath(nav_left);
        moveToElement(element);
        implicitlyWait(3);
        clickElement(element);
    }

    // this helps to determine if we are no longer on first page. cuz left nav is not on first page
    public boolean isLeftNavigationVisible()
    {
        return isElementDisplayed(nav_left, "xpath");
    }

    public void scrollto(String indentificator)
    {
        WebElement element = null;
        try{
            if(indentificator.equals("alle_Beitraege"))
                element = getElementByXpath(alle_Beitrege_section);
            moveToElement(element);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
    }

}
