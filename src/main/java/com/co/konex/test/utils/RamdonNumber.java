package com.co.konex.test.utils;

import java.util.Random;

public class RamdonNumber {


    protected static Random random = new Random();
    protected static int randomNumber;

    /**
     * Generates a random number representing a month.
     * The generated number is between 1 and 12 (inclusive).
     *
     * @return A random number representing a month.
     */
    public static int months() {
        return randomNumber = random.nextInt(11) + 1;
    }

    /**
     * Generates a random number representing a day between 1 and 29 (inclusive).
     *
     * @return a String representation of the random day
     */
    public static String  days() {
        randomNumber = random.nextInt(29) + 1;
        return Integer.toString(randomNumber);
    }

    /**
     * Generates a random year between 1900 and 2024 (inclusive) and returns it as a string.
     *
     * @return The randomly generated year as a string.
     */
    public static String years() {
        randomNumber = random.nextInt(2024 - 1900 + 1) + 1900;
        return Integer.toString(randomNumber);
    }

    /**
     * Generates a random gender.
     *
     * @return The random gender, represented as an integer. 1 for male, 2 for female.
     */
    public static Integer gender() {
        randomNumber = random.nextInt(2) + 1;
        return randomNumber;
    }
}
