package task3.Elements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import task3.Constants.Constants;
import task3.Logging.LogManager;

public class Slider extends BaseElement
{
    public Slider(String xPath, String name)
    {
        super(xPath, name);
    }


    public int getMinValue()
    {
        String valueAsStr = this.getAttribute(Constants.SLIDER_MIN_VALUE_ATTR_NAME);

        return Integer.parseInt(valueAsStr);
    }


    public int getMaxValue()
    {
        String valueAsStr = this.getAttribute(Constants.SLIDER_MAX_VALUE_ATTR_NAME);

        return Integer.parseInt(valueAsStr);
    }


    public int getCurrentValue()
    {
        String valueAsStr = this.getAttribute(Constants.SLIDER_CURRENT_VALUE_ATTR_NAME);

        return Integer.parseInt(valueAsStr);
    }


    public void moveToValue(int value)
    {
        WebElement thisElement = this.moveToElement();
        thisElement.click();
        
        while (this.getCurrentValue() != value)
        {
            if (value < this.getCurrentValue())
            {
                thisElement.sendKeys(Keys.ARROW_LEFT);
            }
            else
            {
                thisElement.sendKeys(Keys.ARROW_RIGHT);
            }
        }

        LogManager.info(String.format("Value of slider '%s' was set to %d", this.name, this.getCurrentValue()));
    }
}
