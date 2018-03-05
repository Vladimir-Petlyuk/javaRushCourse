package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String s1 = buf.readLine();
        String s2 = buf.readLine();
        FileInputStream file1 = new FileInputStream(s1);
        Scanner scanner = new Scanner(file1);
        FileOutputStream file2 = new FileOutputStream(s2);
        ArrayList<Integer> list = new ArrayList<>();
        while (scanner.hasNextDouble()) {
            int a = (int) Math.round(scanner.nextDouble());
            list.add(a);
        }
        for (Integer in: list ) {
                file2.write(Integer.toString(in).getBytes());
                file2.write(' ');
            }
        buf.close();
        scanner.close();
        file1.close();
        file2.close();
    }
}
