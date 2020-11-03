package pages;

import core.SeleniumDriverWrapper;
import helpers.MyLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends SeleniumDriverWrapper {
    WebDriver driver;
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
            dw.until(ExpectedConditions.titleIs(title));
        }
        catch (Exception e)
        {
            MyLogger.logger.error("Page "+ title +" need longer than 15 seconds to load" + e.getStackTrace().toString());
        }
    }

}
