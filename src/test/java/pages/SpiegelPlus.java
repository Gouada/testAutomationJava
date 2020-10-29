package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class SpiegelPlus extends BasePage{
    public SpiegelPlus(WebDriver driver) {
        super(driver);
    }

    private static String sections_path = "//section[@class='relative flex flex-wrap w-full']";
    private static String alle_beitraege = "//section[@data-area='article-teaser-list']//div[@data-block-el='articleTeaser']";
    private static String nav_right = "//span[@title='Ältere Artikel']";
    private static String nav_left = "//span[@title='Neuere Artikel']";

    private String getSectionArticleXpath(int sectionNr, int articleNr)
    {
        return "//section[@class='relative flex flex-wrap w-full']["+sectionNr+"]//child::div[@data-block-el='articleTeaser']["+articleNr+"]";
    }

    private String getSectionArticlesXpath(int sectionNr)
    {
        return "//section[@class='relative flex flex-wrap w-full']["+sectionNr+"]//child::div[@data-block-el='articleTeaser']";
    }

    private int getSectionsCount()
    {
        return getElements(sections_path, "xpath").size();
    }

    private int getArticlesCount(int sectionNr)
    {
        return getElements(getSectionArticlesXpath(sectionNr), "xpath").size();
    }
    //check wether there sections on spiegelPlus page
    private boolean isSection()
    {
        return getElements(sections_path,"xpath").size() > 0;
    }

    //check wether there are article within a given section
    private boolean isArticle(int sectionNr)
    {
        String myLocator = getSectionArticlesXpath(sectionNr);
        return getElements(myLocator, "xpath").size() >0;
    }

    private String getAllebeitraegeElementXpath(int articleNr)
    {
        return "//section[@data-area='article-teaser-list']//div[@data-block-el='articleTeaser']["+articleNr+"]";
    }

    public void clickSectionArticle(int sectionNr, int articleNr)
    {
        String myLocator = "(" + getSectionArticleXpath(sectionNr, articleNr) + "//a)[2]";
        scrollIntoView(getElement(myLocator,"xpath"));
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
        clickSectionArticle(sectionNr, lastArticleNr);
    }

    public void clickSectionRandomArticle(int sectionNr)
    {
        Random rdm = new Random();

        int randomArticleNr = rdm.nextInt(getArticlesCount(sectionNr));
        clickSectionArticle(sectionNr, randomArticleNr);
    }
}
