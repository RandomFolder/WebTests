package task3.Forms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import task3.Logging.LogManager;
import task3.WebDriverManagment.WebDriverManager;

public abstract class BaseForm
{
    protected String uniqueElementXPath;
    protected String name;


    public BaseForm(String uniqueElementXPath, String name)
    {
        this.uniqueElementXPath = uniqueElementXPath;
        this.name = name;
    }


    public boolean isFound()
    {
        WebElement element = WebDriverManager.waitForElementPresent(By.xpath(this.uniqueElementXPath), WebDriverManager.getDefaultWaitTime());
        if (element != null)
        {
            LogManager.info(String.format("'%s' was found", this.name));
        }
        else
        {
            LogManager.info(String.format("'%s' wasn't found", this.name));
        }

        return element != null;
    }
}
