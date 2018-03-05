package com.javarush.task.task18.task1804;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Самые редкие байты
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
        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            if (pair.getValue()==1){
                System.out.print(pair.getKey()+" ");}
        }
        scanner.close();
        fileInputStream.close();
    }
}
