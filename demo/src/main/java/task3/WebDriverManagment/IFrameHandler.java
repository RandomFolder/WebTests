package task3.WebDriverManagment;

import org.openqa.selenium.WebElement;

import task3.Logging.LogManager;

public class IFrameHandler
{
    public static void switchToFrame(String xPath)
    {
        WebElement element = WebDriverManager.findElement(xPath);
        WebDriverManager.getInstance().switchTo().frame(element);

        LogManager.info(String.format("Switched to frame by xpath '%s'", xPath));
    }
    
    
    public static void switchToDefaultContent()
    {
        WebDriverManager.getInstance().switchTo().defaultContent();

        LogManager.info("Switched to default content");
    }
}
