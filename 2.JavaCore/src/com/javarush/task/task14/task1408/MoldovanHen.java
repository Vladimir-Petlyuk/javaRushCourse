package com.javarush.task.task14.task1408;

/**
 * Created by Владимир on 10.03.2017.
 */
public class MoldovanHen extends Hen {
    String getDescription() {
        return super.getDescription()+" Моя страна - "+Country.MOLDOVA+". Я несу "+getCountOfEggsPerMonth()+" яиц в месяц.";
    }
    @Override
    int getCountOfEggsPerMonth() {
        return 30;
    }
}