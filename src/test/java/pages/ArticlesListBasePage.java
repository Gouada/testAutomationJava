package pages;

import helpers.MyLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class ArticlesListBasePage extends BasePage{

    private static final String alle_Beitrege_section = "//section[@data-area='article-teaser-list']";
    private static final String alle_beitraege_list = "//section[@data-area='article-teaser-list']//div[@data-block-el='articleTeaser']//article//h2//a";
    private static final String nav_right = "//span[contains(@title, 'ltere Artikel')]";
    private static final String nav_left = "//span[contains(@title,'Neuere Artikel')]";
    private static final String page_title = "//div[@class='bg-white shadow rounded']//h1[contains(text(),'SPIEGEL-Bestseller')]";


    public ArticlesListBasePage(WebDriver driver) {
        super(driver);
    }

    //gets the xpath of an article within alle Beiträge section
    private String getAllebeitraegeElementXpath(int articleNr)
    {
        return "//section[@data-area='article-teaser-list']//div[@data-block-el='articleTeaser']["+articleNr+"]";
    }

    //get page title
    public String getPageVisibleTitle(String menu)
    {
        if(menu.toUpperCase().contains("KUNST") || menu.toUpperCase().contains("STREAMING"))
            return getElementText(getElementByXpath("//div[@class='bg-white shadow rounded']//h2"));
        else
            return getElementText(getElementByXpath("//div[@class='bg-white shadow rounded']//h1"));
    }

    //click randomly an article within alle Beiträge section
    public void   clickRandomArticleOfAlleBeitraegeSection()
    {
        //article count in alle Beitraege section
        int articleCount = getElementsByXpath(alle_beitraege_list).size();
        Random rnd = new Random();
        int rndId = rnd.nextInt(articleCount );
        if(rndId == 0)
            rndId = 1;

        MyLogger.logger.warn("rndId: "+rndId+"  alle_beitraege_list:    "+alle_beitraege_list);
        System.out.println("rndId: "+rndId+"  alle_beitraege_list:    "+alle_beitraege_list);

        WebElement element = getElementsByXpath(alle_beitraege_list).get(rndId);

        closeAdversting();
        //scrollIntoView(element);
        moveMouseOnElement(element);
        //takeScreenhot("before");
        //arrowDown(2);
        clickElement(element);
        //takeScreenhot("after");
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
        closeAdversting();
        clickElement(getElementsByXpath(alle_beitraege_list).get(articleNr));
    }


    public void clickAlleBeitraegeElement(int articleNr)
    {
        String myLocator = getAllebeitraegeElementXpath(articleNr);
        closeAdversting();
        moveMouseOnElement(getElementByXpath(myLocator));
        //scrollIntoView(getElementByXpath(myLocator));
        clickElement(myLocator, "xpath");
    }


    public void scrollToRandomArticleOfAlleBeitraegeSection()
    {
        int articleCount = getElementsByXpath(alle_beitraege_list).size()-1;
        Random rnd = new Random();
        int rndId = rnd.nextInt(articleCount);
        closeAdversting();
        moveMouseOnElement(getElementsByXpath(alle_beitraege_list).get(rndId));
    }

    public void scrollToAlleBeitraegeSectionArticle(int articleNr)
    {
        moveMouseOnElement(getElementsByXpath(alle_beitraege_list).get(articleNr));
    }

    public void scrollToAlleBeitraegeSectionLastArticle()
    {
        int articleNr = getElementsByXpath(alle_beitraege_list).size() -1;
        closeAdversting();
        moveMouseOnElement(getElementsByXpath(alle_beitraege_list).get(articleNr));
    }

    //paginate to left or right according to specified direction
    public void paginate(String direction)
    {
        WebElement element=null;
        if(direction.equals("right"))
            element = getElementByXpath(nav_right);
        else if(direction.equals("left"))
            element = getElementByXpath(nav_left);
        moveMouseOnElement(element);
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
            moveMouseOnElement(element);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
    }

}
