package task3.Logging;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public final class LogManager
{
    private static Logger logger = null;
    private static FileHandler fileHandler = null;


    public static void initLogger(String pathToDir, String fileName)
    {
        File f = new File(pathToDir);

        if (!f.exists())
        {
            f.mkdirs();
        }

        f = new File(pathToDir + "/" + fileName);

        if (f.exists())
        {
            f.delete();
        }

        try
        {
            f.createNewFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        try
        {
            fileHandler = new FileHandler(pathToDir + "/" + fileName, true);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        logger = Logger.getLogger("test logger");
        logger.addHandler(fileHandler);
        SimpleFormatter formatter = new SimpleFormatter();
        fileHandler.setFormatter(formatter);
    }


    public static void info(String msg)
    {
        if (logger != null)
        {
            logger.info(msg);
        }
    }


    public static void severe(String msg)
    {
        if (logger != null)
        {
            logger.severe(msg);
        }
    }


    public static void setLogLevel(String level)
    {
        if (logger != null)
        {
            switch (level)
            {
                case "warning":
                    logger.setLevel(Level.WARNING);
                    break;
                case "info":
                    logger.setLevel(Level.INFO);
                    break;
                case "config":
                    logger.setLevel(Level.CONFIG);
                    break;
                case "fine":
                    logger.setLevel(Level.FINE);
                    break;
                case "finer":
                    logger.setLevel(Level.FINER);
                    break;
                case "finest":
                    logger.setLevel(Level.FINEST);
                    break;
                default:
                    logger.setLevel(Level.SEVERE);
                    break;
            }
        }
    }


    public static void stopLogger()
    {
        if (logger != null)
        {
            logger.removeHandler(fileHandler);
            fileHandler.close();
            logger = null;
            fileHandler = null;
        }
    }
}
