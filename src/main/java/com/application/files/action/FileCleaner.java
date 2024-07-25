package com.application.files.action;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileCleaner {

    public void perform(File file) throws IOException {
        new FileWriter(file, false).close();
    }

}
