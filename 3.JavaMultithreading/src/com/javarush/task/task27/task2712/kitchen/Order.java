package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.Tablet;

import java.io.IOException;
import java.util.List;

import static com.javarush.task.task27.task2712.ConsoleHelper.writeMessage;

/**
 * Created by Владимир on 10.10.2017.
 */
public class Order {
    private final Tablet tablet;
    protected List<Dish> dishes;


    public Order(Tablet tablet) throws IOException {
        this.tablet = tablet;
        initDishes();
    }

    protected void initDishes() throws IOException {
        ConsoleHelper.writeMessage(Dish.allDishesToString());
        dishes = ConsoleHelper.getAllDishesForOrder();
    }

    @Override
    public String toString() {
        return dishes.isEmpty() ? "" : "Your order: " + dishes + " of Tablet{" + "number=" + tablet.getNumber() + '}'
                +", cooking time "+getTotalCookingTime()+"min";
    }

    public int getTotalCookingTime(){
        int time = 0;
        for(Dish dish:dishes){
            time+=dish.getDuration();
        }
        return time;
    }


    public boolean isEmpty(){
        return dishes.isEmpty();
    }

    public List<Dish> getDishes() {
        return dishes;
    }

    public Tablet getTablet() {
        return tablet;
    }
}
