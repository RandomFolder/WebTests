package task3.Elements;

import task3.Constants.Constants;

public class ProgressBar extends BaseElement
{
    public ProgressBar(String xPath, String name)
    {
        super(xPath, name);
    }


    public int getValue()
    {
        String valueAsStr = this.getAttribute(Constants.PROGRESS_BAR_VALUE_TEXT);
        valueAsStr = valueAsStr.replaceAll(Constants.NON_DIGIT_CHARACTERS_REMOVAL_PATTERN, Constants.NON_DIGIT_CHARACTER_REPLACEMENT);

        return Integer.parseInt(valueAsStr);
    }


    public int getMaxValue()
    {
        String valueAsStr = this.getAttribute(Constants.PROGRESS_BAR_MAX_VALUE_TEXT);

        return Integer.parseInt(valueAsStr);
    }
}
