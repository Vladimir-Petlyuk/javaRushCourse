package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader file  = new BufferedReader(new FileReader(fileName));
        while (file.ready()){
            String line = file.readLine();
            String[] s = line.split(" ");
            int count = 0;
            for (int i = 0; i<s.length;i++){
                for (String list:words){
                    if(s[i].equals(list)){
                        count++;
                    }
                }
            }
            if (count ==2){
                System.out.println(line);
            }
        }

        file.close();

    }
}
