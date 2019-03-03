package Game;

public class RandNum {

    public static int randNum (int min , int max) {
        return (int)(min+Math.random()*(max-min+1));
    }

}
