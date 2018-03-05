package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String str = buf.readLine();
        FileInputStream file = new FileInputStream(str);
        Scanner scanner = new Scanner(file);
        String s= args[0];
        int a=s.length();
        while (scanner.hasNext()){
            String s1 = scanner.nextLine();
            if (s1.startsWith(s)){
                System.out.println(s1);
            }
        }
        scanner.close();
        file.close();
        buf.close();

    }
}
