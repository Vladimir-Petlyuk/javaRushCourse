    package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

    public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    static {
        Scanner scanner = new Scanner(System.in);
        firstFileName =scanner.nextLine();
        secondFileName = scanner.nextLine();
        scanner.close();
    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        StringBuilder list = new StringBuilder();
        String s;

        @Override
        public void setFileName(String fullFileName) {
            s=fullFileName;
        }

        @Override
        public String getFileContent() {
            return String.valueOf(list);
        }

        @Override
        public void run() {
            try {
                FileReader fileReader=new FileReader(s);
                Scanner scanner =new Scanner(fileReader);
                while (scanner.hasNext()){
                list.append(scanner.nextLine()).append(" ");}
                scanner.close();
                fileReader.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
