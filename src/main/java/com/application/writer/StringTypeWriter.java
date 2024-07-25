package com.application.writer;

import java.io.IOException;

public class StringTypeWriter extends FileWriter {

    public StringTypeWriter(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(String line) throws IOException {
        writeToFile(line, filePath);
    }
}
