package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by Владимир on 15.10.2017.
 */
public class Waiter implements Observer {
    @Override
    public void update(Observable observable, Object o)
    {
        Cook cook = (Cook) observable;
        Order order = (Order) o;
    }
}
