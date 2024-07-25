package com.application.writer;

import com.application.files.Type;
import com.application.options.OptionsConstants;

import java.io.IOException;


public class FileWriterFactory {

    public void writeIn(Type type, String contentToWrite) throws IOException {
        String directoryPath = OptionsConstants.getPathForResults();
        String filePrefix = OptionsConstants.getPrefixForFiles();
        String filePath = directoryPath + filePrefix + type.getFileName();

        switch (type) {
            case INTEGERS:
                IntegerTypeWriter integerTypeWriter = new IntegerTypeWriter(filePath);
                integerTypeWriter.write(contentToWrite);
                break;
            case STRINGS:
                StringTypeWriter stringTypeWriter = new StringTypeWriter(filePath);
                stringTypeWriter.write(contentToWrite);
                break;
            case FLOATS:
                FloatsTypeWriter floatsTypeWriter = new FloatsTypeWriter(filePath);
                floatsTypeWriter.write(contentToWrite);
                break;
        }
    }

}
