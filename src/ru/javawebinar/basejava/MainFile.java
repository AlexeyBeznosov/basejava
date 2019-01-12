package ru.javawebinar.basejava;

import java.io.File;

public class MainFile {

    public static void main(String[] args) {
        File file = new File(".\\src");
        displayFiles(file);
    }

    private static void displayFiles(File file) {
        File[] files = file.listFiles();
        if (files != null) {
            for (File file1 : files) {
                System.out.println(file1.getName());
                if (file1.isDirectory()) {
                    displayFiles(file1);
                }
            }
        }
    }
}
