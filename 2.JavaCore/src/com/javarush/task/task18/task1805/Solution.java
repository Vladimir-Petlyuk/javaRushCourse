package com.javarush.task.task18.task1805;

import java.io.FileInputStream;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
        ArrayList<Integer> list = new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        while (fileInputStream.available() > 0) {
            int newByte=fileInputStream.read();
            set.add(newByte);
        }
        for (Integer pair : set)
        {
           list.add(pair);
        }
        for (int j = list.size() - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (list.get(i) > list.get(i+1)) {
                    int p = list.get(i);
                    list.set(i, list.get(i+1));
                    list.set(i+1, p);
                }
            }
        }
        for (Integer in:list){
            System.out.print(in+" ");
        }


        scanner.close();
        fileInputStream.close();
    }
}
