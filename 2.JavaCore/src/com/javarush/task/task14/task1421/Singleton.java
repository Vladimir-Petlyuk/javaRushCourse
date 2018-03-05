package com.javarush.task.task14.task1421;

/**
 * Created by Владимир on 10.03.2017.
 */
class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

}
