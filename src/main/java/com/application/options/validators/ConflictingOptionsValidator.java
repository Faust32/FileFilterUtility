package com.application.options.validators;

import java.util.Arrays;

public class ConflictingOptionsValidator implements ArgumentValidator {
    @Override
    public boolean validate(String[] arguments) throws IllegalArgumentException {
        return Arrays.asList(arguments).contains("-s") && Arrays.asList(arguments).contains("-f");
    }
}
