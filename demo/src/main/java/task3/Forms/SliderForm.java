package task3.Forms;

import task3.Constants.Constants;
import task3.Elements.Slider;
import task3.Elements.TextField;

public class SliderForm extends BaseForm
{
    private Slider slider = new Slider("//input[contains(@class, 'range-slider')]", "Slider");
    private TextField sliderTextField = new TextField("//input[@id = 'sliderValue']", "Slider value");


    public SliderForm()
    {
        super("//div[@id = 'sliderContainer']", "Slider form");
    }


    public void setSliderValue(int value)
    {
        this.slider.moveToValue(value);
    }


    public int getSliderValue()
    {
        String sliderValueAsStr = sliderTextField.getAttribute(Constants.SLIDER_TEXT_FIELD_VALUE);

        return Integer.parseInt(sliderValueAsStr);
    }
}
