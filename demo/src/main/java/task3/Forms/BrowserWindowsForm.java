package task3.Forms;

import task3.Elements.Button;

public class BrowserWindowsForm extends BaseForm
{
    private Button newTabButton = new Button("//button[@id = 'tabButton']", "New Tab");


    public BrowserWindowsForm()
    {
        super("//div[@id = 'browserWindows']", "Browser Windows Form");
    }


    public void openNewTab()
    {
        this.newTabButton.click();
    }
}
