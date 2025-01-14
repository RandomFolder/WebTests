package task3.Models;

import java.util.List;

public class BrowserParameters
{
    private String browserName;
    private String url;
    private List<String> options;
    private Integer defaultWaitTime;


    public String getBrowserName()
    {
        return this.browserName;
    }


    public String getURL()
    {
        return this.url;
    }


    public List<String> getOptions()
    {
        return this.options;
    }


    public Integer getDefaultWaitTime()
    {
        return this.defaultWaitTime;
    }
}
