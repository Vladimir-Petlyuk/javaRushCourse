package com.javarush.task.task33.task3310;

import com.javarush.task.task33.task3310.strategy.StorageStrategy;

/**
 * Created by Владимир on 02.11.2017.
 */
public class Shortener {
    //Это поле будет отвечать за последнее значение идентификатора, которое было использовано при добавлении новой строки в хранилище
    private Long lastId = 0L;
    //тут будет храниться стратегия хранения данных
    private StorageStrategy storageStrategy;


    //constructor
    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }


    //methods

    //будет возвращать идентификатор id для заданной строки
    public synchronized Long getId(String string){

        //Проверить есть ли переданное значение в хранилище,
        if (storageStrategy.containsValue(string)) {
            // если есть – вернуть его ключ
            return storageStrategy.getKey(string);
        }
        //Если преданного значения нет в хранилище, то:
        else {
            //Увеличить значение lastId
            lastId++;
            //Добавить в хранилище новую пару ключ-значение (новое значение lastId и переданную строку)
            storageStrategy.put(lastId, string);
            //Вернуть новое значение lastId
            return lastId;
        }
    }

    //будет возвращать строку для заданного идентификатора или null, если передан неверный идентификатор
    public synchronized String getString(Long id) {
        return storageStrategy.getValue(id);
    }
}
