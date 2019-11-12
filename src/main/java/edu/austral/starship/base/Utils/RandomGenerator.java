package edu.austral.starship.base.Utils;

public class RandomGenerator {

    public static boolean getBoolean(double probability){
        return Math.random() < .5;
    }

    public static double getRandom() {
        return Math.random();
    }

    public static int getRandom(int bound){
        return (int) (bound * Math.random());
    }

    public static int getRandom(int min, int max){
        return min + getRandom(max - min);
    }
}
