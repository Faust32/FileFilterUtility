package com.application.options.validators;


public class DuplicatesValidator implements ArgumentValidator {

    @Override
    public boolean validate(String[] arguments) throws IllegalArgumentException {
        for (int i = 0; i < arguments.length; i++) {
            for (int j = i + 1; j < arguments.length; j++) {
                if (arguments[i].equals(arguments[j])) {
                    return true;
                }
            }
        }
        return false;
    }
}
