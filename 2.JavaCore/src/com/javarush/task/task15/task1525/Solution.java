package com.javarush.task.task15.task1525;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Файл в статическом блоке
*/

public class Solution  {
    public static List<String> lines = new ArrayList<String>();

    static {
        FileReader file = null;
        try {
            file = new FileReader(Statics.FILE_NAME);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Scanner scanner = new Scanner(file);
        while (scanner.hasNext()){
            lines.add(scanner.nextLine());
        }
    }


    public static void main(String[] args) {
        System.out.println(lines);
    }
}
