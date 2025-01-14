package task3.Forms;

import java.lang.reflect.Field;

import task3.Elements.Button;
import task3.Elements.InputField;
import task3.Models.User;

public class RegistrationForm extends BaseForm
{
    private String inputFieldXPathTemplate = "//input[contains( translate(@id, 'ABCDEFGHIJKLMNOPQRSTUVWXYZ', 'abcdefghijklmnopqrstuvwxyz'), '%s')]";
    private Button submitButton = new Button("//button[@id = 'submit']", "Submit");


    public RegistrationForm()
    {
        super("//form[@id='userForm']", "Registration Form");
    }


    public void addUser(User user)
    {
        try
        {
            Field[] fields = User.class.getDeclaredFields();

            for (int i = 0; i < fields.length; i++)
            {
                InputField input = new InputField(String.format(this.inputFieldXPathTemplate, fields[i].getName().toLowerCase()), fields[i].getName());
                input.click();
                fields[i].setAccessible(true);
                input.sendKeys(fields[i].get(user).toString());
            }

            this.submitButton.click();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
