package com.application.options.validators;

public class TextFilesExistenceValidator implements ArgumentValidator {
    @Override
    public boolean validate(String[] arguments) throws IllegalArgumentException {
        for (String argument : arguments) {
            if (argument.contains(".txt")) {
                return true;
            }
        }
        return false;
    }
}
