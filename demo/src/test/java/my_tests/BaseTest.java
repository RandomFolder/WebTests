package my_tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import task3.ConfigManagment.ConfigManager;
import task3.Logging.LogManager;
import task3.Models.BrowserParameters;
import task3.Models.LoggerParameters;
import task3.WebDriverManagment.WebDriverManager;

public abstract class BaseTest
{
    @BeforeMethod
    public void setup()
    {
        LoggerParameters loggerParameters = ConfigManager.getLoggerParameters();
        LogManager.initLogger(loggerParameters.getPathToDir(), loggerParameters.getFileName());
        LogManager.setLogLevel(loggerParameters.getLogLevel());
        
        BrowserParameters browserParameters = ConfigManager.getBrowserParameters();
        WebDriverManager.setBrowserParameters(browserParameters);
        WebDriverManager.goToDefaultURL();
    }


    @AfterMethod
    public void closeBrowser()
    {
        WebDriverManager.close();
        LogManager.stopLogger();
    }
}
