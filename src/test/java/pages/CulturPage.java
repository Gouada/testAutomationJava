package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CulturPage extends ArticlesListBasePage{

    private static final String cultur_menu_xpath = "";
    public CulturPage(WebDriver driver) {
        super(driver);
    }

    private String getMenuXpath(String menu)
    {
        return "//section[@aria-label='Kultur']//ul//li//a[@title='"+menu+"']";
    }

    public void clickMenuElement(String menu)
    {
        WebElement element = getElementByXpath(getMenuXpath(menu));
        clickElement(element);
    }

}