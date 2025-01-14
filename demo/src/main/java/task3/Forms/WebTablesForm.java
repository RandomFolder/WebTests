package task3.Forms;

import java.lang.reflect.Field;
import java.util.List;

import org.openqa.selenium.WebElement;

import task3.Constants.Constants;
import task3.Elements.Button;
import task3.Elements.InputField;
import task3.Elements.TextField;
import task3.Models.User;
import task3.WebDriverManagment.WebDriverManager;

public class WebTablesForm extends BaseForm
{
    private TextField currentPageField = new TextField("//input[@aria-label='jump to page']", "Current page");
    private TextField totalPagesField = new TextField("//span[@class='-totalPages']", "Total pages");
    private Button nextButton = new Button("//button[text() = 'Next']", "Next");
    private Button addButton = new Button("//button[@id='addNewRecordButton']", "Add");
    private Button deleteLastUserButton = new Button("(//span[contains(@id, 'delete-record')])[last()]", "Delete button");
    private InputField jumpToPage = new InputField("//input[@aria-label='jump to page']", "Jump to page");

    private String tableFilledCellsXPath = "//div[@role='row' and not (contains(@class, '-padRow'))]/div[not(*)]";
    private String usersXPath = "//div[@role='row' and not (contains(@class, '-padRow')) and not (@class='rt-tr')]";


    public WebTablesForm()
    {
        super("//button[@id='addNewRecordButton']", "Web Tables Form");
    }


    private void goToLastPage()
    {
        int currentPage = Integer.parseInt(this.currentPageField.getAttribute(Constants.CURRENT_PAGE_VALUE_ATTR));
        int totalPages = Integer.parseInt(this.totalPagesField.getText());

        for (int i = currentPage; i < totalPages; i++)
        {
            this.nextButton.click();
        }
    }


    public void clickAddButton()
    {
        this.addButton.click();
    }


    public User getLastUser()
    {
        this.goToLastPage();

        User lastUser = new User();

        Field[] userFields = User.class.getDeclaredFields();
        List<WebElement> elements = WebDriverManager.findElements(this.tableFilledCellsXPath);

        try
        {
            for (int i = elements.size() - userFields.length, j = 0; i < elements.size(); i++, j++)
            {
                userFields[j].setAccessible(true);
                Object fieldValueAsStr = elements.get(i).getText();

                userFields[j].set(lastUser, userFields[j].getType().cast(fieldValueAsStr));
            }

            return lastUser;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }


    public void deleteLastUser()
    {
        this.goToLastPage();

        this.deleteLastUserButton.click();
    }


    public int getUserCount()
    {
        this.jumpToPage.click();
        this.jumpToPage.clear();
        this.jumpToPage.sendKeys("1");

        int totalPages = Integer.parseInt(this.totalPagesField.getText());
        int userCount = 0;

        for (int currentPage = 1; currentPage <= totalPages; currentPage++)
        {
            userCount += WebDriverManager.findElements(this.usersXPath).size();

            this.nextButton.click();
        }

        return userCount;
    }
}
