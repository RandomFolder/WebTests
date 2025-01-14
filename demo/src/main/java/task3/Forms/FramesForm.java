package task3.Forms;

import task3.Elements.TextField;
import task3.Logging.LogManager;
import task3.WebDriverManagment.IFrameHandler;

public class FramesForm extends BaseForm
{
    private String firstFrameXPath = "//iframe[@id = 'frame1']";
    private String secondFrameXPath = "//iframe[@id = 'frame2']";
    private TextField frameTextField = new TextField("//h1[@id = 'sampleHeading']", "First frame header");


    public FramesForm()
    {
        super("//div[@id = 'framesWrapper']", "Frames form");
    }


    public String getTextFromFirstFrame()
    {
        IFrameHandler.switchToFrame(this.firstFrameXPath);
        frameTextField.setName("First frame header");
        String result = this.frameTextField.getText();
        IFrameHandler.switchToDefaultContent();

        LogManager.info(String.format("Recieved the following text from the first frame: '%s'", result));

        return result;
    }


    public String getTextFromSecondFrame()
    {
        IFrameHandler.switchToFrame(this.secondFrameXPath);
        frameTextField.setName("Second frame header");
        String result = this.frameTextField.getText();
        IFrameHandler.switchToDefaultContent();

        LogManager.info(String.format("Recieved the following text from the second frame: '%s'", result));

        return result;
    }
}
