package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
        int count=0;
        char c= ',';
        int i=(int) c;
        while (fileInputStream.available()>0){
            int symbl= fileInputStream.read();
            if(i==symbl){
                count++;
            }
        }
        System.out.println(count);
        scanner.close();
        fileInputStream.close();
    }
}
