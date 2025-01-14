package task3.Utils;

import java.util.Random;

public class RandomNumberGenerator
{
    public static int getRandomInt(int rangeMin, int rangeMax)
    {
        Random random = new Random();
        return random.nextInt(rangeMax - rangeMin + 1) + rangeMin;
    }    
}
