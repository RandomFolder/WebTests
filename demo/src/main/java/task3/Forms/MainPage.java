package task3.Forms;

import task3.Elements.Button;

public class MainPage extends BaseForm
{
    private String buttonXPathTemplate = "//*[text()='%s']";


    public MainPage()
    {
        super("//div[@class = 'home-body']", "main page");
    }


    public void clickButton(String buttonName)
    {
        Button button = new Button(String.format(this.buttonXPathTemplate, buttonName), buttonName);
        button.click();
    }
}
