package pages;

import core.SeleniumDriverWrapper;
import org.openqa.selenium.WebDriver;

public class BasePage extends SeleniumDriverWrapper {

    public BasePage(WebDriver driver)
    {
        super(driver);
    }

}
