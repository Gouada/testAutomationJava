package pages;
// this class implement SpiegelPlus Page actions
import helpers.MyLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SpiegelPlus extends BasePage{
    public SpiegelPlus(WebDriver driver) {
        super(driver);
    }

    //xpaths
    private static final String sections_list = "//section[@class='relative flex flex-wrap w-full']";
    private static final String alle_Beitrege_section = "//section[@data-area='article-teaser-list']";
    private static final String alle_beitraege_list = "//section[@data-area='article-teaser-list']//div[@data-block-el='articleTeaser']";
    private static final String nav_right = "//span[@title='Ältere Artikel']";
    private static final String nav_left = "//span[@title='Neuere Artikel']";

    // gets the xpath of an article section in the specified section
    private String getSectionArticleXpath(int sectionNr, int articleNr)
    {
        return "//section[@class='relative flex flex-wrap w-full']["+sectionNr+"]//child::div[@data-block-el='articleTeaser']["+articleNr+"]";
    }

    //gets the xpath of articles list of a specific section
    private String getSectionArticlesXpath(int sectionNr)
    {
        return "//section[@class='relative flex flex-wrap w-full']["+sectionNr+"]//child::div[@data-block-el='articleTeaser']";
    }

    //gets the xpath of a specific section
    private String getSectionXpath(int sectionNr)
    {
        return sections_list +"["+sectionNr+"]";
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
        int rndId = rnd.nextInt(articleCount)+1;
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

    public void scrollToRandomArticleOfAlleBeitraegeSection()
    {
        int articleCount = getElementsByXpath(alle_beitraege_list).size()-1;
        Random rnd = new Random();
        int rndId = rnd.nextInt(articleCount)+1;
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

    //gets section count
    public int getSectionsCount()
    {
        return getElementsByXpath(sections_list).size();
    }

    //gets number of articles in specified article
    private int getArticlesCount(int sectionNr)
    {
        int count = getElementsByXpath(getSectionArticlesXpath(sectionNr)).size();
        MyLogger.logger.info("count..:"+count);
        return count;
    }
    //check wether there sections on spiegelPlus page
    private boolean isSection()
    {
        return getElementsByXpath(sections_list).size() > 0;
    }

    //check wether there are articles within a given section
    private boolean hasArticle(int sectionNr)
    {
        String myLocator = getSectionArticlesXpath(sectionNr);
        List<WebElement> elements = getElementsByXpath(myLocator);
        return elements != null && elements.size() > 0;
    }

    //click specified article within specified section
    public void clickSectionArticle(int sectionNr, int articleNr)
    {
        String myLocator = "(" + getSectionArticleXpath(sectionNr, articleNr) + "//a)[1]";
        moveToElement(getElementByXpath(myLocator));
        clickElement(getElementByXpath(myLocator));

    }

    public void clickAlleBeitraegeElement(int articleNr)
    {
        String myLocator = getAllebeitraegeElementXpath(articleNr);
        moveToElement(getElementByXpath(myLocator));
        //scrollIntoView(getElementByXpath(myLocator));
        clickElement(myLocator, "xpath");
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
        clickElement(element);
    }

    // this helps to determine if we are no longer on first page. cuz left nav is not on first page
    public boolean isLeftNavigationVisible()
    {
        return isElementDisplayed(nav_left, "xpath");
    }

    public void clickSectionLastArticle(int sectionNr)
    {
        int lastArticleNr = getArticlesCount(sectionNr);
        clickSectionArticle(sectionNr, lastArticleNr);
    }

    public void clickSectionRandomArticle(int sectionNr)
    {
        int randomArticleNr = getRandomArticleNr(sectionNr);
        clickSectionArticle(sectionNr, randomArticleNr);
    }

    public int getRandomArticleNr(int sectionNr)
    {
        Random rdm = new Random();
        int randNr = rdm.nextInt(getArticlesCount(sectionNr))+1;
        System.out.println("Random section Nr"+ randNr);
        return randNr;
    }

    public int getRandomSectionNr()
    {
        Random rdm = new Random();
        int rndSection=0;
        //we want to select only sections which have articles. some sections does not have articles
        do {
            rndSection = rdm.nextInt(getSectionsCount())+1;
        }
        while(!hasArticle(rndSection));
        return rndSection;
    }

    public void scrollToSection(int sectionNr)
    {
        WebElement section = getElementByXpath(getSectionXpath(sectionNr));
        moveToElement(section);
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
