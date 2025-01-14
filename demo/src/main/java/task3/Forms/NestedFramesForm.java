package task3.Forms;

import task3.Elements.TextField;
import task3.Logging.LogManager;
import task3.WebDriverManagment.IFrameHandler;

public class NestedFramesForm extends BaseForm
{
    private String parentFrameXPath = "//iframe[@id = 'frame1']";
    private String childFrameXPath = "//iframe[contains(@srcdoc, 'Child Iframe')]";
    private TextField parentFrameTextField = new TextField("//body", "Parent frame body");
    private TextField childFrameTextField = new TextField("//p", "Child frame body");


    public NestedFramesForm()
    {
        super("//div[@id = 'framesWrapper']", "Nested frames form");
    }


    public boolean isParentFrameTextContains(String value)
    {
        IFrameHandler.switchToFrame(this.parentFrameXPath);
        String text = this.parentFrameTextField.getText();
        IFrameHandler.switchToDefaultContent();

        LogManager.info(String.format("Recieved the following text from the parent frame: '%s'", text));

        return text.contains(value);
    }


    public boolean isChildFrameTextContains(String value)
    {
        IFrameHandler.switchToFrame(this.parentFrameXPath);
        IFrameHandler.switchToFrame(this.childFrameXPath);
        String text = this.childFrameTextField.getText();
        IFrameHandler.switchToDefaultContent();

        LogManager.info(String.format("Recieved the following text from the child frame: '%s'", text));

        return text.contains(value);
    }
}
