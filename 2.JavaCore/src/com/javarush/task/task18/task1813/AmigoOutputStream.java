package com.javarush.task.task18.task1813;

import java.io.*;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream file;

    public AmigoOutputStream( FileOutputStream file) throws FileNotFoundException {
        super(fileName);
        this.file=file;
    }

    @Override
    public void write(int b) throws IOException {
        file.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        file.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        file.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        flush();
        String s="JavaRush © All rights reserved.";
        file.write(s.getBytes());
        file.close();
    }

    @Override
    public FileChannel getChannel() {
        return file.getChannel();
    }



    @Override
    public void flush() throws IOException {
        file.flush();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
