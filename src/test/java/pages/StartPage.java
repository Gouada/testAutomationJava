package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Random;

public class StartPage extends BasePage {

    private WebElement element = null;
    private Random rnd = new Random();
    private static int rndNr = 1;

    private static final String akzeptieren_btn = "//button[contains(@title, 'Akzeptieren und weiter')]";
    private static final String iframe = "//iframe[contains(@id, 'sp_message_iframe')]";

    private static final String latest_news_lists = "//section[@data-area='latest-news']//div[@data-area='article_teaser' and starts-with(@class,'swiper-slide')]";
    private static final String sport_daten_section = "//section[@data-area='block>sportdaten']";

    private static final String main_section = "//section[@data-area='block>topic']";
    private static final String main_article = "//section[contains(@data-area,'block>topic')]//div[contains(@data-area,'article_teaser>news-x') and @data-block-el='articleTeaser']";
    private static final String main_section_secondary_article = "//section[@data-area='block>topic']//div[@data-area='article_teaser>news-s-wide' and @data-block-el='articleTeaser']";

    private static final String news_section = "//div[@data-area='news-section']";
    private static final String news_section_article_list = "//div[@data-area='news-section']//div[@data-block-el='articleTeaser']//article//h2";

    private static final String alle_Rubriken_section = "//section[@data-area='block>channel:alle_rubriken']";

    private static final String stock_section = "//section[@data-area='block>stocks']";
    private static final String stock_section_arrow_right = "(//section[@data-area='block>stocks']//span[contains(@class, 'cursor-pointer')])[2]";
    private static final String stock_section_arrow_left = "(//section[@data-area='block>stocks']//span[contains(@class, 'cursor-pointer')])[1]";
    private static final String stock_section_element_list = "//section[@data-area='block>stocks']//a[@class='hover:border-shade-light border-transparent inline-flex items-center text-black text-s']";

    private static final String block_channel_section = "//section[@data-area='block>channel']";

    private static final String spiegel_bestseller_section = "//section[@data-area='block>bestsellerslider:spiegel-bestseller:_sachbuch_hardcover']";
    private static final String bestseller_section_arrow_right = "(//section[@data-area='block>bestsellerslider:spiegel-bestseller:_sachbuch_hardcover']//span[contains(@class, 'cursor-pointer')])[2]";
    private static final String bestseller_section_arrow_left = "(//section[@data-area='block>bestsellerslider:spiegel-bestseller:_sachbuch_hardcover']//span[contains(@class, 'cursor-pointer')])[1]";

    private static final String leben_section = "//section[@data-area='block>highlight:leben']";
    private static final String leben_section_article_list = "//section[@data-area='block>highlight:leben']//div[@data-block-el='articleTeaser']//a[@class='text-black block']";
    private static final String leben_section_title_link_list = "//section[@data-area='block>highlight:leben']//div[@data-block-el='title']//li//a";

    private static final String product_test_section = "//section[@data-area='block>topic:produkte_im_test']";
    private static final String product_test_section_article_list = "//section[@data-area='block>topic:produkte_im_test']//div[@data-block-el='articleTeaser']";

    private static final String dein_spiegel_section = "//section[@data-area='block>DeinSPIEGEL']";
    private static final String dein_spiegel_section_article_list = "//section[@data-area='block>DeinSPIEGEL']//article";

    private static final String add_block_section = "//section[@data-area='block>adblock']";
    private static final String add_block_section_article_list = "//section[@data-area='block>adblock']//div[@data-block-el='articleTeaser']";

    private static final String highlight_section_list = "//section[@data-area='block>highlight']";

    public StartPage(WebDriver driver) {
        super(driver);
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
        if (isElementDisplayed(iframe, "xpath")) {
            switch_toFrame(iframe, "xpath");
            waitForElementToBeClickable(akzeptieren_btn, "xpath", 10);
            clickElement(akzeptieren_btn, "xpath");
            switch_back_toDefault();
        }
    }

    public void clickOnStarPage(String name) {
        if (name.equals("main_article"))
            clickElement(getElementByXpath(main_article));
    }

    public void scrollOnStartPageToSection(String section) {
        element = null;
        if (section.equals("news_section"))
            element = getElementByXpath(news_section);
        if (section.equals("alle_rubriken_section"))
            element = getElementByXpath(alle_Rubriken_section);
        if (section.equals("block_channel_section"))
            element = getElementByXpath(block_channel_section);
        if (section.equals("leben_section"))
            element = getElementByXpath(leben_section);


        scrollIntoView(element);
    }

    public void clickSectionArticle(String article, String section) {
        WebElement element = null;
        if (article.equals("first")) {
            if (section.equals("news_section"))
                element = getElementsByXpath(news_section_article_list).get(0);
            if (section.equals("leben_section"))
                element = getElementsByXpath(leben_section_article_list).get(0);
            if (section.equals("highlight_section"))
                element = getElementsByXpath(highlight_section_list).get(0);
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
                element = getElementsByXpath(latest_news_lists).get(rndNr);
            }
                if (section.equals("news_section")) {
                //rndNr = rnd.nextInt(getElementsByXpath(latest_news_lists).size());
                element = getElementsByXpath(news_section_article_list).get(rndNr);
            }
            if (section.equals("leben_section")) {
                element = getElementsByXpath(leben_section_article_list).get(rndNr);
            }
            if (section.equals("highlight_section")) {
                element = getElementsByXpath(highlight_section_list).get(rndNr);
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
        moveMouseOnElement(element);
        clickElement(element);
    }

    public void scrollToSectionArticle(String article, String section) {

        if (article.equals("first")) {
            if (section.equals("news_section"))
                element = getElementsByXpath(news_section_article_list).get(0);
            if(section.equals("leben_section"))
                element = getElementsByXpath(leben_section_article_list).get(0);

        } else if (article.equals("random"))
        {
            if (section.equals("news_section")) {
                rndNr = rnd.nextInt(getElementsByXpath(news_section_article_list).size());
                element = getElementsByXpath(news_section_article_list).get(rndNr);
                System.out.println("news_section_article_list:   " +
                        news_section_article_list + "   rndNr:   "+ rndNr);
            }
            if(section.equals("leben_section"))
            {
                rndNr = rnd.nextInt(getElementsByXpath(leben_section_article_list).size());
                element = getElementsByXpath(leben_section_article_list).get(rndNr);
                System.out.println("leben_section_article_list:   " +
                        leben_section_article_list + "   rndNr:   "+ rndNr);

            }
        }
        moveMouseOnElement(element);
    }

    public void clickSectionRightLeftArrow(String section, String direction, int clicks)
    {
        if(section.equals("stock")) {
            if (direction.equals("right"))
                element = getElementByXpath(stock_section_arrow_right);
            else if (direction.equals("left"))
                element = getElementByXpath(stock_section_arrow_left);
        }
        else if(section.equals("bestseller")) {
            if (direction.equals("right"))
                element = getElementByXpath(bestseller_section_arrow_right);
            else if (direction.equals("left"))
                element = getElementByXpath(bestseller_section_arrow_left);
        }
        for(int i=0; i<clicks;i++ )
            moveMouseOnElement(element);
            clickElement(element);
    }

    public void clickStockSectionElement(int position)
    {
        element = getElementsByXpath(stock_section_element_list).get(position);
        clickElement(element);
    }
}


