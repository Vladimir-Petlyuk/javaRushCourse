package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String s1 = buf.readLine();
        String s2 = buf.readLine();
        FileInputStream file2 = new FileInputStream(s2);
        FileOutputStream file1 = new FileOutputStream(s1);
        FileInputStream file11 = new FileInputStream(s1);
        byte[] b2 = new byte[file2.available()];
        byte[] b1 = new byte[file11.available()];

        while (file2.available()>0){
            file2.read(b2);
        }
        while (file11.available()>0){
            file11.read(b1);
        }
        file1.write(b2);
        file1.write(b1);
        buf.close();
        file1.close();
        file2.close();
        file11.close();


    }
}
