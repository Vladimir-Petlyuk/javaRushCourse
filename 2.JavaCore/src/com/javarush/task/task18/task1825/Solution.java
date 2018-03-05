package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader consol = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, String> map = new TreeMap<>();
        String fileName = new String();
        while (true) {
            String s = consol.readLine();
            if (s.equals("end")) {
                break;
            } else {
                int nomber = Integer.parseInt(s.split("part")[1].trim());
                map.put(nomber, s);
                fileName = s.split(".part")[0];
            }
        }
        consol.close();
        File file = new File(fileName);
        FileOutputStream file1 = new FileOutputStream(file);
        for (Map.Entry<Integer, String> pair : map.entrySet()){
            FileInputStream fileInputStream = new FileInputStream(pair.getValue());
            byte[] buf = new byte[fileInputStream.available()];
            while (fileInputStream.available()>0){
                fileInputStream.read(buf);
                file1.write(buf);
            }
            fileInputStream.close();
        }
        file1.close();

    }
}
