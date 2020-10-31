package pages;

import helpers.MyLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SpiegelPlus extends BasePage{
    public SpiegelPlus(WebDriver driver) {
        super(driver);
    }

    private static final String sections_list = "//section[@class='relative flex flex-wrap w-full']";
    private static final String alle_Beitrege_section = "//section[@data-area='article-teaser-list']";
    private static final String alle_beitraege_list = "//section[@data-area='article-teaser-list']//div[@data-block-el='articleTeaser']";
    private static final String nav_right = "//span[@title='Ältere Artikel']";
    private static final String nav_left = "//span[@title='Neuere Artikel']";

    private String getSectionArticleXpath(int sectionNr, int articleNr)
    {
        return "//section[@class='relative flex flex-wrap w-full']["+sectionNr+"]//child::div[@data-block-el='articleTeaser']["+articleNr+"]";
    }

    private String getSectionArticlesXpath(int sectionNr)
    {
        return "//section[@class='relative flex flex-wrap w-full']["+sectionNr+"]//child::div[@data-block-el='articleTeaser']";
    }

    private String getSectionXpath(int sectionNr)
    {
        return sections_list +"["+sectionNr+"]";
    }

    public void clickRandomArticleOfAlleBeitraegeSection()
    {
        int articleCount = getElements(alle_beitraege_list, "xpath").size();
        Random rnd = new Random();
        int rndId = rnd.nextInt(articleCount)+1;
        clickElement(getElements(alle_beitraege_list, "xpath").get(rndId));
    }

    public void clickAlleBeitraegeSectionArticle(int articleNr)
    {
        clickElement(getElements(alle_beitraege_list, "xpath").get(articleNr));
    }

    public void clickAlleBeitraegeSectionLastArticle()
    {
        int articleNr = getElements(alle_beitraege_list, "xpath").size()-1;
        clickElement(getElements(alle_beitraege_list, "xpath").get(articleNr));
    }

    public void scrollToRandomArticleOfAlleBeitraegeSection()
    {
        int articleCount = getElements(alle_beitraege_list, "xpath").size();
        Random rnd = new Random();
        int rndId = rnd.nextInt(articleCount)+1;
        moveToElement(getElements(alle_beitraege_list, "xpath").get(rndId));
    }

    public void scrollToAlleBeitraegeSectionArticle(int articleNr)
    {
        moveToElement(getElements(alle_beitraege_list, "xpath").get(articleNr));
    }

    public void scrollToAlleBeitraegeSectionLastArticle()
    {
        int articleNr = getElements(alle_beitraege_list, "xpath").size() -1;
        moveToElement(getElements(alle_beitraege_list, "xpath").get(articleNr));
    }


    public int getSectionsCount()
    {
        return getElements(sections_list, "xpath").size();
    }

    private int getArticlesCount(int sectionNr)
    {
        int count = getElements(getSectionArticlesXpath(sectionNr), "xpath").size();
        MyLogger.logger.info("count..:"+count);
        return count;
    }
    //check wether there sections on spiegelPlus page
    private boolean isSection()
    {
        return getElements(sections_list,"xpath").size() > 0;
    }

    //check wether there are article within a given section
    private boolean hasArticle(int sectionNr)
    {
        String myLocator = getSectionArticlesXpath(sectionNr);
        List<WebElement> elements = getElements(myLocator, "xpath");
        return elements != null && elements.size() > 0;
    }

    private String getAllebeitraegeElementXpath(int articleNr)
    {
        return "//section[@data-area='article-teaser-list']//div[@data-block-el='articleTeaser']["+articleNr+"]";
    }

    public void clickSectionArticle(int sectionNr, int articleNr)
    {
        String myLocator = "(" + getSectionArticleXpath(sectionNr, articleNr) + "//a)[1]";
        moveToElement(getElement(myLocator, "xpath"));
        clickElement(myLocator, "xpath");

    }

    public void clickAlleBeitraegeElement(int articleNr)
    {
        String myLocator = getAllebeitraegeElementXpath(articleNr);
        scrollIntoView(getElement(myLocator,"xpath"));
        clickElement(myLocator, "xpath");
    }

    public void paginate(String direction)
    {
        WebElement element=null;
        if(direction.equals("right"))
            element = getElement(nav_right, "xpath");
        else if(direction.equals("left"))
            element = getElement(nav_left, "xpath");
        moveToElement(element);
        clickElement(element);
    }

    public boolean isLeftNavigationVisible()
    {
        return isElementDisplayed(nav_left, "xpath", null);
    }

    public void clickSectionLastArticle(int sectionNr)
    {
        int lastArticleNr = getArticlesCount(sectionNr);
        System.out.println("lastArticleNr ...:"+ lastArticleNr + "   "+ "sectionNr....:"+sectionNr);
        MyLogger.logger.info("lastArticleNr ...:"+ lastArticleNr + "   "+ "sectionNr....:"+sectionNr);
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
        do {
            rndSection = rdm.nextInt(getSectionsCount())+1;
        }
        while(!hasArticle(rndSection));
        return rndSection;
    }

    public void scrollToSection(int sectionNr)
    {
        WebElement section = getElement(getSectionXpath(sectionNr), "xpath");
        moveToElement(section);
    }

    public void scrollto(String indentificator)
    {
        WebElement element = null;
        try{
            if(indentificator.equals("alle_Beitraege"))
                element = getElement(alle_Beitrege_section,"xpath");
            moveToElement(element);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
    }
}
