package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s= scanner.nextLine();
        String s1= s.substring(s.indexOf("?")+1);

        String [] str = s1.split("&");

        String [] str1 = new String[str.length];
        ArrayList<String> list = new ArrayList<>();
        for (int i=0; i<str.length;i++){
            if (str[i].contains("=")){
                str1[i]=str[i].substring(0,str[i].indexOf("="));
                if (str[i].contains("obj"))
                list.add(str[i].split("=")[1]);

            }else {
                str1[i] = str[i];
            }
            System.out.print(str1[i]+" ");
        }
        System.out.println();
        for (String o:list){
                try {
                    Double d = Double.parseDouble( o);
                    alert(d);
                } catch (Exception e) {
                    alert( o);
                }
            }
        }



    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
