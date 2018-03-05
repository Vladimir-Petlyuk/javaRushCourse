package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        TreeMap<Character,Integer> map = new TreeMap<>();
        while (file.available()>0){
            Character b= (char) file.read();
            map.put(b,map.containsKey(b)?map.get(b)+1:1);
        }
        for (Map.Entry<Character, Integer> pair : map.entrySet())
        {
            Character key = pair.getKey();                      //ключ
            Integer value = pair.getValue();                  //значение
            System.out.println(key + " " + value);
        }
        file.close();

    }
}
