package my_tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import task3.ConfigManagment.ConfigManager;
import task3.Forms.MenuForm;
import task3.Forms.MainPage;
import task3.Forms.RegistrationForm;
import task3.Forms.WebTablesForm;
import task3.Models.User;

public class TablesTest extends BaseTest
{
    @DataProvider
    private Object[][] getUserData()
    {
        User[] userData = ConfigManager.getUserData();
        User[][] result = new User[userData.length][1];

        for (int i = 0; i < userData.length; i++)
        {
            result[i][0] = userData[i];
        }

        return result;
    }


    @Test(dataProvider = "getUserData")
    private void runTablesTest(User user)
    {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isFound(), "This is not the main page");

        mainPage.clickButton("Elements");
        MenuForm formsPage = new MenuForm();
        formsPage.openForm("Web Tables");

        WebTablesForm webTablesForm = new WebTablesForm();
        Assert.assertTrue(webTablesForm.isFound(), "Web Tables Form wasn't found");

        webTablesForm.clickAddButton();

        RegistrationForm registrationForm = new RegistrationForm();
        Assert.assertTrue(registrationForm.isFound(), "Registration Form wasn't found");

        registrationForm.addUser(user);
        User lastUser = webTablesForm.getLastUser();
        int userCount = webTablesForm.getUserCount();
        Assert.assertFalse(registrationForm.isFound(), "Registration Form didn't get closed");
        Assert.assertTrue(user.equals(lastUser), "User wasn't added to the table");

        webTablesForm.deleteLastUser();
        lastUser = webTablesForm.getLastUser();
        int newUserCount = webTablesForm.getUserCount();
        Assert.assertNotEquals(userCount, newUserCount, "User count didn't change");
        Assert.assertFalse(user.equals(lastUser), "User didn't get deleted");
    }
}
