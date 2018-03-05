package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        InputStream is = new BufferedInputStream(new FileInputStream(bufferedReader.readLine()));
        Scanner scanner = new Scanner(is);
        ArrayList<Integer> list = new ArrayList<>();


        while (scanner.hasNext()) {
            int b = scanner.nextInt();
            if (b % 2 == 0) {
                list.add(b);
            }
        }
        scanner.close();
        is.close();
        list = bublleSorted(list);
        for (Integer i:list){
            System.out.println(i);
        }

    }
    public static ArrayList<Integer> bublleSorted(ArrayList<Integer> a) {

        for (int j = a.size() - 1; j >= 0; j--) {
            for (int i = 0; i < j; i++) {
                if (a.get(i) > a.get(i + 1)) {
                    int p = a.get(i);
                    a.set(i, a.get(i + 1));
                    a.set(i + 1, p);
                }

            }
        }
        return a;
    }
}
//E://JAVA/MyProject1/src/ua/dp/SkillsUp/HelloWord/GameOfLife/Game_of_life1.txt