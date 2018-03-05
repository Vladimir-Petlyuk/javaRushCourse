package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Object> list = new ArrayList<>();
        while (true) {
            Object o = scanner.nextLine();
            if (o.equals("exit")) {
                break;
            } else list.add(o);
        }
        for (Object o : list) {

            if (((String) o).contains(".")) {
                try {
                    Double d = Double.parseDouble((String) o);
                    print(d);
                } catch (Exception e) {
                    print((String) o);
                }
            } else {
                try {
                    int i = Integer.parseInt((String) o);
                    if (i > 0 && i < 128) {
                        print((short) i);
                    } else if (i <= 0 || i >= 128) {
                        print(i);
                    }
                } catch (Exception e) {
                    print((String) o);
                }

            }
        }
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
