package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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
        WebElement element = getElement(direction, "xpath");
        moveToElement(element);
        clickElement(element);
    }
}
