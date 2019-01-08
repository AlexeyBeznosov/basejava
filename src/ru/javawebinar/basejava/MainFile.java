package ru.javawebinar.basejava;

import java.io.File;

public class MainFile {

    public static void main(String[] args) {
        File file = new File("C:\\project\\basejava\\src");
        getChildFile(file);
    }

    private static void getChildFile(File file) {
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File file1 : files) {
                System.out.println(file1);
                if (file1.isDirectory()) {
                    getChildFile(file1);
                }
            }
        }
    }
}
