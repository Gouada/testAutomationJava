package core;

public class DriverFactory {

    private  static DriverManager driverManager;
    //private static String browser;

    public DriverFactory(String browser)
    {
        //DriverFactory.browser=browser;
    }

    public static DriverManager getDriverManager(String browser)
    {
        if(browser.toUpperCase().equals("CHROME"))
            driverManager = new ChromeDriverManager();
        if(browser.toUpperCase().equals("FIREFOX"))
            driverManager = new FirefoxDriverManager();
        if(browser.toUpperCase().equals("IE"))
            driverManager = new IEDriverManager();
        return driverManager;
    }
}
