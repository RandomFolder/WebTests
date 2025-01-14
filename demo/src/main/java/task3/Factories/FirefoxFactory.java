package task3.Factories;

import java.util.List;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import task3.Logging.LogManager;

public class FirefoxFactory extends BaseFactory
{
    @Override
    public WebDriver createDriver(List<String> opts)
    {
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        
        if (opts != null)
        {
            options.addArguments(opts);
            LogManager.info("Additional browser options were passed");
        }

        FirefoxDriver driver = new FirefoxDriver(options);
        driver.manage().window().maximize();
        LogManager.info("Firefox driver was created");

        return driver;
    }
}
