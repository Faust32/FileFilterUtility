package com.application.scanner;

import com.application.files.action.FileManager;
import com.application.files.Type;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileScanner {
    private final FileManager fileManager = new FileManager();
    public void scan(String path) {
        try {
            File file = new File(path);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (isInteger(line)) {
                    fileManager.run(Type.INTEGERS, line);
                } else if (isFloat(line)) {
                    fileManager.run(Type.FLOATS, line);
                } else {
                    fileManager.run(Type.STRINGS, line);
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("File not found: " + path);
        }
    }

    private boolean isInteger(String line) {
        return line.matches("-?\\d+");
    }

    private boolean isFloat(String line) {
        return line.matches("-?\\d+\\.\\d+([eE][+-]?\\d+)?");
    }
 }
