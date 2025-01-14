package my_tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import task3.Forms.BrowserWindowsForm;
import task3.Forms.MenuForm;
import task3.Forms.LinksForm;
import task3.Forms.MainPage;
import task3.Forms.SamplePage;
import task3.WebDriverManagment.TabsHandler;

public class HandlesTest extends BaseTest
{
    @Test
    private void runHandlesTest()
    {
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isFound(), "This is not the main page");

        mainPage.clickButton("Alerts, Frame & Windows");
        MenuForm formsPage = new MenuForm();
        formsPage.openForm("Browser Windows");

        BrowserWindowsForm browserWindowsForm = new BrowserWindowsForm();
        Assert.assertTrue(browserWindowsForm.isFound(), "Browser Windows form wasn't found");

        int tabsCount = TabsHandler.getTabsCount();
        browserWindowsForm.openNewTab();
        int newTabsCount = TabsHandler.getTabsCount();
        SamplePage samplePage = new SamplePage();
        Assert.assertNotEquals(tabsCount, newTabsCount, "New tab wasn't opened");
        TabsHandler.goToLastTab();
        Assert.assertTrue(TabsHandler.getCurrentPageURL().endsWith("/sample"), "New tab's title is not '/sample'");
        Assert.assertTrue(samplePage.isFound(), "Sample page wasn't found");

        TabsHandler.closeCurrentTab();
        TabsHandler.goToFirstTab();
        Assert.assertTrue(browserWindowsForm.isFound(), "Current page doesn't contain Browser Windows form");

        formsPage.openForm("Elements", "Links");
        LinksForm linksForm = new LinksForm();
        Assert.assertTrue(linksForm.isFound(), "Links form wasn't opened");

        TabsHandler.rememberCurrentPage();

        tabsCount = TabsHandler.getTabsCount();
        linksForm.clickHomeLink();
        newTabsCount = TabsHandler.getTabsCount();
        TabsHandler.goToLastTab();
        Assert.assertEquals(tabsCount, newTabsCount - 1, "New tab wasn't opened");
        Assert.assertTrue(mainPage.isFound(), "This is not the main page");

        TabsHandler.goToPreviousPage();
        Assert.assertTrue(linksForm.isFound(), "There is no links form here");
    }
}
