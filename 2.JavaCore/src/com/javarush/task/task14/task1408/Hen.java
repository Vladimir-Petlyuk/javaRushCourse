package com.javarush.task.task14.task1408;

/**
 * Created by Владимир on 10.03.2017.
 */
public abstract class Hen {
    abstract int getCountOfEggsPerMonth();

    String getDescription(){
        return "Я - курица.";
    }
}
