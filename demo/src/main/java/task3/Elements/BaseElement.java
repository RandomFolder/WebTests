package task3.Elements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import task3.WebDriverManagment.WebDriverManager;

public abstract class BaseElement
{
    protected String xPath;
    protected String name;


    public BaseElement(String xPath, String name)
    {
        this.xPath = xPath;
        this.name = name;
    }


    public String getAttribute(String attribute)
    {
        WebElement thisElement = this.waitForElementPresent();
        return thisElement.getAttribute(attribute);
    }


    protected WebElement waitForElementPresent()
    {
        return WebDriverManager.waitForElementPresent(By.xpath(this.xPath), WebDriverManager.getDefaultWaitTime());
    }


    protected WebElement moveToElement()
    {
        WebElement thisElement = this.waitForElementPresent();
        ((JavascriptExecutor)WebDriverManager.getInstance()).executeScript("arguments[0].scrollIntoView();", thisElement);

        return thisElement;
    }


    public void waitUntilAttributeContainsValue(String attribute, String value, int waitTime)
    {
        WebDriverWait wait = new WebDriverWait(WebDriverManager.getInstance(), Duration.ofSeconds(waitTime));
        ExpectedCondition<Boolean> elementAttributeContainsString = arg -> this.getAttribute(attribute).contains(value);
        wait.until(elementAttributeContainsString);
    }


    public void setName(String name)
    {
        this.name = name;
    }
}
