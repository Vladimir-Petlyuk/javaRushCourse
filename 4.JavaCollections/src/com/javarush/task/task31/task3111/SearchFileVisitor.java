package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {

    private String partOfName;
    private String partOfContent;
    private int minSize=-1;
    private int maxSize=-1;
    private List<Path> foundFiles= new ArrayList<>();



    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean isFitWithFilter = true;

        if(partOfName!=null&&isFitWithFilter){
            isFitWithFilter = file.getFileName().toString().contains(partOfName);
        }
        if(partOfContent!=null&&isFitWithFilter){
            isFitWithFilter = Files.readAllLines(file).toString().contains(partOfContent);
        }
        if(minSize>=0&&isFitWithFilter){
            isFitWithFilter = attrs.size()>minSize;
        }
        if(maxSize>=0&&isFitWithFilter){
            isFitWithFilter = attrs.size()<maxSize;
        }

        if(isFitWithFilter) foundFiles.add(file);

        return FileVisitResult.CONTINUE;
    }

    public String getPartOfName() {
        return partOfName;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public int getMinSize() {
        return minSize;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setFoundFiles(List<Path> foundFiles) {
        this.foundFiles = foundFiles;
    }
}
