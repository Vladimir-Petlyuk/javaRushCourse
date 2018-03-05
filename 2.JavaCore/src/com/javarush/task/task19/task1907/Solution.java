package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String file = bufferedReader.readLine();
        BufferedReader scanner =new BufferedReader(new FileReader(file));
        bufferedReader.close();
        int count=0;
        while (scanner.ready()){
            String[] s = scanner.readLine().replaceAll("\\pP", " ").split(" ");
            for( String page: s){
                if (page.equals("world")){
                    count++;
                }
            }
        }
        scanner.close();
        System.out.println(count);
    }
}
