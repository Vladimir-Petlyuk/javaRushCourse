package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("-e")){
            FileInputStream fileInputStream = new FileInputStream(args[1]);
            FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
            while (fileInputStream.available()>0){
                int shifr = fileInputStream.read()+1;
                fileOutputStream.write(shifr);
            }
            fileInputStream.close();
            fileOutputStream.close();
        }else
        if(args[0].equals("-d")){
            FileInputStream fileInputStream = new FileInputStream(args[1]);
            FileOutputStream fileOutputStream = new FileOutputStream(args[2]);
            while (fileInputStream.available()>0){
                int shifr = fileInputStream.read()-1;
                fileOutputStream.write(shifr);
            }
            fileInputStream.close();
            fileOutputStream.close();
        }

    }

}
