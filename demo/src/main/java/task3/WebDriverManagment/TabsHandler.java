package task3.WebDriverManagment;

import task3.Logging.LogManager;

public class TabsHandler
{
    private static String rememberedWindowHandle = null;


    public static void goToLastTab()
    {
        Object[] windowHandles = WebDriverManager.getInstance().getWindowHandles().toArray();

        WebDriverManager.getInstance().switchTo().window((String)windowHandles[windowHandles.length - 1]);

        LogManager.info("Switched to the last tab");
    }


    public static void goToFirstTab()
    {
        Object[] windowHandles = WebDriverManager.getInstance().getWindowHandles().toArray();

        WebDriverManager.getInstance().switchTo().window((String)windowHandles[0]);

        LogManager.info("Switched to the first tab");
    }


    public static void goToPreviousPage()
    {
        WebDriverManager.getInstance().switchTo().window(rememberedWindowHandle);

        LogManager.info("Switched to the previous tab");
    }


    public static void rememberCurrentPage()
    {
        rememberedWindowHandle = WebDriverManager.getInstance().getWindowHandle();
    }


    public static void closeCurrentTab()
    {
        WebDriverManager.getInstance().close();

        LogManager.info("Closed current tab");
    }


    public static String getCurrentTabTitle()
    {
        return WebDriverManager.getInstance().getTitle();
    }


    public static String getCurrentPageURL()
    {
        return WebDriverManager.getInstance().getCurrentUrl();
    }


    public static int getTabsCount()
    {
        return WebDriverManager.getInstance().getWindowHandles().size();
    }
}
