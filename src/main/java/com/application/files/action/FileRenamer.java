package com.application.files.action;

import java.io.File;
public class FileRenamer {
    public void perform(String oldFileName, String prefix) {
        File file = new File(oldFileName);
        String newFileName = prefix + oldFileName;
        File newFile = new File(newFileName);
        file.renameTo(newFile);
    }

}
