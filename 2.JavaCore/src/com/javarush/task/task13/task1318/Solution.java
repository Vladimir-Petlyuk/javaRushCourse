package com.javarush.task.task13.task1318;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.FileInputStream;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args)  throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
         FileInputStream file = new FileInputStream(bufferedReader.readLine());
         while (file.available()>0){
             System.out.print((char)file.read());
         }
        System.out.println();
         bufferedReader.close();
         file.close();

    }
}