package task3.Elements;

import org.openqa.selenium.WebElement;

import task3.Interfaces.IClickable;
import task3.Logging.LogManager;

public class Button extends BaseElement implements IClickable
{
    public Button(String xPath, String name)
    {
        super(xPath, name);
    }


    public void click()
    {
        WebElement thisElement = this.moveToElement();
        thisElement.click();

        LogManager.info(String.format("Clicked button '%s'", this.name));
    }
}
