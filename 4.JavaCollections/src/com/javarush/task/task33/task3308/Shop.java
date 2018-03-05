package com.javarush.task.task33.task3308;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Владимир on 28.10.2017.
 */
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

    //В классе Shop.Goods должен быть создан список строк names.
    public static class Goods {
        public List<String> names = new ArrayList<>();
    }
}
