package pages;
// this class implement SpiegelPlus Page actions
import helpers.MyLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

public class SpiegelPlus extends ArticlesListBasePage{
    public SpiegelPlus(WebDriver driver) {
        super(driver);
    }

    //xpaths
    private static final String sections_list = "//section[@class='relative flex flex-wrap w-full']";
  /*  private static final String alle_Beitrege_section = "//section[@data-area='article-teaser-list']";
    private static final String alle_beitraege_list = "//section[@data-area='article-teaser-list']//div[@data-block-el='articleTeaser']";
    private static final String nav_right = "//span[contains(@title, 'ltere Artikel')]";
    private static final String nav_left = "//span[@title='Neuere Artikel']";
*/
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

    //gets section count
    public int getSectionsCount()
    {
        return getElementsByXpath(sections_list).size();
    }

    //gets number of articles in specified article
    private int getArticlesCount(int sectionNr)
    {
        int count = getElementsByXpath(getSectionArticlesXpath(sectionNr)).size();
        MyLogger.logger.info("count..:"+count + "   Section........." + sectionNr);
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
        moveMouseOnElement(getElementByXpath(myLocator));
        clickElement(getElementByXpath(myLocator));

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
        int randNr = rdm.nextInt(getArticlesCount(sectionNr));
        if(randNr ==0) randNr=1;
        return randNr;
    }

    public int getRandomSectionNr()
    {
        Random rdm = new Random();
        int rndSection=0;
        //we want to select only sections which have articles. some sections does not have articles
        do {
            rndSection = rdm.nextInt(getSectionsCount());
        }
        while(!hasArticle(rndSection));
        System.out.println("rndSection:   "+rndSection);
        return rndSection;
    }

    public void scrollToSection(int sectionNr)
    {
        WebElement section = getElementByXpath(getSectionXpath(sectionNr));
        moveMouseOnElement(section);
    }

}
