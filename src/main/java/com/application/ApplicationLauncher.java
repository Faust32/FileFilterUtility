package com.application;

import com.application.files.action.FileChecker;
import com.application.files.action.FileCleaner;
import com.application.files.Type;
import com.application.options.*;
import com.application.options.statistics.FullStatisticsManager;
import com.application.options.statistics.ShortStatisticsManager;
import com.application.options.statistics.StatisticsPrinter;
import com.application.scanner.FileScanner;

import java.io.File;
import java.io.IOException;

public class ApplicationLauncher {

    private final FileScanner fileScanner = new FileScanner();
    private final OptionsManager optionsManager = new OptionsManager();
    private final StatisticsPrinter statisticsPrinter = new StatisticsPrinter();
    private final ShortStatisticsManager shortStatisticsManager = new ShortStatisticsManager();
    private final FullStatisticsManager fullStatisticsManager = new FullStatisticsManager();
    private final FileChecker fileChecker = new FileChecker();
    private final FileCleaner fileCleaner = new FileCleaner();

    public void launch(String[] args) throws IOException {
        String[] filesToScan = optionsManager.initialize(args);
        File directory = new File(OptionsConstants.getPathForResults());
        File[] files = fileChecker.listFilesInDirectory(directory);

        cleanFilesIfNeeded(files);
        scanFiles(filesToScan);
        processStatistics(files);
    }

    private void cleanFilesIfNeeded(File[] files) throws IOException {
        if (!OptionsConstants.isAddToExistingFiles()) {
            for (File file : files) {
                fileCleaner.perform(file);
            }
        }
    }

    private void scanFiles(String[] filesToScan) {
        for (String file : filesToScan) {
            fileScanner.scan(file);
        }
    }

    private void processStatistics(File[] files) {
        String prefix = OptionsConstants.getPrefixForFiles();
        if (OptionsConstants.isShortStatRequired()) {
            processStatisticsForType(true, files, prefix);
        }
        if (OptionsConstants.isFullStatRequired()) {
            processStatisticsForType(false, files, prefix);
        }
    }

    private void processStatisticsForType(boolean isShortStat, File[] files, String prefix) {
        for (File file : files) {
            Type type = Type.fromFileName(prefix, file.getName());
            statisticsPrinter.startMessage();
            if (isShortStat) {
                shortStatisticsManager.gatherStatistics(file.getPath(), type);
            } else {
                fullStatisticsManager.gatherStatistics(file.getPath(), type);
            }
        }
    }
}
