package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.regex.Matcher;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            String[] arr = line.split(" ");
            for (String page : arr) {
                if (page.length() > 6) {
                    stringBuilder.append(page).append(",");
                }
            }
        }
        bufferedReader.close();
        String line  = stringBuilder.substring(0,stringBuilder.length()-1);
        bufferedWriter.write(line);
        bufferedWriter.close();
    }
}
