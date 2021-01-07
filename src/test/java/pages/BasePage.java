package pages;

import core.SeleniumDriverWrapper;
import helpers.MyLogger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage extends SeleniumDriverWrapper {
    WebDriver driver;

    @FindBy(xpath = "//button[@id='btnClose']")
    protected static WebElement adversting_close_btn;

    @FindBy(xpath  = "//button[@id='btnCollapse']" )
    protected static WebElement adversting_colapse_btn;

    @FindBy(xpath = "//div[starts-with(@class, 'shadow-sm md')]//button[@aria-label='Schließen']")
    protected static WebElement popup_window;

    @FindBy(xpath  = "//button[@aria-label='Schließen']" )
    protected static WebElement closeBtn;

    public BasePage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getitle()
    {
        return getPageTitle();
    }

    public void waitForPageToLoad(String title)
    {
        try {
            WebDriverWait dw = new WebDriverWait(driver, Duration.ofSeconds(30));
            dw.until(ExpectedConditions.titleContains(title));
        }
        catch (Exception e)
        {
            MyLogger.logger.error("Page "+ title +" need longer than 15 seconds to load" + e.getStackTrace().toString());
        }
    }

    public void colapseAdversting()
    {
        if(isElementDisplayed(popup_window))
            clickElement(popup_window);
        if (isElementDisplayed(adversting_colapse_btn))
            clickElement(adversting_colapse_btn);
    }

    public void closeAdversting()
    {
        if(isElementDisplayed(popup_window))
            clickElement(popup_window);
        if (isElementDisplayed(adversting_close_btn))
            clickElement(adversting_close_btn);
        if(isElementDisplayed(closeBtn))
            clickElement(closeBtn);
    }
}
