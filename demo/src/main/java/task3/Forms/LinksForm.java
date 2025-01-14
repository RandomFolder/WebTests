package task3.Forms;

import task3.Elements.Button;

public class LinksForm extends BaseForm
{
    private Button homeLink = new Button("//a[@id = 'simpleLink']", "Home link");


    public LinksForm()
    {
        super("//div[@id = 'linkWrapper']", "Links Form");
    }


    public void clickHomeLink()
    {
        this.homeLink.click();
    }
}
