package task3.Forms;

import task3.Elements.Button;
import task3.Elements.TextField;
import task3.Logging.LogManager;
import task3.WebDriverManagment.AlertHandler;

public class AlertsForm extends BaseForm
{
    private Button simpleAlertButton = new Button("//button[@id = 'alertButton']", "Click Button to see alert");
    private Button confirmBoxButton = new Button("//button[@id = 'confirmButton']", "On button click, confirm box will appear");
    private Button promptBoxButton = new Button("//button[@id = 'promtButton']", "On button click, prompt box will appear");
    private TextField confirmTextField = new TextField("//span[@id = 'confirmResult']", "Confirm text");
    private TextField promptTextField = new TextField("//span[@id = 'promptResult']", "Prompt text");


    public AlertsForm()
    {
        super("//div[@id = 'javascriptAlertsWrapper']", "Alerts form");
    }


    public void openSimpleAlert()
    {
        this.simpleAlertButton.click();
    }


    public void openConfirmBox()
    {
        this.confirmBoxButton.click();
    }


    public void openPromptBox()
    {
        this.promptBoxButton.click();
    }


    public String getConfirmText()
    {
        String confirmText = this.confirmTextField.getText();
        LogManager.info(String.format("The confirm text is: '%s'", confirmText));

        return confirmText;
    }


    public String getPromptText()
    {
        String promptText = this.promptTextField.getText();
        LogManager.info(String.format("The prompt text is: '%s'", promptText));

        return promptText;
    }


    public void confirmCurrentAlert()
    {
        AlertHandler.acceptAlert();
    }
}
