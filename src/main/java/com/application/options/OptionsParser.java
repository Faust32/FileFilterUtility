package com.application.options;


import com.application.files.action.FileChecker;
import com.application.options.handlers.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptionsParser {
    private final Map<String, OptionHandler> optionsMap = new HashMap<>();
    private final FileChecker fileChecker = new FileChecker();
    public OptionsParser() {
        optionsMap.put("-s", new ShortStatOptionHandler());
        optionsMap.put("-f", new FullStatOptionHandler());
        optionsMap.put("-p", new PrefixOptionHandler());
        optionsMap.put("-o", new ResultPathOptionHandler());
        optionsMap.put("-a", new ExistingFileOptionHandler());
    }

    public String[] run(String[] args) {
        List<String> txtFilesList = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            OptionHandler handler = optionsMap.get(arg);
            if (handler != null) {
                handler.handle(args, i);
                continue;
            }
            if (fileChecker.isFileValid(args[i])){
                txtFilesList.add(args[i]);
            }
        }
        return txtFilesList.toArray(new String[0]);
    }
}

