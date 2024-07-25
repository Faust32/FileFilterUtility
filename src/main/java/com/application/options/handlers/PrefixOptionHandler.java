package com.application.options.handlers;

import com.application.options.OptionsConstants;

public class PrefixOptionHandler implements OptionHandler {
    private boolean isPrefixValid(String fileName) {
        if (fileName.startsWith("-")) {
            return false;
        }

        if (fileName.contains(".txt")) {
            return false;
        }

        //Check validity in Windows
        String windowsInvalidChars = "<>:\"/\\|?*";
        for (char c : windowsInvalidChars.toCharArray()) {
            if (fileName.indexOf(c) >= 0) {
                return false;
            }
        }

        //Check validity in Linux/MacOS
        if (fileName.contains("/")) {
            return false;
        }
        return true;
    }
    @Override
    public void handle(String[] args, int index) {
        try {
            if (args[index + 1].contains(".txt")) {
                throw new IllegalArgumentException("Invalid prefix: " + args[index + 1] + ". You probably forgot to enter a prefix.");
            }
            if (index + 1 < args.length && isPrefixValid(args[index + 1])) {
                OptionsConstants.setPrefixForFiles(args[index + 1]);
                OptionsConstants.setIsPrefixRequired(true);
            }
            else {
                throw new IllegalArgumentException("Invalid prefix: " + args[index + 1] + ". Your prefix probably has an invalid character.");
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Index out of bounds: you did not entered a prefix.");
        }
    }
}
