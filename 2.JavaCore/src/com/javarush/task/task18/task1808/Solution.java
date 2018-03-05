package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String s1 =scanner.nextLine();
        String s2 = scanner.nextLine();
        String s3 = scanner.nextLine();
        FileInputStream file1 = new FileInputStream(s1);
        FileOutputStream file2 = new FileOutputStream(s2);
        FileOutputStream file3 = new FileOutputStream(s3);
        byte[] b1;
        byte[] b2;
        if (file1.available()%2!=0){
            b1=new byte[file1.available()/2+1];
            b2 = new byte[file1.available()/2];
        }else {
            b1=new byte[file1.available()/2];
            b2 = new byte[file1.available()/2];
        }
        while (file1.available()>0){
            file1.read(b1);
            file2.write(b1);
            file1.read(b2);
            file3.write(b2);
        }
        scanner.close();
        file1.close();
        file2.close();
        file3.close();



    }
}
