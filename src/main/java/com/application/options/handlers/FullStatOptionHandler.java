package com.application.options.handlers;

import com.application.options.OptionsConstants;

public class FullStatOptionHandler implements OptionHandler {

    @Override
    public void handle(String[] args, int index) {
        OptionsConstants.setIsFullStatRequired(true);
    }
}
