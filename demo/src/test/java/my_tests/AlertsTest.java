package my_tests;

import org.testng.annotations.Test;
import org.testng.Assert;

import task3.Forms.AlertsForm;
import task3.Forms.MenuForm;
import task3.Forms.MainPage;
import task3.WebDriverManagment.AlertHandler;

public class AlertsTest extends BaseTest
{
    @Test
    private void runAlertsTest()
    {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isFound(), "This is not the main page");

        mainPage.clickButton("Alerts, Frame & Windows");
        MenuForm formsPage = new MenuForm();
        formsPage.openForm("Alerts");
        AlertsForm alertsForm = new AlertsForm();
        Assert.assertTrue(alertsForm.isFound(), "Alerts form wasn't opened");

        alertsForm.openSimpleAlert();
        Assert.assertEquals(AlertHandler.getAlertText(), "You clicked a button", "Alert with text 'You clicked a button' wasn't opened");

        alertsForm.confirmCurrentAlert();
        Assert.assertEquals(AlertHandler.getAlertText(), null, "Alert didn't get closed");

        alertsForm.openConfirmBox();
        Assert.assertEquals(AlertHandler.getAlertText(), "Do you confirm action?", "Alert with text 'Do you confirm action?' wasn't opened");

        alertsForm.confirmCurrentAlert();
        Assert.assertEquals(AlertHandler.getAlertText(), null, "Alert didn't get closed");
        Assert.assertEquals(alertsForm.getConfirmText(), "You selected Ok", "Text 'You selected Ok' didn't appear");

        alertsForm.openPromptBox();
        Assert.assertEquals(AlertHandler.getAlertText(), "Please enter your name", "Alert with text 'Please enter your name' wasn't opened");

        String text = AlertHandler.enterRandomText();
        alertsForm.confirmCurrentAlert();
        Assert.assertEquals(AlertHandler.getAlertText(), null, "Alert didn't get closed");
        Assert.assertEquals("You entered " + text, alertsForm.getPromptText(), "Result is not equal to the entered text");
    }
}
