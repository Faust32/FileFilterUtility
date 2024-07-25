package com.application.files.action;

import com.application.files.Type;

import java.io.File;
import java.nio.file.Paths;

public class FileChecker {

    public boolean isFileValid(String fileName) {
        if (fileName.contains(".txt") && !isFileEmpty(fileName)) {
            return true;
        }
        return false;
    }

    private boolean isFileEmpty(String filePath) {
        File file = new File(filePath);
        if (file.exists() && file.isFile()) {
            if (file.length() == 0) {
                System.out.println("Please note that this file is empty: " + filePath);
                return true;
            }
        }
        return false;
    }


    public boolean defaultFileExists(String packagePath, String prefix, Type fileType) {
        if (packagePath == null || packagePath.isEmpty()) {
            packagePath = Paths.get(".").toAbsolutePath().normalize().toString();
        }
        File directory = new File(packagePath);
        if (directory.exists() && directory.isDirectory()) {
            String fileName = getDefaultFileName(prefix, fileType);
            File[] files = listFilesInDirectory(directory);
            for (File file : files) {
                if (file.getName().equals(fileName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public String getDefaultFileName(String prefix, Type fileType) {
        return prefix + fileType.getFileName();
    }


    public File[] listFilesInDirectory(File directory) {
        if (directory.exists() && directory.isDirectory()) {
            return directory.listFiles();
        }
        return new File[0];
    }

}
