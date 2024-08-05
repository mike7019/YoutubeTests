package com.co.konex.test.utils;

import java.util.Random;

public class RamdonNumber {

    protected static Random random = new Random();
    protected static int randomNumber;

    public static int months() {
        return randomNumber = random.nextInt(11) + 1;
    }

    public static String  days() {
        randomNumber = random.nextInt(29) + 1;
        return Integer.toString(randomNumber);
    }

    public static String years() {
        randomNumber = random.nextInt(2024 - 1900 + 1) + 1900;
        return Integer.toString(randomNumber);
    }

    public static Integer gender() {
        randomNumber = random.nextInt(2) + 1;
        return randomNumber;
    }
}
