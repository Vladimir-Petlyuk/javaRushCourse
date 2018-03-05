package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) throws IOException {
        String filename = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        RandomAccessFile file = new RandomAccessFile(filename, "rw");
        byte[] bytes = new byte[text.length()];
        file.seek(number);
        file.read(bytes,0,text.length());
        String bool=new String(bytes).equals(text)?"true":"false";
        file.seek(file.length());
        file.write(bool.getBytes());
        file.close();
    }
}
