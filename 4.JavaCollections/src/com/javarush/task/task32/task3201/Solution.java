package com.javarush.task.task32.task3201;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/
public class Solution {
    public static void main(String... args) throws IOException {
        String filename = args[0];
        int number = Integer.parseInt(args[1]);
        String text = args[2];
        RandomAccessFile file = new RandomAccessFile(filename,"rw");
        if(number>file.length())
            file.seek(file.length());
        else file.seek(number);
        file.write(text.getBytes());
        file.close();

    }
}
