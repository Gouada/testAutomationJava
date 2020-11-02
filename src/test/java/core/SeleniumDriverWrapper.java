package core;

import helpers.MyLogger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Level;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

//the Base page extends this class and so every page-class extends indirectly this class
public class SeleniumDriverWrapper {

    private final WebDriver driver;
    public SeleniumDriverWrapper(WebDriver driver) {
        this.driver =driver;
        MyLogger.logger.isEnabled(Level.DEBUG);

    }

    //gets by Type
    public By getByType(String byType, String locator)
    {
        String byType_upper = byType.toUpperCase();

        if ("ID".equals(byType_upper)) {
            return By.id(locator);
        } else if ("XPATH".equals(byType_upper)) {
            return By.xpath(locator);
        } else if ("NAME".equals(byType_upper)) {
            return By.name(locator);
        } else if ("CLASS_NAME".equals(byType_upper)) {
            return By.className(locator);
        } else if ("TAG_NAME".equals(byType_upper)) {
            return By.tagName(locator);
        } else if ("LINK_TEXT".equals(byType_upper)) {
            return By.linkText(locator);
        } else if ("PARTIAL_LINK_TEXT".equals(byType_upper)) {
            return By.partialLinkText(locator);
        //} else if ("LINK_TEXT".equals(byType_upper)) {
          //  return By.name(locator);
        } else {
            MyLogger.logger.error("Unexpected value: " + byType_upper);
            return null;
            //throw new IllegalStateException("Unexpected value: " + byType_upper);
        }
    }

    public WebElement getElement(String myLocator, String myLocatorType)
    {
        WebElement element = null;
        try {
            By by = getByType(myLocatorType, myLocator);
            element = this.driver.findElement(by);
        }
        catch(NoSuchElementException e)
        {
            MyLogger.logger.error("Element: "+ myLocator +" was not found" + e.getMessage());
            //throw new NoSuchElementException("Element was not found" + myLocator);
        }
        finally {
            return element;
        }
    }

    //as xpath is the most used identification type it make sense to create this methode
    public WebElement getElementByXpath(String myLocator)
    {
        try {
            return this.driver.findElement(By.xpath(myLocator));
        }
        catch(NoSuchElementException e)
        {
            MyLogger.logger.error("Element: "+ myLocator +" was not found" + e.getMessage());
            //throw new NoSuchElementException("Element was not found" + myLocator);
        }
        return null;
    }

    public List<WebElement> getElements(String myLocator, String myLocatorType)
    {
        try {
            By by = getByType(myLocatorType, myLocator);
            return this.driver.findElements(by);
        }
        catch(NoSuchElementException e)
        {
            MyLogger.logger.error("Element: "+ myLocator +" was not found" + e.getMessage());
            //throw new NoSuchElementException("Element was not found" + myLocator);
        }
        return null;
    }

    //as xpath is the most used identification type it make sense to create this methode
    public List<WebElement> getElementsByXpath(String myLocator)
    {
        try {
            return this.driver.findElements(By.xpath(myLocator));
        }
        catch(NoSuchElementException e)
        {
            MyLogger.logger.error("Element: "+ myLocator +" was not found" + e.getMessage());
            //throw new NoSuchElementException("Element was not found" + myLocator);
        }
        return null;
    }

    public void clickElement(String myLocator, String myLocatorType)
    {
        try {
            WebElement element = getElement(myLocator, myLocatorType);
            element.click();
        }
        catch (ElementClickInterceptedException e)
        {
            MyLogger.logger.error("Element Click Intercepted Exception: " + myLocatorType + e.getMessage());
        }
        catch (ElementNotVisibleException e)
        {
            MyLogger.logger.error("Element Not Visible Exception: " + myLocatorType + e.getMessage());
        }
    }

    public void clickElement( WebElement element)
    {
        try {
            element.click();
        }
        catch (ElementClickInterceptedException e)
        {
            MyLogger.logger.error("Element Click Intercepted Exception: "  + e.getMessage());
        }
        catch (ElementNotVisibleException e)
        {
            MyLogger.logger.error("Element Not Visible Exception: " + e.getMessage());
        }
    }

    public void TypeTextInField(String myLocator, String myLocatorType, String text)
    {
        try {
                getElement(myLocator, myLocatorType).sendKeys(text);
        }
        catch (ElementClickInterceptedException e)
        {
            MyLogger.logger.error("Element Click Intercepted Exception: " + myLocatorType + e.getMessage());
        }
        catch (ElementNotVisibleException e)
        {
            MyLogger.logger.error("Element Not Visible Exception: " + myLocatorType + e.getMessage());
        }
    }

    public void TypeTextInField( WebElement element, String text)
    {
        try {
            element.sendKeys(text);
        }
        catch (ElementClickInterceptedException e)
        {
            MyLogger.logger.error("Element Click Intercepted Exception: "  + e.getMessage());
        }
        catch (ElementNotVisibleException e)
        {
            MyLogger.logger.error("Element Not Visible Exception: "  + e.getMessage());
        }
    }

    public void clearField(String myLocator, String myLocatorType, WebElement element)
    {
        try {
            if (element == null) {
                element = getElement(myLocator, myLocatorType);
            }
            element.clear();
        }
        catch (ElementClickInterceptedException e)
        {
            MyLogger.logger.error("Element Click Intercepted Exception: " + myLocatorType + e.getMessage());
        }
        catch (ElementNotVisibleException e)
        {
            MyLogger.logger.error("Element Not Visible Exception: " + myLocatorType + e.getMessage());
        }
    }

    public String getElementText(String myLocator, String myLocatorType, WebElement element)
    {
        String text ="";
        try {
            if (element == null) {
                element = getElement(myLocator, myLocatorType);
            }
            text = element.getText();
        }
        catch (ElementClickInterceptedException e)
        {
            MyLogger.logger.error("Element Click Intercepted Exception: " + myLocatorType + e.getMessage());
        }
        catch (ElementNotVisibleException e)
        {
            MyLogger.logger.error("Element Not Visible Exception: " + myLocatorType + e.getMessage());
        }
        finally {
            return text;
        }
    }

    public String getPageTitle()
    {
        String title = "";
        try {
            title = driver.getTitle();
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
        finally {
            return title;
        }
    }

    public String getCurrentURL()
    {
        String url = "";
        try {
            url = driver.getCurrentUrl();
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
        finally {
            return url;
        }
    }

    public String getPageSource()
    {
        String page = "";
        try {
            page = driver.getPageSource();
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
        finally {
            return page;
        }
    }

    public boolean isElementEnabled(String myLocator, String myLocatorType, WebElement element)
    {
        boolean isEnabled = false;
        try
        {
            if (element == null)
                element = getElement(myLocator, myLocatorType);
            isEnabled = element.isEnabled();
        }
        catch (Exception e)
        {
            MyLogger.logger.error(myLocator + e.getMessage());
        }
        finally {
            return isEnabled;
        }
    }

    public boolean isElementDisplayed(String myLocator, String myLocatorType, WebElement element)
    {
        boolean isDisplayed = false;
        try
        {
            if (element == null)
                element = getElement(myLocator, myLocatorType);
            isDisplayed = element.isDisplayed();
        }
        catch (Exception e)
        {
            MyLogger.logger.error(myLocator + e.getMessage());
        }
        finally {
            return isDisplayed;
        }
    }

    public boolean isElementSelected(String myLocator, String myLocatorType, WebElement element) {
        boolean isSelected = false;
        try {
            if (element == null)
                element = getElement(myLocator, myLocatorType);
            isSelected = element.isSelected();
        } catch (Exception e) {
            MyLogger.logger.error(myLocator + e.getMessage());
        } finally {
            return isSelected;
        }
    }
    public String isElementChecked(String myLocator, String myLocatorType, WebElement element)
        {
            String isChecked = "";
            try
            {
                if (element == null)
                    element = getElement(myLocator, myLocatorType);
                isChecked = element.getAttribute("checked");
            }
            catch (Exception e)
            {
                MyLogger.logger.error(myLocator + e.getMessage());
            }
            finally {
                return isChecked;
            }
    }

    public String isElementFocused(String myLocator, String myLocatorType, WebElement element)
    {
        String isFocused = "";
        try
        {
            if (element == null)
                element = getElement(myLocator, myLocatorType);
            isFocused = element.getAttribute("focused");
        }
        catch (Exception e)
        {
            MyLogger.logger.error(myLocator + e.getMessage());
        }
        finally {
            return isFocused;
        }
    }

    public boolean isTextPresent(String text)
    {
        boolean isTextPresent=false;
        try
        {
            isTextPresent = driver.getPageSource().contains(text);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(text + e.getMessage());
        }
        finally {
            return isTextPresent;
        }
    }

    public String getClassname(String myLocator, String myLocatorType, WebElement element)
    {
        String className = "";
        try {
            if (element == null)
                element = getElement(myLocator, myLocatorType);
            className = element.getAttribute("className");
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
        finally {
            return className;
        }
    }

    public String getTagName(String myLocator, String myLocatorType, WebElement element)
    {
        String tagName = "";
        try {
            if (element == null)
                element = getElement(myLocator, myLocatorType);
            tagName = element.getTagName();
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
        finally {
            return tagName;
        }
    }

    public String getLocation(String myLocator, String myLocatorType, WebElement element)
    {
        String location = "";
        try {
            if (element == null)
                element = getElement(myLocator, myLocatorType);
            location = element.getText();
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
        finally {
            return location;
        }
    }

    public WebElement getListElement(String myLocator, String locatorType, int elementPosition)
    {
        WebElement element = null;
        try
        {
            if (element == null) //???
            {
                By by = getByType(locatorType, myLocator);
                element = driver.findElements(by).get(elementPosition);
            }
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
        finally {
        return element;
        }
    }

    public void clickListElement(String myLocator, String locatorType, int elementPosition, List<WebElement> webElements)
    {
        WebElement element = null;
        try {
                if (webElements == null)
                    element = getListElement(myLocator,locatorType, elementPosition);
                else element =webElements.get(elementPosition);
                element.click();
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
    }

    public void waitForElementToBeClickable(String myLocator, String locatorType, long timeout, WebElement element)
    {
        WebDriverWait wt = new WebDriverWait(this.driver, timeout);
        By by = getByType(locatorType,myLocator);
        try {
            wt.until(ExpectedConditions.elementToBeClickable(by));
        }
        catch(Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
    }

    public void waitForElementToBeVisible(String myLocator, String locatorType, long timeout, WebElement element, String event)
    {
        WebDriverWait wt = new WebDriverWait(this.driver, timeout);
        By by = getByType(locatorType,myLocator);
        try {
            if (element == null)
                element = getElement(myLocator,locatorType);
            wt.until(ExpectedConditions.visibilityOf(element));
        }
        catch(Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
    }

    public void scrollDownToBottom()
    {
        Object windowHeight, newWidowHeight;
            try {
                windowHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight;");
                while (true) {
                    ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

                    newWidowHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight;");
                    if (windowHeight == newWidowHeight)
                        break;
                    windowHeight = newWidowHeight;
            }
            }
        catch(Exception e)
                {
                    MyLogger.logger.error(e.getMessage());
                }
    }

    public void scrollUpToTop()
    {
        Object windowHeight, newWidowHeight;
        try {
            windowHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight;");
            while (true) {
                ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight);");

                newWidowHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight;");
                if (windowHeight == newWidowHeight)
                    break;
                windowHeight = newWidowHeight;
            }
        }
        catch(Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
    }

    public void scrollIntoView(WebElement element)
    {
        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
    }

    public void takeScreenhot( String testStep)
    {
        try {
            Calendar calendar = Calendar.getInstance();
            String filename;
            //filename = "ERROR_SCREENSHOT_"+Calendar.DAY_OF_MONTH+"_"+Calendar.MONTH+"-"+Calendar.HOUR+"_"+Calendar.MINUTE+"_"+Calendar.SECOND+ ".jpg";
            filename = " ERROR_SCREENSHOT_" + testStep + "_" + calendar.getTimeInMillis() + ".jpg";
            MyLogger.logger.info("this is the filename " + filename);
            File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            copyFile(screenShot, filename);
            filename = "";
        }
        catch (Exception e)
        {
            System.out.println("error taking screenshot");
            MyLogger.logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void copyFile(File screenShot, String filename)
    {

        String destinationPath = "Screenshots/"+filename;
        File destinationFile = new File (destinationPath);

        try {
            FileUtils.copyFile(screenShot, destinationFile);
        } catch (Exception e) {
            System.out.println("error taking screenshot");
            MyLogger.logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public void goBack() {
        Object last_height;
        try {
            //last_height = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
            //((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
            ((JavascriptExecutor) driver).executeScript("window.history.go(-1)");

            //actions = ActionChains(self.driver)
            //actions.send_keys(Keys.ALT, Keys.LEFT).perform()
            //actions.key_down(Keys.ALT).send_keys(Keys.LEFT).key_up(Keys.ALT).perform()
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenhot("goback");
            MyLogger.logger.error(e.getMessage());
        }
    }

    public void iClickBackButton() {
        Object last_height;
        try {

            Actions actions = new Actions(driver);
            //actions.sendKeys(Keys.ALT, Keys.LEFT).perform();
            actions.keyDown(Keys.ALT).sendKeys(Keys.LEFT).keyUp(Keys.ALT).perform();
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenhot("going back");
            MyLogger.logger.error(e.getMessage());
        }
    }

    public void moveToElement(WebElement element)
    {
        Actions actions = new Actions(driver);
        try
        {
            actions.moveToElement(element);
        }
        catch (Exception e) {
        MyLogger.logger.error(e.getMessage());
        }
    }

    /*
    public void moveMouseOnElement(WebElement element)
    {
        Actions actions = new Actions(driver);
        try
        {
            actions.mo
        }
        catch (Exception e) {
            MyLogger.logger.error(e.getMessage());
        }
    }
    */

    public void pageUp()
    {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_UP).perform();
    }

    public void pageDown()
    {
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
    }

    public void arrowDown( int count)
    {
        Actions actions = new Actions(driver);
        int i = 0;
        while (i<count)
        {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            i++;
        }

    }

    public void arrowUp(int count)
    {
        Actions actions = new Actions(driver);
        int i = 0;
        while (i<count)
        {
            actions.sendKeys(Keys.ARROW_UP).perform();
            i++;
        }
    }

    public void arrowLeft( int count)
    {
        Actions actions = new Actions(driver);
        int i = 0;
        while (i<count)
        {
            actions.sendKeys(Keys.ARROW_LEFT).perform();
            i++;
        }

    }

    public void arrowRight(int count)
    {
        Actions actions = new Actions(driver);
        int i = 0;
        while (i<count)
        {
            actions.sendKeys(Keys.ARROW_RIGHT).perform();
            i++;
        }
    }

    public void switch_toFrame(String myLocator, String locatorType)
    {
        //By by = getByType(locatorType, myLocator);
        WebElement element = getElement(myLocator, locatorType);
        driver.switchTo().frame(element);
    }

    public void switch_back_toDefault()
    {
        driver.switchTo().defaultContent();
    }
}
