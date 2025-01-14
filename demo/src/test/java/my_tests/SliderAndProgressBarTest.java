package my_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import task3.Forms.MenuForm;
import task3.Forms.MainPage;
import task3.Forms.ProgressBarForm;
import task3.Forms.SliderForm;
import task3.Utils.RandomNumberGenerator;

public class SliderAndProgressBarTest extends BaseTest
{
    @Test
    private void runSliderAndProgressBarTest() throws InterruptedException
    {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isFound(), "This is not the main page");

        mainPage.clickButton("Widgets");
        MenuForm formsPage = new MenuForm();
        formsPage.openForm("Slider");

        SliderForm sliderForm = new SliderForm();
        Assert.assertTrue(sliderForm.isFound(), "Slider form wasn't found");

        int randomValue = RandomNumberGenerator.getRandomInt(0, 100);
        sliderForm.setSliderValue(randomValue);
        Assert.assertEquals(randomValue, sliderForm.getSliderValue(), "Slider value wasn't set to randomly generated value");

        formsPage.openForm("Progress Bar");
        ProgressBarForm progressBarForm = new ProgressBarForm();
        Assert.assertTrue(progressBarForm.isFound(), "Progress Bar Form wasn't found");

        progressBarForm.startProgressBar();
        int value = progressBarForm.waitUntilValueIsReached(randomValue);
        Assert.assertTrue(value - randomValue <= 2, "Error is greater than 2%");
    }
}
