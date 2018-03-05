package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
*/

import java.io.*;
import java.util.Arrays;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(File file) throws IOException {
        fileWriter = new FileWriter(file);
    }
    public FileConsoleWriter(File file, boolean append) throws IOException {
        fileWriter = new FileWriter(file,append);
    }
    public FileConsoleWriter(FileDescriptor fd) throws IOException {
        fileWriter = new FileWriter(fd);
    }
    public FileConsoleWriter(String fileName) throws IOException {
        fileWriter = new FileWriter(fileName);
    }
    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        fileWriter = new FileWriter(fileName,append);
    }

    public void write(int c) throws IOException {
        fileWriter.write(c);
        System.out.println(c);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        fileWriter.write(cbuf, off, len);
        StringBuilder stringBuilder = new StringBuilder();
        for (char aCbuf : cbuf) {
            stringBuilder.append(aCbuf);
        }
        String s = stringBuilder.toString().substring(off).substring(0,len);
        char[] chars = s.toCharArray();

        System.out.println(chars);
    }

    public void write(String str, int off, int len) throws IOException {
        fileWriter.write(str, off, len);
        String s =str.substring(off).substring(0,len);
        System.out.println(s);
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public void write(char[] cbuf) throws IOException {
        fileWriter.write(cbuf);
        System.out.println(cbuf);
    }

    public void write(String str) throws IOException {
        fileWriter.write(str);
        System.out.println(str);
    }

    public static void main(String[] args) {

    }

}
