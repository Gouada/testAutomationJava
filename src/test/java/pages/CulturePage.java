package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class CulturePage extends ArticlesListBasePage{

    private static final String cultur_menu_xpath = "";
    public CulturePage(WebDriver driver) {
        super(driver);
    }

    private String getMenuXpath(String menu)
    {
        return "//section[@aria-label='Kultur']//ul//li//a[@title='"+menu+"']";
    }

    public void clickMenuElement(String menu)
    {
        waitForElementToBeClickable(getMenuXpath(menu), "xpath", Duration.ofSeconds(10));
        WebElement element = getElementByXpath(getMenuXpath(menu));
        closeAdversting();
        //waitForElementToBeClickable(element, Duration.ofSeconds(10));
        //moveMouseOnElement(element);
        clickElement(element);
    }

}
