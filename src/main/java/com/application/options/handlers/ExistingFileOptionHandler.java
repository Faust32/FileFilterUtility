package com.application.options.handlers;

import com.application.options.OptionsConstants;

public class ExistingFileOptionHandler implements OptionHandler {

    @Override
    public void handle(String[] args, int index) {
        OptionsConstants.setAddToExistingFiles(true);
    }

}
