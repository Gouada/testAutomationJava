package core;

import helpers.MyLogger;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Level;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

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
        catch (Exception e)
        {
            MyLogger.logger.error("Element: "+ myLocator +" was not found" + e.getMessage());
        }
        finally {
            return element;
        }
    }

    //as xpath is the most used identification type it make sense to create this methode
    public WebElement getElementByXpath(String myLocator)
    {
        WebElement element=null;
        try {
            element = driver.findElement(By.xpath(myLocator));
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

    //get element list
    public List<WebElement> getElements(String myLocator, String myLocatorType)
    {
        List<WebElement> elements = null;
        try {
            By by = getByType(myLocatorType, myLocator);
            elements = driver.findElements(by);
        }
        catch(NoSuchElementException e)
        {
            MyLogger.logger.error("Element: "+ myLocator +" was not found" + e.getMessage());
            //throw new NoSuchElementException("Element was not found" + myLocator);
        }
        finally {
            return elements;
        }
    }

    //as xpath is the most used identification type it make sense to create this methode
    public List<WebElement> getElementsByXpath(String myLocator)
    {
        List<WebElement> elements = null;
        try {
            elements = driver.findElements(By.xpath(myLocator));
        }
        catch(NoSuchElementException e)
        {
            MyLogger.logger.error("Element: "+ myLocator +" was not found" + e.getMessage());
            //throw new NoSuchElementException("Element was not found" + myLocator);
        }
        finally {
            return elements;
        }
    }

    public void clickElement(String myLocator, String myLocatorType)
    {
        try {
            WebElement element = getElement(myLocator, myLocatorType);
            waitForElementToBeClickable(element,10); // we wait max 10 seconds to check element is clickable
            element.click();
            implicitlyWait(3);
        }
        catch (ElementClickInterceptedException e)
        {
            MyLogger.logger.error("Element Click Intercepted Exception: " + myLocatorType + e.getMessage());
            takeScreenhot("click_");
        }
        catch (ElementNotVisibleException e)
        {
            MyLogger.logger.error("Element Not Visible Exception: " + myLocatorType + e.getMessage());
            takeScreenhot("click_");
        }
    }

    public void clickElement( WebElement element)
    {
        try {
            waitForElementToBeClickable(element,10);
            element.click();
            implicitlyWait(3);
        }
        catch (ElementClickInterceptedException e)
        {
            MyLogger.logger.error("Element Click Intercepted Exception: "  + e.getMessage());
            takeScreenhot("click_");
        }
        catch (ElementNotVisibleException e)
        {
            MyLogger.logger.error("Element Not Visible Exception: " + e.getMessage());
            takeScreenhot("click_");
        }
        catch(ElementNotInteractableException e)
        {
            MyLogger.logger.error("Element not interactable exception: " + e.getMessage());
            takeScreenhot("click_");
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

    public void clearField(WebElement element)
    {
        try {
            element.clear();
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

    public String getElementText(WebElement element)
    {
        String text ="";
        try {

            text = element.getText();
        }
        catch (ElementClickInterceptedException e)
        {
            MyLogger.logger.error("Element Click Intercepted Exception: " + e.getMessage());
        }
        catch (ElementNotVisibleException e)
        {
            MyLogger.logger.error("Element Not Visible Exception: " + e.getMessage());
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

    public boolean isElementEnabled(WebElement element)
    {
        boolean isEnabled = false;
        try
        {
            isEnabled = element.isEnabled();
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
        finally {
            return isEnabled;
        }
    }

    public boolean isElementDisplayed(String myLocator, String myLocatorType)
    {
        boolean isDisplayed = false;
        try
        {
            isDisplayed = getElement(myLocator, myLocatorType).isDisplayed();
        }
        catch (Exception e)
        {
            MyLogger.logger.error(myLocator + e.getMessage());
        }
        finally {
            return isDisplayed;
        }
    }

    public boolean isElementDisplayed(WebElement element)
    {
        boolean isDisplayed = false;
        try
        {
              isDisplayed = element.isDisplayed();
        }
        catch (Exception e)
        {
            MyLogger.logger.error( e.getMessage());
            //takeScreenhot("not_displayed_");
        }
        finally {
            return isDisplayed;
        }
    }

    public boolean isElementSelected(WebElement element) {
        boolean isSelected = false;
        try {
                isSelected = element.isSelected();
        } catch (Exception e) {
            MyLogger.logger.error(e.getMessage());
        } finally {
            return isSelected;
        }
    }
    public String isElementChecked(WebElement element)
        {
            String isChecked = "";
            try
            {
                isChecked = element.getAttribute("checked");
            }
            catch (Exception e)
            {
                MyLogger.logger.error(e.getMessage());
            }
            finally {
                return isChecked;
            }
    }

    public String isElementFocused(WebElement element)
    {
        String isFocused = "";
        try
        {
            isFocused = element.getAttribute("focused");
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
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

    public String getClassname(WebElement element)
    {
        String className = "";
        try {
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

    public String getTagName(WebElement element)
    {
        String tagName = "";
        try {
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

    public Point getLocation(WebElement element)
    {
        Point location = null;
        try {
            location = element.getLocation();
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
                By by = getByType(locatorType, myLocator);
                element = driver.findElements(by).get(elementPosition);
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
        finally {
        return element;
        }
    }

    public void clickListElement(String myLocator, String locatorType, int elementPosition)
    {
        WebElement element = null;
        try {
                element = getListElement(myLocator,locatorType, elementPosition);
                element.click();
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
    }

    public void waitForElementToBeClickable(String myLocator, String locatorType, long timeout)
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

    public void waitForElementToBeClickable(WebElement element, long timeout)
    {
        WebDriverWait wt = new WebDriverWait(this.driver, timeout);
        try {
            wt.until(ExpectedConditions.elementToBeClickable(element));
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

    public void waitForElementToBeVisible(WebElement element, long timeout)
    {
        WebDriverWait wt = new WebDriverWait(this.driver, timeout);

        try {
            wt.until(ExpectedConditions.visibilityOf(element));
        }
        catch(Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
    }

    public void implicitlyWait(long timeout)
    {
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
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

    public void scrollPageUpDown(String direction)
    {
        try {
            if (direction.toUpperCase().equals("UP"))
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, -window.innerHeight);");
            else if (direction.toUpperCase().equals("DOWN"))
                ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, window.innerHeight);");
        }
        catch (Exception e)
        {
            MyLogger.logger.error(e.getMessage());
        }
    }

    public void scrollBy(int x, int y)
    {
        try {
                ((JavascriptExecutor) driver).executeScript("window.scrollBy("+x+", "+y+");");
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
            System.out.println("..taking screenshot..");
            File screenShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            System.out.println(".. screenshot taken..");

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
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.history.back();");
            sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
            MyLogger.logger.error(e.getMessage());
        }
    }

    public void goForward() {
        Object last_height;
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.history.forward();");
            sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
            takeScreenhot("goForward()");
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

    public void moveMouseOnElement(WebElement element)
    {
        Actions actions = new Actions(driver);
        try
        {
            waitForElementToBeVisible(element,3);
            actions.moveToElement(element).perform();
            //implicitlyWait(3);
        } catch (IllegalArgumentException a)
        {
            MyLogger.logger.error(a.getMessage());
        }
        catch (Exception e) {
        MyLogger.logger.error(e.getMessage());
        }
    }

    public void pageUp(int count)
    {
        Actions actions = new Actions(driver);
        int i = 0;
        while (i<count) {
            actions.sendKeys(Keys.PAGE_UP).perform();
            implicitlyWait(1);
            i++;
        }
    }

    public void pageDown(int count)
    {
        Actions actions = new Actions(driver);
        int i = 0;
        while (i<count) {
        actions.sendKeys(Keys.PAGE_DOWN).perform();
            implicitlyWait(1);
            i++;
        }
    }

    public void arrowDown( int count)
    {
        Actions actions = new Actions(driver);
        int i = 0;
        while (i<count)
        {
            actions.sendKeys(Keys.ARROW_DOWN).perform();
            implicitlyWait(1);
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
            implicitlyWait(1);
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
            implicitlyWait(1);
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
            implicitlyWait(1);
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

    public void openTab()
    {
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.LEFT_CONTROL).sendKeys("t").build().perform();
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
    }

    public void openElementInNewTab(WebElement element) {
        Actions actions = new Actions(driver);
        try {
            actions.moveToElement(element).keyDown(Keys.LEFT_CONTROL).click(element).build().perform();
            ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(tabs.size()-1));
            sleep(3000);
        }
        catch(InterruptedException e)
        {
            MyLogger.logger.error(e.getMessage());
        }
    }

    public void close_tab()
    {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        if (tabs.size() > 1)
            driver.close();
        else MyLogger.logger.warn("Only one tab was active. I did not close it");
        driver.switchTo().window(tabs.get(0));
    }

    public void switchToTab(int i)
    {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        if(i< tabs.size())
            driver.switchTo().window(tabs.get(i));
        else MyLogger.logger.warn("WARNING: Tab"+i+"does not exists");
    }

    public int getTabCount()
    {
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        return tabs.size();
    }
}
