package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class StartPage extends BasePage {

    private WebElement element = null;
    private Random rnd = new Random();
    private static int rndNr = 0;

    private static final String spiegel_logo = "//span[@data-headerbar-el='logo']";

    //PageFactory pf = PageFactory.initElements()
    @FindBy(xpath="//button[contains(@title, 'Akzeptieren und weiter')]")
    private static WebElement akzeptieren_btn; // = "//button[contains(@title, 'Akzeptieren und weiter')]";

    @FindBy(xpath = "//iframe[contains(@id, 'sp_message_iframe')]")
    private static  WebElement iframe; //= "//iframe[contains(@id, 'sp_message_iframe')]";

    @FindBy(xpath = "//div[@class='OffsetContainer']//div[@class='swiper-wrapper flex'][1]")
    private static WebElement latest_news_section;

    @FindBy(xpath = "//section[@data-area='latest-news']//div[@data-area='article_teaser' and starts-with(@class,'swiper-slide')]//a")
    private static List<WebElement> latest_news_lists; //= "//section[@data-area='latest-news']//div[@data-area='article_teaser' and starts-with(@class,'swiper-slide')]";

    @FindBy(xpath = "(//section[contains(@data-area,'block>topic')]//div[contains(@data-area,'article_teaser>news-x') and @data-block-el='articleTeaser'])[1]")
    private static WebElement main_article; //= "(//section[contains(@data-area,'block>topic')]//div[contains(@data-area,'article_teaser>news-x') and @data-block-el='articleTeaser'])[1]";

    @FindBy(xpath = "//div[@data-area='news-section']")
    private static WebElement news_section; //= "//div[@data-area='news-section']";

    @FindBy(xpath = "//div[@data-area='news-section']//div[@data-block-el='articleTeaser']//article//h2")
    private static List<WebElement> news_section_article_list; // = "//div[@data-area='news-section']//div[@data-block-el='articleTeaser']//article//h2";

    @FindBy(xpath = "//section[@data-area='block>channel:alle_rubriken']")
    private static WebElement alle_Rubriken_section;

    @FindBy(xpath ="//section[@data-area='block>stocks']")
    private static WebElement stock_section; // = "//section[@data-area='block>stocks']";

    @FindBy(xpath = "(//section[@data-area='block>stocks']//span[contains(@class, 'cursor-pointer')])[2]")
    private static WebElement stock_section_arrow_right; // = "(//section[@data-area='block>stocks']//span[contains(@class, 'cursor-pointer')])[2]";

    @FindBy(xpath ="(//section[@data-area='block>stocks']//span[contains(@class, 'cursor-pointer')])[1]")
    private static WebElement stock_section_arrow_left;

    @FindBy(xpath = "//section[@data-area='block>stocks']//a[@class='hover:border-shade-light border-transparent inline-flex items-center text-black text-s']")
    private static List<WebElement> stock_section_element_list;

    @FindBy(xpath="//section[@data-area='block>channel']")
    private static WebElement block_channel_section;

    @FindBy(xpath = "//section[@data-area='block>bestsellerslider:spiegel-bestseller:_sachbuch_hardcover']")
    private static WebElement spiegel_bestseller_section;

    @FindBy(xpath= "(//section[@data-area='block>bestsellerslider:spiegel-bestseller:_sachbuch_hardcover']//span[contains(@class, 'cursor-pointer')])[2]")
    private static WebElement bestseller_section_arrow_right;

    @FindBy(xpath = "(//section[@data-area='block>bestsellerslider:spiegel-bestseller:_sachbuch_hardcover']//span[contains(@class, 'cursor-pointer')])[1]")
    private static WebElement bestseller_section_arrow_left;

    @FindBy(xpath= "//section[@data-area='block>highlight:leben']")
    private static WebElement leben_section;

    @FindBy(xpath= "//section[@data-area='block>highlight:leben']//div[@data-block-el='articleTeaser']//a[@class='text-black block']")
    private static List<WebElement> leben_section_article_list;

    @FindBy(xpath = "//section[@data-area='block>highlight:leben']//div[@data-block-el='title']//li//a" )
    private static List<WebElement> leben_section_title_link_list;

    @FindBy(xpath = "//section[@data-area='block>highlight']")
    private static List<WebElement> highlight_section_list;

    //Spiegel Top artikel
    @FindBy(xpath="//div[@data-area='block>margin_column_top']//div[contains(text(), 'Top bei SPIEGEL+')]//ancestor::div[contains(@class,'relative w-full')][1]")
    private static WebElement top_bei_spiegel_area;

    @FindBy(xpath= "//div[@data-area='block>margin_column_top']//div[contains(text(), 'Top bei SPIEGEL+')]/parent::div//following-sibling::ul//li//a")
    private static List<WebElement> top_bei_spiegel_article_list;

    //meist gelesene artikel
    @FindBy(xpath =  "//div[@data-area='block>margin_column_top']//div[contains(text(), 'Meistgelesene Artikel')]//ancestor::div[contains(@class,'relative w-full')][1]")
    private static WebElement meist_gelesene_area;

    @FindBy(xpath = "//div[@data-area='block>margin_column_top']//div[contains(text(), 'Meistgelesene Artikel')]/parent::div//following-sibling::ul//li//a")
    private static List<WebElement> meist_gelesene_article_list;


    private static final String product_test_section = "//section[@data-area='block>topic:produkte_im_test']";
    private static final String product_test_section_article_list = "//section[@data-area='block>topic:produkte_im_test']//div[@data-block-el='articleTeaser']";

    private static final String dein_spiegel_section = "//section[@data-area='block>DeinSPIEGEL']";
    private static final String dein_spiegel_section_article_list = "//section[@data-area='block>DeinSPIEGEL']//article";

    private static final String add_block_section = "//section[@data-area='block>adblock']";
    private static final String add_block_section_article_list = "//section[@data-area='block>adblock']//div[@data-block-el='articleTeaser']";

    private static final String sport_daten_section = "//section[@data-area='block>sportdaten']";
    private static final String main_section = "//section[@data-area='block>topic']";
    private static final String main_section_secondary_article = "//section[@data-area='block>topic']//div[@data-area='article_teaser>news-s-wide' and @data-block-el='articleTeaser']";


    public StartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //return the xpath of a rubrik within "alle Rubriken section"
    //input rubrik-name in small charachter // manager -> manager_magazin
    private String getRubrikXpath(String rubrik) {
        return "//section[@data-area='block>channel:alle_rubriken']//div[@data-area='group:" + rubrik + "']";
    }

    //return the xpath of rubriks list within the alle Rubriken section
    private String getRubrikListXpath() {
        return "//section[@data-area='block>channel:alle_rubriken']//div[contains(@data-area, 'group:')]";
    }

    //return the xpath of an list element within the alle Rubriken section
    //Input position: between 1 and List-size. list element position
    private String getRubrikListElementXpath(int position) {
        return "(//section[@data-area='block>channel:alle_rubriken']//div[contains(@data-area, 'group:')])[" + position + "]";
    }

    //return the xpath of an list element article within the alle Rubriken section
    //Input position: between 1 and List-size. list element position
    private String getRubrikListElementArticlesXpath(int position) {
        return "(//section[@data-area='block>channel:alle_rubriken']//div[contains(@data-area, 'group:')])[" + position + "]//a[@class='text-black block']";
    }

    //return the xpath of an list element title within the alle Rubriken section i.e. link to Sport, or to Wirtschaft
    //Input position: between 1 and List-size. list element position
    private String getRubrikListElementLinkXpath(int position) {
        return "(//section[@data-area='block>channel:alle_rubriken']//div[contains(@data-area, 'group:')])[" + position + "]//a)[1]";
    }

    //return the xpath of an list element article within the alle Rubriken section
    //Input rubrik: Rubrik-name
    private String getRubrikArticlesListsXpath(String rubrik) {
        return "//section[@data-area='block>channel:alle_rubriken']//div[@data-area='group:" + rubrik + "']//a[@class='text-black block']";
    }

    //return the xpath of an list element title within the alle Rubriken section i.e. link to Sport, or to Wirtschaft
    //Input rubrik: rubrik-name
    private String getRubrikLinkXpath(String rubrik) {
        return "(//section[@data-area='block>channel:alle_rubriken']//div[@data-area='group:" + rubrik + "']//a)[1]";
    }

    //return the xpath of a channel within "channel section"
    //input rubrik-name in small charachter // job & karriere -> job_&_karriere
    private String getChannelXpath(String channel) {
        return "//section[@data-area='block>channel']//div[@data-area='group:" + channel + "']";
    }

    //return the xpath of channels list within the channel section
    private String getChannelListXpath() {
        return "//section[@data-area='block>channel']//div[contains(@data-area, 'group:')]";
    }

    //return the xpath of an list element within the channel section
    //Input position: between 1 and List-size. list element position
    private String getChannelListElementXpath(int position) {
        return "(//section[@data-area='block>channel']//div[contains(@data-area, 'group:')])[" + position + "]";
    }

    //return the xpath of an list element articles within channel section
    //Input position: between 1 and List-size. list element position
    private String getChannelListElementArticlesXpath(int position) {
        return "(//section[@data-area='block>channel']//div[contains(@data-area, 'group:')])[" + position + "]//a[@class='text-black block']";
    }

    //return the xpath of an list element title within the channel section i.e. link to Sport, or to Wirtschaft
    //Input position: between 1 and List-size. list element position
    private String getChannelListElementLinkXpath(int position) {
        return "(//section[@data-area='block>channel']//div[contains(@data-area, 'group:')])[" + position + "]//a)[1]";
    }

    //return the xpath of an list element article within the channel section
    //Input channel: channel-name
    private String getChannelArticlesListsXpath(String channel) {
        return "//section[@data-area='block>channel']//div[@data-area='group:" + channel + "']//a[@class='text-black block']";
    }

    //return the xpath of an list element title within the channel section i.e. link to Sport, or to Wirtschaft
    //Input channel: channel-name
    private String getChannelLinkXpath(String channel) {
        return "(//section[@data-area='block>channel']//div[@data-area='group:" + channel + "']//a)[1]";
    }

    public void clickAkzeptieren() {

        //waitForElementToBeClickable(iframe,"xpath",Duration.ofSeconds(3));
        waitForElementToBeClickable(iframe, Duration.ofSeconds(3));

        //WebElement accept_iframe = getElementByXpath(iframe);
        WebElement accept_btn;
        //waitForElementToBeClickable(accept_iframe,3);
        //if (isElementDisplayed(accept_iframe))
            if (isElementDisplayed(iframe)) {
            //accept_btn = getElement(akzeptieren_btn, "xpath");
            switch_toFrame(iframe);
            //waitForElementToBeClickable(akzeptieren_btn, "xpath", Duration.ofSeconds(15));

            waitForElementToBeClickable(akzeptieren_btn, Duration.ofSeconds(15));
            //accept_btn = getElement(akzeptieren_btn, "xpath");
            //waitForElementToBeClickable(accept_btn, Duration.ofSeconds(15));
            clickElement(akzeptieren_btn);
            switch_back_toDefault();
        }
    }

    public void clickOnStarPage(String name) {
        if (name.equals("main_article")) {
            waitForElementToBeClickable(main_article, Duration.ofSeconds(15));
            //WebElement element = getElementByXpath(main_article);
            moveMouseOnElement(main_article);
            clickElement(main_article);
        }
    }

    public void scrollOnStartPageToSection(String section) {
        element = null;
        if (section.equals("news_section"))
            element = news_section; //getElementByXpath(news_section);
        if (section.equals("alle_rubriken_section"))
            element = alle_Rubriken_section;
        if (section.equals("block_channel_section"))
            element = block_channel_section;
        if (section.equals("leben_section"))
            element = leben_section;
        if (section.equals("top_bei_spiegel_section"))
            element = top_bei_spiegel_area;
        if (section.equals("meist_gelesene_section"))
            element = meist_gelesene_area;

        scrollIntoView(element);
    }

    public void clickSectionArticle(String article, String section) {
        WebElement element = null;
        if (article.equals("first")) {
            if (section.equals("news_section"))
                element = news_section_article_list.get(0); //= getElementsByXpath(news_section_article_list).get(0);
            if (section.equals("leben_section"))
                element = leben_section_article_list.get(0);
            if (section.equals("highlight_section"))
                element = highlight_section_list.get(0);
            if (section.equals("top_bei_spiegel_section"))
                element = top_bei_spiegel_article_list.get(0);
            if (section.equals("meist_gelesene_section"))
                element = meist_gelesene_article_list.get(0);
            if (section.contains("rubrik")) {
                String rubrik = section.split("_")[0];
                if(rubrik.equals("manager"))
                    rubrik="manager_magazin";
                element = getElementsByXpath(getRubrikArticlesListsXpath(rubrik)).get(0);
            }
            if (section.contains("channel")) {
                String rubrik = section.split("_")[0];
                element = getElementsByXpath(getChannelArticlesListsXpath(rubrik)).get(0);
            }
        } else if (article.equals("random")) {
            if (section.equals("latests_news_section")) {
                //rndNr = rnd.nextInt(getElementsByXpath(latest_news_lists).size());
                waitForElementToBeClickable(latest_news_section, Duration.ofSeconds(5));
                System.out.println("............+++++++++++++++++++++++....................");
                System.out.println("............"+rndNr+"....................");
                System.out.println(latest_news_lists.size());
                element = latest_news_lists.get(rndNr);// getElementsByXpath(latest_news_lists).get(rndNr);
            }
                if (section.equals("news_section")) {
                //rndNr = rnd.nextInt(getElementsByXpath(latest_news_lists).size());
                element = news_section_article_list.get(rndNr); //= getElementsByXpath(news_section_article_list).get(rndNr);
            }
            if (section.equals("leben_section")) {
                element = leben_section_article_list.get(rndNr);
            }
            if (section.equals("highlight_section")) {
                element = highlight_section_list.get(rndNr);
            }

            if (section.equals("top_bei_spiegel_section")) {
                //System.out.println("rndNr before:       "+rndNr);
                //if(rndNr == 0)
                    rndNr = rnd.nextInt(top_bei_spiegel_article_list.size()-1);
                //System.out.println("rndNr after:       "+rndNr);
                element = top_bei_spiegel_article_list.get(rndNr);
            }
            if (section.equals("meist_gelesene_section")) {
                System.out.println("rndNr before:       "+rndNr);
                //if (rndNr == 0)
                    rndNr = rnd.nextInt(meist_gelesene_article_list.size()-1);
                System.out.println("rndNr after:       "+rndNr);
                element = meist_gelesene_article_list.get(rndNr);
            }

            if (section.contains("rubrik")) {
                String rubrik = section.split("_")[0];
                if(rubrik.equals("manager"))
                    rubrik="manager_magazin";
                rndNr = rnd.nextInt(getElementsByXpath(getRubrikArticlesListsXpath(rubrik)).size());
                element = getElementsByXpath(getRubrikArticlesListsXpath(rubrik)).get(rndNr);
            }
            if (section.contains("channel")) {
                String channel = section.split("_")[0];
                rndNr = rnd.nextInt(getElementsByXpath(getChannelArticlesListsXpath(channel)).size());
                //System.out.println("rndNr .......  "+1+"\n count ... "+ getElementsByXpath(getChannelArticlesListsXpath(channel)).size() + "\n getChannelArticlesListsXpath(channel) .." + getChannelArticlesListsXpath(channel));
                element = getElementsByXpath(getChannelArticlesListsXpath(channel)).get(rndNr);
            }
        }
        //scrollIntoView(element);
        //if (!isElementDisplayed(element))
        //waitForElementToBeClickable(element);
        moveMouseOnElement(element);
        clickElement(element);
    }

    public void scrollToSectionArticle(String article, String section) {

        if (article.equals("first")) {
            if (section.equals("news_section"))
                element = news_section_article_list.get(0);
            if(section.equals("leben_section"))
                element = leben_section_article_list.get(0);

        } else if (article.equals("random"))
        {
            if (section.equals("news_section")) {
                rndNr = rnd.nextInt(news_section_article_list.size());
                element = news_section_article_list.get(rndNr);
                //System.out.println("news_section_article_list:   " +
                   //     news_section_article_list + "   rndNr:   "+ rndNr);
            }
            if(section.equals("leben_section"))
            {
                rndNr = rnd.nextInt(leben_section_article_list.size());
                element = leben_section_article_list.get(rndNr);
                //System.out.println("leben_section_article_list:   " +
                      //  leben_section_article_list + "   rndNr:   "+ rndNr);

            }
        }
        moveMouseOnElement(element);
    }

    public void clickSectionRightLeftArrow(String section, String direction, int clicks)
    {
        if(section.equals("stock")) {
            if (direction.equals("right"))
                element = stock_section_arrow_right;
            else if (direction.equals("left"))
                element = stock_section_arrow_left;
        }
        else if(section.equals("bestseller")) {
            if (direction.equals("right"))
                element = bestseller_section_arrow_right;
            else if (direction.equals("left"))
                element = bestseller_section_arrow_left;
        }
        for(int i=0; i<clicks;i++ )
            moveMouseOnElement(element);
            clickElement(element);
    }

    public void clickStockSectionElement(int position)
    {
        element = stock_section_element_list.get(position);
        clickElement(element);
    }

    /*
    public boolean i_am_on_start_page()
    {
        WebElement element = getElementByXpath(spiegel_logo);
        //return getElementText(element).contains("Ergebnisse für")
        if(getElementText(element).contains("Ergebnisse für"))
            return true;
        else return false;
    }
        */
}
