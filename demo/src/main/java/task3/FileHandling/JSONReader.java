package task3.FileHandling;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONReader
{
    public static <T> T readFile(String filepath, Class<T> type)
    {
        try
        {
            File f = new File(filepath);
            ObjectMapper objMapper = new ObjectMapper();
            objMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            T res = objMapper.readValue(f, type);

            return res;
        }
        catch (IOException e)
        {
            return null;
        }
    }
}
