package com.javarush.task.task14.task1408;

/**
 * Created by Владимир on 10.03.2017.
 */
public class UkrainianHen extends Hen {
    @Override
    String getDescription() {
        return super.getDescription()+" Моя страна - "+Country.UKRAINE+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
    @Override
    int getCountOfEggsPerMonth() {
        return 20;
    }
}
