package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        int count =0;
        int count1 =file.available();
        while (file.available()>0){
            char c = (char) file.read();
            if (c==' '){
                count++;
            }
        }
        double d=(double)count/count1*100;
        String pattern = "##0.00";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        String format = decimalFormat.format(d);
        System.out.println(format);
        file.close();

    }
}
