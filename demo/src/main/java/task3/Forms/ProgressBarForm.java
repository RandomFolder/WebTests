package task3.Forms;

import task3.Elements.Button;
import task3.Elements.ProgressBar;
import task3.Logging.LogManager;

public class ProgressBarForm extends BaseForm
{
    Button startOrStopProgressBarButton = new Button("//button[@id = 'startStopButton']", "Start & Stop button");
    ProgressBar progressBar = new ProgressBar("//div[contains(@class, 'progress-bar')]", "Progress Bar");


    public ProgressBarForm()
    {
        super("//div[@id = 'progressBarContainer']", "Progress Bar Form");
    }


    public void startProgressBar()
    {
        this.startOrStopProgressBarButton.click();
    }


    public int waitUntilValueIsReached(int value)
    {
        while (this.progressBar.getValue() < value)
        {
            LogManager.info(String.format("Progress bar reached value %d", this.progressBar.getValue()));
        }

        if (this.progressBar.getValue() != this.progressBar.getMaxValue())
        {
            this.startOrStopProgressBarButton.click();
        }

        return this.progressBar.getValue();
    }
}
