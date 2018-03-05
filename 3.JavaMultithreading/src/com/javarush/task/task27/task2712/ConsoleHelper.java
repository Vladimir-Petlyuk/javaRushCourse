package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by Владимир on 10.10.2017.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return bufferedReader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> list = new ArrayList<>();
        writeMessage("Выберите блюдо: " + Dish.allDishesToString());
        boolean bol = true;
        while (bol) {
            String dish = readString();
            switch (dish) {
                case "Fish":
                    list.add(Dish.Fish);
                    break;
                case "Steak":
                    list.add(Dish.Steak);
                    break;
                case "Soup":
                    list.add(Dish.Soup);
                    break;
                case "Juice":
                    list.add(Dish.Juice);
                    break;
                case "Water":
                    list.add(Dish.Water);
                    break;
                case "exit":
                    bol = false;
                    break;
                default:
                    writeMessage("Такого блюда нет!");
                    continue;
            }
        }
         return list;
    }
}

