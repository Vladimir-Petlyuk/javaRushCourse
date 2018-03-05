package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.Waiter;
import com.javarush.task.task27.task2712.statistic.StatisticManager;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Владимир on 10.10.2017.
 */
public class Restaurant {
    private static final int ORDER_CREATING_INTERVAL = 100;
    private static final LinkedBlockingQueue<Order> orderQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws IOException {
        Locale.setDefault(Locale.ENGLISH);
        Cook cookAmigo = new Cook("Amigo");
        cookAmigo.setQueue(orderQueue);
        Cook cook2 = new Cook("Mamigo");
        cook2.setQueue(orderQueue);

        Waiter waitor = new Waiter();
        cookAmigo.addObserver(waitor);
        cook2.addObserver(waitor);

        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablet.setQueue(orderQueue);
            tablets.add(tablet);
        }



        Thread t = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        t.start();

        Thread amigoThread = new Thread(cookAmigo);
        amigoThread.start();
        Thread makarevichThread = new Thread(cook2);
        makarevichThread.start();
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
        }
        t.interrupt();

        boolean isNotDone = true;
        while (isNotDone)
        {
            if (orderQueue.isEmpty())
            {
                amigoThread.interrupt();
                makarevichThread.interrupt();
                isNotDone = false;
            }
            try
            {
                Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }


        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
