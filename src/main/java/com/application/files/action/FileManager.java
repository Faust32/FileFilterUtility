package com.application.files.action;

import com.application.files.Type;
import com.application.options.OptionsConstants;
import com.application.writer.FileWriterFactory;

import java.io.IOException;

public class FileManager {

    private final FileChecker fileChecker = new FileChecker();
    private final FileRenamer fileRenamer = new FileRenamer();
    private final FileWriterFactory fileWriterFactory = new FileWriterFactory();

    public void run(Type fileType, String contentToWrite) throws IOException {
        String filePrefix = OptionsConstants.getPrefixForFiles();
        String directoryPath = OptionsConstants.getPathForResults();

        if (fileChecker.defaultFileExists(directoryPath, filePrefix, fileType)) {
            handleExistingFile(fileType, contentToWrite, filePrefix);
        } else {
            fileWriterFactory.writeIn(fileType, contentToWrite);
        }
    }

    private void handleExistingFile(Type fileType, String contentToWrite, String filePrefix) throws IOException {
        if (!filePrefix.isEmpty()) {
            fileRenamer.perform(fileType.getFileName(), filePrefix);
        }
        fileWriterFactory.writeIn(fileType, contentToWrite);
    }
}

