package com.application.writer;


import java.io.BufferedWriter;
import java.io.IOException;

public abstract class FileWriter {
    protected String filePath;

    protected void writeToFile(String contentToWrite, String filePath) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(filePath, true));
        bufferedWriter.write(contentToWrite);
        bufferedWriter.newLine();
        bufferedWriter.close();
    }

    public abstract void write(String pathToFile) throws IOException;
}
