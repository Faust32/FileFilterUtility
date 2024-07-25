package com.application.options.handlers;

import com.application.options.OptionsConstants;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ResultPathOptionHandler implements OptionHandler {
    private final PathValidityChecker pathValidityChecker = new PathValidityChecker();

    @Override
    public void handle(String[] args, int index) {
        if (index + 1 < args.length && pathValidityChecker.isPathValid(args[index + 1])) {
            Path directoryPath = Paths.get(args[index + 1]);
            String normalizedPath = directoryPath.toAbsolutePath().normalize().toString();
            String directoryPathWithSeparator = normalizedPath.endsWith(File.separator) ? normalizedPath : normalizedPath + File.separator;
            OptionsConstants.setPathForResults(directoryPathWithSeparator);
            OptionsConstants.setIsResultPathExists(true);
        } else {
            System.out.println("Invalid path: " + args[index + 1]);
        }
    }
}
