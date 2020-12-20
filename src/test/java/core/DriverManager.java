package core;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {

    public static WebDriver driver;

    public abstract WebDriver createDriver() throws ClassNotFoundException;

    public WebDriver getDriver() {
        try {
            if (DriverManager.driver == null)
            {
                DriverManager.driver = createDriver();
            }
            else System.out.println("driver is null DriverManager..................");
          }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return DriverManager.driver;
    }


    public void quitDriver(WebDriver driver)
    {
        try {
            if (driver != null) {
                driver.quit();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void closeDriver(WebDriver driver)
    {
        try {
            if (driver != null) {
                driver.close();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
