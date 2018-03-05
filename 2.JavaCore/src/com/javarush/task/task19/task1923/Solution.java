package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(args[1]));
        while (bufferedReader.ready()){
            String line =bufferedReader.readLine();
            String[] arr = line.split(" ");
            Pattern pattern = Pattern.compile(".+[0-9].+");
            for(String page: arr){
                Matcher match = pattern.matcher(page);
                if(match.matches()){
                    bufferedWriter.write(page+" ");
                }
            }
        }
        bufferedReader.close();
        bufferedWriter.close();

    }
}
