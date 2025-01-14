package task3.WebDriverManagment;

import org.openqa.selenium.NoAlertPresentException;
import com.github.javafaker.Faker;

import task3.Logging.LogManager;

public class AlertHandler
{
    public static String getAlertText()
    {
        try
        {
            String alertText = WebDriverManager.getInstance().switchTo().alert().getText();
            LogManager.info(String.format("Recieved text from alert: '%s'", alertText));
            return alertText;
        }
        catch (NoAlertPresentException e)
        {
            LogManager.severe("There is no alert present right now");
            return null;
        }
    }


    public static void acceptAlert()
    {
        try
        {
            WebDriverManager.getInstance().switchTo().alert().accept();
            LogManager.info("Accepted current alert");
        }
        catch (NoAlertPresentException e)
        {
            LogManager.severe("There is no alert present right now");
            return;
        }
    }


    public static String enterRandomText()
    {
        try
        {
            Faker faker = new Faker();
            String data = faker.name().fullName();
            WebDriverManager.getInstance().switchTo().alert().sendKeys(data);

            LogManager.info(String.format("Sent the following data to alert: '%s'", data));

            return data;
        }
        catch (NoAlertPresentException e)
        {
            LogManager.severe("There is no alert present right now");
            return null;
        }
    }
}
