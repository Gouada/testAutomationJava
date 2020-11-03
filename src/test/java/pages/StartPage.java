package pages;

import org.openqa.selenium.WebDriver;

public class StartPage extends BasePage{


    private static String akzeptieren_btn = "//button[contains(@title, 'Akzeptieren und weiter')]";
    private static String iframe = "//iframe[contains(@id, 'sp_message_iframe')]";

    public StartPage(WebDriver driver)
    {
        super(driver);
    }
    public void clickAkzeptieren()
    {
        if (isElementDisplayed(iframe, "xpath"))
        {
            switch_toFrame(iframe, "xpath");
            waitForElementToBeClickable(akzeptieren_btn, "xpath",10,null);
            clickElement(akzeptieren_btn,"xpath");
            switch_back_toDefault();
        }
    }
}
