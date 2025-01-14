package task3.Factories;

import java.util.List;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import task3.Logging.LogManager;

public class ChromeFactory extends BaseFactory
{
    @Override
    public WebDriver createDriver(List<String> opts)
    {
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        
        if (opts != null)
        {
            options.addArguments(opts);
            LogManager.info("Additional browser options were passed");
        }

        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        LogManager.info("Chrome driver was created");

        return driver;
    }
}
