package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()) {
            stringBuilder.append(fileReader.readLine());
        }
        fileReader.close();        //...
        StringBuilder result = getLine(stringBuilder.toString().trim());
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        StringBuilder stringBuilder = new StringBuilder();
        if (words != null) {
            ArrayList<String> list = new ArrayList<>();
            String[] s = Arrays.toString(words).replace("[", "").replace("]", "").split(" ");
            Arrays.sort(s);
            Collections.addAll(list, s);
            stringBuilder.append(list.get(0));
            list.remove(0);
            for (int i = 0; i < list.size(); i++) {
                char charFirst = stringBuilder.toString().charAt(0);
                char charLast = stringBuilder.toString().charAt(stringBuilder.toString().length() - 1);
                char char1First = list.get(i).charAt(0);
                char char1Last = list.get(i).charAt(list.get(i).length() - 1);
                if (String.valueOf(charLast).equalsIgnoreCase(String.valueOf(char1First))) {
                    stringBuilder.append(" ").append(list.get(i));
                    list.remove(i);
                    i=-1;
                }
            }
            for(String line:list){
                stringBuilder.append(" ").append(line);
            }
        }
        return stringBuilder;
    }
}
