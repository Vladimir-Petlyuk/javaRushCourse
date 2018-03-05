package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.text.ParseException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consol = new BufferedReader(new InputStreamReader(System.in));
        String filrR = consol.readLine();
        String fileW = consol.readLine();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filrR));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileW));
        consol.close();
        while (bufferedReader.ready()) {
            String[] s = bufferedReader.readLine().split(" ");
            for (String page : s) {
                try {
                    int a = Integer.parseInt(page);
                    bufferedWriter.write(a+" ");
                } catch (NumberFormatException e) {
                    continue;
                }
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
