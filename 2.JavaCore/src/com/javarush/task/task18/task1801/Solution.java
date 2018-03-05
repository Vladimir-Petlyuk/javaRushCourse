package com.javarush.task.task18.task1801;

import java.io.FileInputStream;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        FileInputStream fileInputStream = new FileInputStream(scanner.nextLine());
        int max=fileInputStream.read();
        while (fileInputStream.available()>0){
            int a=fileInputStream.read();
            if (a>max){
                max=a;
            }
        }
        System.out.println(max);
        scanner.close();
        fileInputStream.close();
    }
}
