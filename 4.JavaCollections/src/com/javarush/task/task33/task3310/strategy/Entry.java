package com.javarush.task.task33.task3310.strategy;

import java.io.Serializable;
import java.util.Objects;

/**
 * Created by Владимир on 02.11.2017.
 */
public class Entry<key, value> implements Serializable {
    final int hash;
    final Long key;
    String value;
    Entry<key, value> next;


    public Entry(int hash, Long key, String value, Entry<key, value> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }

    public Long getKey() {
        return key;
    }


    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Entry)) return false;

        Entry<?, ?> entry = (Entry<?, ?>) o;

        if (getKey() != null ? !getKey().equals(entry.getKey()) : entry.getKey() != null) return false;
        return getValue() != null ? getValue().equals(entry.getValue()) : entry.getValue() == null;
    }

    @Override
    public int hashCode() {
        int result = getKey() != null ? getKey().hashCode() : 0;
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}
