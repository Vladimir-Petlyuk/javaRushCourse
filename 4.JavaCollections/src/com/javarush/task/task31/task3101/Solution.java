package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/*
Проход по дереву файлов
*/
public class Solution {
    private static List<File> files = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File resultFileAbsolutePath = new File(args[1]);
        File newFile = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        FileUtils.renameFile(resultFileAbsolutePath, newFile);

        FileOutputStream fileOutputStream = new FileOutputStream(newFile);

        Comparator<File> comparator = Comparator.comparing(File::getName);
        allFiles(new File(args[0]));
        files.sort(comparator);
        for (File file : files) {
            FileInputStream fileInputStream = new FileInputStream(file);
            while (fileInputStream.available() != 0) {
                fileOutputStream.write(fileInputStream.read());
            }
            fileOutputStream.write("\n".getBytes());
            fileInputStream.close();
        }
        fileOutputStream.close();
    }

    private static void allFiles(File file) {
        if (file.isFile()) {
            if (file.length() > 50)
                FileUtils.deleteFile(file);
            else files.add(file);
        } else {
            CopyOnWriteArrayList<File> copyFiles = new CopyOnWriteArrayList<>();
            copyFiles.addAllAbsent(Arrays.asList(file.listFiles()));
            for (File file1 : copyFiles) {
                if (file1.isDirectory())
                    allFiles(file1);
                else {
                    if (file1.length() > 50)
                        FileUtils.deleteFile(file1);
                    else files.add(file1);

                }
            }
        }
    }
}
