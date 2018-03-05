package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import javax.lang.model.util.Elements;
import javax.swing.text.Document;
import javax.swing.text.Element;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        BufferedReader fileReader = new BufferedReader(new FileReader(s));
        StringBuilder stringBuilder = new StringBuilder();
        while (fileReader.ready()) {
            String s1 = fileReader.readLine();
            stringBuilder.append(s1);
        }
        bufferedReader.close();
        fileReader.close();
        String s1 = stringBuilder.toString();
        Pattern pattern = Pattern.compile("<\\/?" + args[0] + "[^>]*>");
        Matcher match = pattern.matcher(s1);
        ArrayList<Integer> nomber = new ArrayList<>();
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        while (match.find()) {
            int n = match.start();
            int m = match.end();
            if (s1.charAt(n + 1) == '/') {
                String s2 = s1.substring(nomber.get(nomber.size() - 1), n);
                treeMap.put(nomber.get(nomber.size() - 1), s2+"</"+args[0]+">");
                nomber.remove(nomber.size() - 1);
            } else
                nomber.add(n);
        }
        for (String list:treeMap.values()){
            System.out.println(list);
        }
    }
}

//E:\JAVA\file.txt