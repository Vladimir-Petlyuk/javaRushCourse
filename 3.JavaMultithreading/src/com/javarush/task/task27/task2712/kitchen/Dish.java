package com.javarush.task.task27.task2712.kitchen;

/**
 * Created by Владимир on 10.10.2017.
 */
public enum Dish {

    Fish(25), Steak(30), Soup(15), Juice(5), Water(3);

    private int duration;


    Dish(int duration) {
        this.duration = duration;
    }

    public static String allDishesToString(){
        return Fish+", "+Steak+", "+Soup+", "+Juice+", "+Water;
    }

    public int getDuration() {
        return duration;
    }
}
