package com.application.options;

import com.application.options.validators.ArgumentValidator;
import com.application.options.validators.ConflictingOptionsValidator;
import com.application.options.validators.DuplicatesValidator;
import com.application.options.validators.TextFilesExistenceValidator;

import java.util.Arrays;
import java.util.List;


public class OptionsManager {
    private final List<ArgumentValidator> validators = Arrays.asList(
            new DuplicatesValidator(),
            new ConflictingOptionsValidator(),
            new TextFilesExistenceValidator()
    );

    private final OptionsParser optionsParser = new OptionsParser();

    public String[] initialize(String[] arguments) {
        for (ArgumentValidator validator : validators) {
            validator.validate(arguments);
        }
        return optionsParser.run(arguments);
    }

}
