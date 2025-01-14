package task3.Forms;

import task3.Constants.Constants;
import task3.Elements.Button;
import task3.WebDriverManagment.WebDriverManager;

public class MenuForm extends BaseForm
{
    private String formButtonXPathTemplate = "//li[.//span[text() = '%s']]";
    private String elementListButtonXPathTemplate = "//div[.//div[text() = '%s']]/div[contains(@class, 'element-list')]";
    private String groupButtonXPathTemplate = "//div[@class = 'element-group' and .//div[text() = '%s']]";


    public MenuForm()
    {
        super("//div[@class = 'accordion']", "Menu Form");
    }


    public void openForm(String formName)
    {
        Button button = new Button(String.format(this.formButtonXPathTemplate, formName), formName);
        button.click();
    }


    public void openForm(String groupName, String formName)
    {
        Button button = new Button(String.format(this.elementListButtonXPathTemplate, groupName), groupName);

        if (!button.getAttribute(Constants.CLASS_ATTRIBUTE_NAME).contains(Constants.VALUE_THAT_CLASS_MUST_CONTAIN))
        {
            Button actualButton = new Button(String.format(this.groupButtonXPathTemplate, groupName), groupName);
            actualButton.click();
            button.waitUntilAttributeContainsValue(Constants.CLASS_ATTRIBUTE_NAME, Constants.VALUE_THAT_CLASS_MUST_CONTAIN, WebDriverManager.getDefaultWaitTime());
        }

        this.openForm(formName);
    }
}
