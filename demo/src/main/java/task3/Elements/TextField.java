package task3.Elements;

public class TextField extends BaseElement
{
    public TextField(String xPath, String name)
    {
        super(xPath, name);
    }


    public String getText()
    {
        return this.waitForElementPresent().getText();
    }
}
