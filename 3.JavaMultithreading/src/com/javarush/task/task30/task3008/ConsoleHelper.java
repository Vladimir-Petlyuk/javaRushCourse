package com.javarush.task.task30.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Владимир on 27.09.2017.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString(){
        String line;
        while (true) {
            try {
                line = bufferedReader.readLine();
                break;
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
                continue;
            }
        }
        return line;
    }
    public static int readInt(){
        int line;
        while (true) {
            try {
                line = Integer.parseInt(readString());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
                continue;
            }
        }
        return line;
    }
}
