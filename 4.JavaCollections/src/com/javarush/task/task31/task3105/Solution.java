package com.javarush.task.task31.task3105;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        Map<ZipEntry, ByteArrayOutputStream> archivedFiles = new HashMap<>();
        try (ZipInputStream zipReader = new ZipInputStream(new FileInputStream(args[1]))) {
            ZipEntry entry;
            while ((entry = zipReader.getNextEntry()) != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = zipReader.read(buffer)) != -1)
                    byteArrayOutputStream.write(buffer, 0, count);

                archivedFiles.put(entry, byteArrayOutputStream);
            }
        }

        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(args[1]));

        Files.copy(Paths.get(args[0]), zipOut);

        for (Map.Entry<ZipEntry, ByteArrayOutputStream> zipEntry : archivedFiles.entrySet()) {
            zipOut.putNextEntry(zipEntry.getKey());
            zipOut.write(zipEntry.getValue().toByteArray());
            zipOut.closeEntry();
        }
        zipOut.close();
    }
}
