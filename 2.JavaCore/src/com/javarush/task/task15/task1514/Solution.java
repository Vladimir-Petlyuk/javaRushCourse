package com.javarush.task.task15.task1514;

import java.util.HashMap;
import java.util.Map;

/* 
Статики 1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.0,"jhbjb");
        labels.put(45.6,"fsdaf");
        labels.put(78.1,"asdasd");
        labels.put(8d,null);
        labels.put(785d,"1111111");
    }



    public static void main(String[] args) {
        System.out.println(labels);
    }
}
