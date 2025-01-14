package task3.Elements;

import org.openqa.selenium.WebElement;

import task3.Interfaces.IClickable;
import task3.Logging.LogManager;

public class InputField extends BaseElement implements IClickable
{
    public InputField(String xPath, String name)
    {
        super(xPath, name);
    }


    public void sendKeys(String keys)
    {
        WebElement thisElement = this.waitForElementPresent();
        thisElement.sendKeys(keys);

        LogManager.info(String.format("Sent the following keys to input field '%s': '%s'", this.name, keys));
    }


    public void clear()
    {
        WebElement thisElement = this.waitForElementPresent();
        thisElement.clear();

        LogManager.info(String.format("Cleared input field '%s'", this.name));
    }


    @Override
    public void click()
    {
        WebElement thisElement = this.moveToElement();
        thisElement.click();

        LogManager.info(String.format("Clicked input field '%s'", this.name));
    }
}
