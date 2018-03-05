package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.kitchen.Cook;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by Владимир on 16.10.2017.
 */
public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage statisticStorage = new StatisticStorage();


    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {

    }

    public void register(EventDataRow data) {
        statisticStorage.put(data);
    }


    public StatisticStorage getStatisticStorage() {
        return statisticStorage;
    }

    private static final int[] TIME_FIELDS =
            {
                    Calendar.HOUR_OF_DAY,
                    Calendar.HOUR,
                    Calendar.AM_PM,
                    Calendar.MINUTE,
                    Calendar.SECOND,
                    Calendar.MILLISECOND

            };

    public TreeMap<Date, Long> getAdvertisementRevenueAgregatedByDay() {
        TreeMap<Date, Long> result = new TreeMap<>();
        for (EventDataRow eventDataRow : statisticStorage.getEvents(EventType.SELECTED_VIDEOS)) {
            VideoSelectedEventDataRow vEventDataRow = (VideoSelectedEventDataRow) eventDataRow;
            GregorianCalendar gDate = new GregorianCalendar();
            gDate.setTime(vEventDataRow.getDate());
            for (int i : TIME_FIELDS)
                gDate.clear(i);
            Date date = gDate.getTime();
            Long dayRevenue = result.get(date);
            if (dayRevenue == null) dayRevenue = 0L;
            result.put(date, dayRevenue + vEventDataRow.getAmount());
        }
        return result;
    }

    public TreeMap<Date, HashMap<String, Integer>> getCookWorkloadingAgregatedByDay() {
        TreeMap<Date, HashMap<String, Integer>> result = new TreeMap<>();
        for (EventDataRow eventDataRow : statisticStorage.getEvents(EventType.COOKED_ORDER)) {
            CookedOrderEventDataRow cookDataRow = (CookedOrderEventDataRow) eventDataRow;
            GregorianCalendar gDate = new GregorianCalendar();
            gDate.setTime(cookDataRow.getDate());
            for (int i : TIME_FIELDS)
                gDate.clear(i);
            Date date = gDate.getTime();
            HashMap<String, Integer> cooksNameWorkDuration = result.computeIfAbsent(date, k -> new HashMap<>());
            String cookName = cookDataRow.getCookName();
            Integer cookWorkDuration = cooksNameWorkDuration.get(cookName);
            if (cookWorkDuration == null) cookWorkDuration = 0;
            cooksNameWorkDuration.put(cookName, cookWorkDuration + cookDataRow.getTime());
        }
        return result;
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> storage = new HashMap<>();

        StatisticStorage() {
            for (EventType eventType : EventType.values()) {
                storage.put(eventType, new ArrayList<>());
            }

        }


        private void put(EventDataRow data) {
            storage.get(data.getType()).add(data);
        }

        public Map<EventType, List<EventDataRow>> getStorage() {
            return storage;
        }

        private List<EventDataRow> getEvents(EventType eventType) {
            return storage.get(eventType);
        }
    }

}
