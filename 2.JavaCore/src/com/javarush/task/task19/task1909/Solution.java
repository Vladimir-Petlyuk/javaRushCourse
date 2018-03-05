package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consol = new BufferedReader(new InputStreamReader(System.in));
        String filereader = consol.readLine();
        String filewriter = consol.readLine();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filereader));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filewriter));
        while (bufferedReader.ready()){
            String line = bufferedReader.readLine().replace(".","!");
            bufferedWriter.write(line);
        }
        consol.close();
        bufferedReader.close();
        bufferedWriter.close();
    }
}
