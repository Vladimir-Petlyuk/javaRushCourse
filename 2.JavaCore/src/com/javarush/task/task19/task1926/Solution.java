package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader file = new BufferedReader(new FileReader(fileName));
        while (file.ready()){
            StringBuilder stringBuilder = new StringBuilder();
            String line = file.readLine();
            stringBuilder.append(line).reverse();
            System.out.println(stringBuilder.toString());
        }
        file.close();
    }
}
