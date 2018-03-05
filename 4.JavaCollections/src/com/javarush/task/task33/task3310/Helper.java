package com.javarush.task.task33.task3310;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * Created by Владимир on 02.11.2017.
 */
public class Helper {
    //генерировать случайную строку
    public static String generateRandomString() {

        SecureRandom secureRandom = new SecureRandom();
        return new BigInteger(100, secureRandom).toString(32);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
