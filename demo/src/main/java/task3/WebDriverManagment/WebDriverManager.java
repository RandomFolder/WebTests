package task3.WebDriverManagment;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import task3.Factories.BaseFactory;
import task3.Factories.ChromeFactory;
import task3.Factories.FirefoxFactory;
import task3.Logging.LogManager;
import task3.Models.BrowserParameters;

public class WebDriverManager
{
    private static WebDriver driver = null;
    private static BrowserParameters browserParameters = null;
    private static final Map<String, BaseFactory> FACTORIES = Map.of(
        "chrome", new ChromeFactory(),
        "firefox", new FirefoxFactory()
    );


    private static WebDriver setupDriver()
    {
        try
        {
            return (FACTORIES.containsKey(browserParameters.getBrowserName())) ?
             FACTORIES.get(browserParameters.getBrowserName()).createDriver(browserParameters.getOptions()) :
             new ChromeFactory().createDriver(null);
        }
        catch (NullPointerException e)
        {
            return new ChromeFactory().createDriver(null);
        }
    }


    public static void setBrowserParameters(BrowserParameters parameters)
    {
        browserParameters = parameters;
    }


    public static WebDriver getInstance()
    {
        if (driver == null)
        {
            driver = setupDriver();
        }
        return driver;
    }


    public static void goToDefaultURL()
    {
        getInstance().get(browserParameters.getURL());
    }


    public static int getDefaultWaitTime()
    {
        return browserParameters.getDefaultWaitTime();
    }


    public static WebElement findElement(String xpath)
    {
        return getInstance().findElement(By.xpath(xpath));
    }


    public static List<WebElement> findElements(String xpath)
    {
        return getInstance().findElements(By.xpath(xpath));
    }


    public static WebElement waitForElementPresent(final By by, int timeOutInSeconds) {
		WebElement element; 
		try{
			WebDriverWait wait = new WebDriverWait(getInstance(), Duration.ofSeconds(timeOutInSeconds)); 
			element = wait.until(ExpectedConditions.presenceOfElementLocated(by));
			return element;
		} catch (Exception e) {
            LogManager.severe("Failed to get the element");
			e.printStackTrace();
		} 
		return null; 
	}


    public static void close()
    {
        if (driver != null)
        {
            driver.quit();
            driver = null;
        }
    }
}
