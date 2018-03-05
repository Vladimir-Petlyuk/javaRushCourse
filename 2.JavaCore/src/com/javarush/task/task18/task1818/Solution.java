package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String s1 = buf.readLine();
        String s2 = buf.readLine();
        String s3 = buf.readLine();
        FileInputStream file2 = new FileInputStream(s2);
        FileInputStream file3 = new FileInputStream(s3);
        FileOutputStream file1 = new FileOutputStream(s1);
        byte[] b2 = new byte[file2.available()];
        byte[] b3 = new byte[file3.available()];
        while (file2.available() > 0) {
            file2.read(b2);
            file1.write(b2);
        }
        while (file3.available() > 0) {
            file3.read(b3);
            file1.write(b3);
        }
        buf.close();
        file1.close();
        file2.close();
        file3.close();

    }
}
