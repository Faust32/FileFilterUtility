package com.application;

import java.io.IOException;

public class App {
    private static final ApplicationLauncher applicationLauncher = new ApplicationLauncher();
    public static void main(String[] args) throws IOException {
        applicationLauncher.launch(args);
    }

}

