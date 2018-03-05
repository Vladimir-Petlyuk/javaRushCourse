package com.javarush.task.task14.task1408;

/**
 * Created by Владимир on 10.03.2017.
 */
public class RussianHen extends Hen {
    @Override
    String getDescription() {
        return super.getDescription()+" Моя страна - "+Country.RUSSIA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }

    @Override
    int getCountOfEggsPerMonth() {
        return 10;

    }
}
