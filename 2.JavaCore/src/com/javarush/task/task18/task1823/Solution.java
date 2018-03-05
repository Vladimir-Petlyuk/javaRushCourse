package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String s = buf.readLine();
            if (s.equals("exit")){
                break;
            }else new ReadThread(s).start();
        }
        buf.close();

    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            this.fileName=fileName;
        }
        @Override
        public void run() {
            try {
                FileInputStream file = new FileInputStream(fileName);
                 int  countmax = 0;
                 int max=0;
                 HashMap<Integer, Integer>map= new HashMap<>();
                 while (file.available()>0){
                     int in = file.read();
                     map.put(in,map.containsKey(in)? map.get(in)+1:1);
                 }
                 file.close();
                for (Map.Entry<Integer, Integer> pair : map.entrySet())
                {
                    Integer value = pair.getValue();
                    if (value>countmax){
                        countmax=value;
                        max=pair.getKey();
                    }
                }
                resultMap.put(fileName,max);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
