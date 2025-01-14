package task3.Factories;

import java.util.List;

import org.openqa.selenium.WebDriver;

public abstract class BaseFactory
{
    public abstract WebDriver createDriver(List<String> options);    
}
