package pages;

import core.SeleniumDriverWrapper;
import helpers.MyLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends SeleniumDriverWrapper {
    WebDriver driver;

    private static final String adversting_close_btn = "//button[@id='btnClose']";
    private static final String adversting_colapse_btn = "//button[@id='btnCollapse']";

    public BasePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }

    public String getitle()
    {
        return getPageTitle();
    }

    public void waitForPageToLoad(String title)
    {
        try {
            WebDriverWait dw = new WebDriverWait(driver, 15);
            dw.until(ExpectedConditions.titleContains(title));
        }
        catch (Exception e)
        {
            MyLogger.logger.error("Page "+ title +" need longer than 15 seconds to load" + e.getStackTrace().toString());
        }
    }

    public void colapseAdversting()
    {
        if (isElementDisplayed(getElementByXpath(adversting_colapse_btn)))
            clickElement(getElementByXpath(adversting_colapse_btn));
    }

    public void closeAdversting()
    {
        if (isElementDisplayed(getElementByXpath(adversting_close_btn)))
            clickElement(getElementByXpath(adversting_close_btn));
    }
}
