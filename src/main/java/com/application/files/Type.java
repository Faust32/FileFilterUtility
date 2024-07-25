package com.application.files;

public enum Type {
    FLOATS("floats.txt"),
    INTEGERS("integers.txt"),
    STRINGS("strings.txt"),;

    private final String fileName;

    Type(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public static Type fromFileName(String prefix, String fullFileName) {
        String fileNameWithoutPrefix;

        if (fullFileName.startsWith(prefix)) {
            fileNameWithoutPrefix = fullFileName.substring(prefix.length());
        } else {
            fileNameWithoutPrefix = fullFileName;
        }

        for (Type type : Type.values()) {
            if (type.getFileName().equals(fileNameWithoutPrefix)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Unknown file type: " + fullFileName);
    }
}
