package com.javarush.task.task33.task3310.strategy;

import com.javarush.task.task33.task3310.ExceptionHandler;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Created by Владимир on 02.11.2017.
 */
public class FileBucket {
    private Path path;

    public FileBucket() {
        try {
            path = Files.createTempFile(null, null);
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
        path.toFile().deleteOnExit();
    }

    public long getFileSize() {
        long l = 0l;
        try {
            l = Files.size(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return l;
    }

    public void putEntry(Entry entry) {
        try {
            OutputStream fos = Files.newOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(entry);
            oos.flush();
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }

    }

    public Entry getEntry() {
        Entry result = null;
        if (getFileSize() <= 0) return null;

        try {
            InputStream fis = Files.newInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            result = (Entry) ois.readObject();
        } catch (IOException e) {
            ExceptionHandler.log(e);
        } catch (ClassNotFoundException e) {
            ExceptionHandler.log(e);
        }
        return result;
    }

    public void remove() {
        try {
            Files.delete(path);
        } catch (IOException e) {
            ExceptionHandler.log(e);
        }
    }
}
