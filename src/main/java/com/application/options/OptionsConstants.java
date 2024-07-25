package com.application.options;

public class OptionsConstants {
    private static boolean IS_SHORT_STAT_REQUIRED = false;
    private static boolean IS_FULL_STAT_REQUIRED = false;
    private static boolean IS_RESULT_PATH_EXISTS = false;
    private static boolean IS_PREFIX_REQUIRED = false;
    private static boolean ADD_TO_EXISTING_FILES = false;

    private static String PREFIX_FOR_FILES = "";

    private static String PATH_FOR_RESULTS = "";

    public static boolean isFullStatRequired() {
        return IS_FULL_STAT_REQUIRED;
    }

    public static void setIsFullStatRequired(boolean isFullStatRequired) {
        IS_FULL_STAT_REQUIRED = isFullStatRequired;
    }

    public static boolean isShortStatRequired() {
        return IS_SHORT_STAT_REQUIRED;
    }

    public static void setIsShortStatRequired(boolean isShortStatRequired) {
        IS_SHORT_STAT_REQUIRED = isShortStatRequired;
    }

    public static void setIsResultPathExists(boolean isResultPathExists) {
        IS_RESULT_PATH_EXISTS = isResultPathExists;
    }

    public static void setIsPrefixRequired(boolean isPrefixRequired) {
        IS_PREFIX_REQUIRED = isPrefixRequired;
    }

    public static boolean isAddToExistingFiles() {
        return ADD_TO_EXISTING_FILES;
    }

    public static void setAddToExistingFiles(boolean addToExistingFiles) {
        ADD_TO_EXISTING_FILES = addToExistingFiles;
    }

    public static String getPrefixForFiles() {
        return PREFIX_FOR_FILES;
    }

    public static void setPrefixForFiles(String prefixForFiles) {
        PREFIX_FOR_FILES = prefixForFiles;
    }

    public static String getPathForResults() {
        return PATH_FOR_RESULTS;
    }

    public static void setPathForResults(String pathForResults) {
        PATH_FOR_RESULTS = pathForResults;
    }

    public static boolean isIsResultPathExists() {
        return IS_RESULT_PATH_EXISTS;
    }

    public static boolean isIsPrefixRequired() {
        return IS_PREFIX_REQUIRED;
    }
}
