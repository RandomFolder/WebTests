package my_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import task3.Forms.MenuForm;
import task3.Forms.FramesForm;
import task3.Forms.MainPage;
import task3.Forms.NestedFramesForm;

public class IFrameTest extends BaseTest
{
    @Test
    private void runIFrameTest()
    {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isFound(), "This is not the main page");

        mainPage.clickButton("Alerts, Frame & Windows");
        MenuForm formsPage = new MenuForm();
        formsPage.openForm("Nested Frames");

        NestedFramesForm nestedFramesForm = new NestedFramesForm();
        Assert.assertTrue(nestedFramesForm.isFound(), "Nested frames form wasn't found");
        Assert.assertTrue(nestedFramesForm.isParentFrameTextContains("Parent frame"), "There is no text 'Parent frame'");
        Assert.assertTrue(nestedFramesForm.isChildFrameTextContains("Child Iframe"), "There is no text 'Child frame'");

        formsPage.openForm("Frames");

        FramesForm framesForm = new FramesForm();
        Assert.assertTrue(framesForm.isFound(), "Frames form wasn't found");
        Assert.assertEquals(framesForm.getTextFromFirstFrame(), framesForm.getTextFromSecondFrame(), "frame #1 and frame #2 have different text");
    }
}
