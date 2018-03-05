package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine();
        String s2=reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(s1);
        FileOutputStream fileOutputStream = new FileOutputStream(s2);
        byte[] bytes = new byte[fileInputStream.available()];
        for (int i=fileInputStream.read(bytes)-1;i>=0;i--){
            fileOutputStream.write(bytes[i]);
        }
        reader.close();
        fileInputStream.close();
        fileOutputStream.close();

    }
}
