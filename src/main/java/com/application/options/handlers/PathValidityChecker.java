package com.application.options.handlers;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathValidityChecker {
    public boolean isPathValid(String path) {
        if (path.startsWith("-")) {
            return false;
        }

        try {
            Path p = Paths.get(path);
            return true;
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid path: " + path);
        }
    }
}
