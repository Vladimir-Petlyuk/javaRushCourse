package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bufferedReader.readLine();
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        if (args[0].equals("-u")) {
            ArrayList<String> list = new ArrayList<>();
            while (reader.ready()) {
                String s = reader.readLine();
                if (!s.equals("")) {
                    list.add(s);
                }
            }
            reader.close();
            bufferedReader.close();
            int index = 0;
            String newstr = new String();
            for (int i = 0; i < list.size(); i++) {
                if (args[1].equals(list.get(i).substring(0, 8).replaceAll(" ", ""))) {
                    index = i;
                    newstr = list.get(i);
                }
            }
            int id = Integer.parseInt(newstr.substring(0, 8).replace(" ", ""));
            StringBuilder productNameDemo = new StringBuilder();
            for (int i = 2; i < args.length - 2; i++) {
                productNameDemo.append(args[i]);
                productNameDemo.append(" ");
            }
            String productName = productNameDemo.toString().trim();
            String price = args[args.length - 2];
            String quantity = args[args.length - 1];
            list.remove(index);

            list.add(index, String.format("%-8d%-30.30s%-8s%-4s", id, productName, price, quantity));
            FileWriter fileWriter = new FileWriter(fileName);
            for (String str : list) {
                fileWriter.write(str + "\r\n");
            }
            fileWriter.close();
        } else if (args[0].equals("-d")) {
            ArrayList<String> list = new ArrayList<>();
            while (reader.ready()) {
                String s = reader.readLine();
                if (!s.equals("")) {
                    list.add(s);
                }
            }
            reader.close();
            bufferedReader.close();
            int index = 0;
            for (int i = 0; i < list.size(); i++) {
                if (args[1].equals(list.get(i).substring(0, 8).replaceAll(" ", ""))) {
                    index = i;
                }
            }
            list.remove(index);
            FileWriter fileWriter = new FileWriter(fileName);
            for (String str : list) {
                fileWriter.write(str + "\r\n");
            }
            fileWriter.close();
        }

    }
}
//-u 25 NN vvv vvvv dddd 56.32 85
//E:\JAVA\file2.txt