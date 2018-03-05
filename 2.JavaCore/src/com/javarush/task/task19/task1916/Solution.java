package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = bufferedReader.readLine();
        String fileName2 = bufferedReader.readLine();
        bufferedReader.close();
        BufferedReader file1 = new BufferedReader(new FileReader(fileName1));
        BufferedReader file2 = new BufferedReader(new FileReader(fileName2));
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        while (file1.ready()) {
            String s = file1.readLine();
            list1.add(s);
        }
        while (file2.ready()) {
            String s = file2.readLine();
            list2.add(s);
        }
        file1.close();
        file2.close();
        for (int i = 0; i < list1.size()||list2.size()>0; i++) {
            if (list2.size()==0){
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
            }else if(i>=list1.size()){
                lines.add(new LineItem(Type.ADDED, list2.get(0)));
                list2.remove(0);
            }
            else if (list1.get(i).equals(list2.get(0))) {
                lines.add(new LineItem(Type.SAME, list1.get(i)));
                list2.remove(0);
            } else if (list1.get(i).equals(list2.get(1))) {
                lines.add(new LineItem(Type.ADDED, list2.get(0)));
                list2.remove(0);
                i+=-1;
            } else {
                lines.add(new LineItem(Type.REMOVED, list1.get(i)));
            }
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }
    public static class LineItem {
        public Type type;
        public String line;
        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
