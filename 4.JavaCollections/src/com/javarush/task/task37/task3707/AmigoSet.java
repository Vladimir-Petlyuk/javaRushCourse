package com.javarush.task.task37.task3707;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Владимир on 29.10.2017.
 */
public class AmigoSet<T> extends AbstractSet<T> implements Serializable, Cloneable, Set<T> {
    private static final Object PRESENT = new Object();
    private transient HashMap<T, Object> map;


    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(int capacity) {
        map = new HashMap<>(capacity);
    }


    public AmigoSet(Collection<? extends T> c) {
        map = new HashMap<>(Math.max((int) (c.size() / .75f) + 1, 16));
        addAll(c);
    }

    @Override
    public Object clone() throws CloneNotSupportedException
    {
        AmigoSet<T> amigoSet = new AmigoSet<>();

        try {
            amigoSet.addAll(this);
            amigoSet.map.putAll((Map) this.map.clone());
        }
        catch (Exception e){
            throw new InternalError();
        }

        return amigoSet;
    }

    @Override
    public Iterator<T> iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean add(T t) {
        return map.put(t, PRESENT) == null;
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.keySet().contains(o);
    }

    @Override
    public boolean remove(Object o) {
        return map.keySet().remove(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    private void writeObject(ObjectOutputStream s) throws IOException
    {
        s.defaultWriteObject();

//        s.writeObject(map.size());
//        for(T e:map.keySet()){
//            s.writeObject(e);
//        }
//        s.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"capacity"));
//        s.writeObject(HashMapReflectionHelper.callHiddenMethod(map,"loadFactor"));
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {

        s.defaultReadObject();

//        int size = (int)s.readObject();
//        Set<T> set = new HashSet<>();
//        for(int i =0;i<size;i++){
//            set.add((T)s.readObject());
//        }
//        int capacity = (int)s.readObject();
//        float loadFactor = (float)s.readObject();
//        map = new HashMap<>(capacity,loadFactor);
//        for(T e:set){
//            map.put(e,PRESENT);
//        }
    }
}
