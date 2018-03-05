package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        int count =0;
        while (file.available()>0){
            int data =file.read();
            if ((data > 64) && (data < 91) || (data > 96) && (data < 123)){
                count++;
            }
        }
        System.out.println(count);
        file.close();
    }

}
