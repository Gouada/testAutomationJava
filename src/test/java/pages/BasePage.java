package pages;

import core.SeleniumDriverWrapper;
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
        WebDriverWait dw = new WebDriverWait(driver, 15);
        dw.until(ExpectedConditions.titleIs(title));
    }

}
