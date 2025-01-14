package task3.ConfigManagment;

import task3.FileHandling.JSONReader;
import task3.Models.BrowserParameters;
import task3.Models.LoggerParameters;
import task3.Models.User;

public class ConfigManager
{
    private static String pathToBrowserConfigData = "src/main/resources/browser_parameters.json";
    private static String pathToLogConfigData = "src/main/resources/logger_parameters.json";
    private static String pathToUserData = "src/main/resources/user_data.json";


    public static BrowserParameters getBrowserParameters()
    {
        return JSONReader.readFile(pathToBrowserConfigData, BrowserParameters.class);
    }


    public static LoggerParameters getLoggerParameters()
    {
        return JSONReader.readFile(pathToLogConfigData, LoggerParameters.class);
    }


    public static User[] getUserData()
    {
        return JSONReader.readFile(pathToUserData, User[].class);
    }
}
