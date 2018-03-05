package com.javarush.task.task18.task1803;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map=new HashMap<>();
        while (fileInputStream.available() > 0) {
            int newByte=fileInputStream.read();
            map.put(newByte,map.containsKey(newByte)?map.get(newByte)+1:1);
        }
        int count=0;
        for (Map.Entry<Integer, Integer> pair : map.entrySet())
        {
            Integer value = pair.getValue();
            if (count<value){
                count=value;
            }
        }
        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            if (pair.getValue()==count){
            System.out.print(pair.getKey()+" ");}
        }
        scanner.close();
        fileInputStream.close();
    }
}


