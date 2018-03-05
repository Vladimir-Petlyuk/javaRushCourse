package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        TreeMap<String, Double> treeMap = new TreeMap<>();
        while (bufferedReader.ready()){
            String s= bufferedReader.readLine();
            String s1 = s.split(" ")[0];
            double d = Double.parseDouble(s.split(" ")[1]);
            treeMap.put(s1,treeMap.containsKey(s1)?treeMap.get(s1)+d:d);
        }
        bufferedReader.close();
        double i=0;
        for (Map.Entry<String,Double> pair:treeMap.entrySet()){
            if(pair.getValue()>i){
                i=pair.getValue();
            }
        }
        for (Map.Entry<String,Double> pair:treeMap.entrySet()){
            if(pair.getValue()==i){
                System.out.println(pair.getKey());
            }
        }
    }
}
