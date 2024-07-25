package com.application.options.statistics;

import com.application.files.Type;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class StringsFullStatistics implements StatisticsProvider{

    private final StatisticsPrinter statisticsPrinter = new StatisticsPrinter();

    private String longestString(String pathToFile) {
        String longestString = "";
        try {
            File file = new File(pathToFile);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.length() > longestString.length()) {
                    longestString = line;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("File not found: " + pathToFile);
        }
        return longestString;
    }

    private String shortestString(String pathToFile) {
        String shortestString = null;
        try {
            File file = new File(pathToFile);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (shortestString == null || line.length() < shortestString.length()) {
                    shortestString = line;
                }
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("File not found: " + pathToFile);
        }
        return shortestString;
    }


    @Override
    public void provide(String pathToFile) {
        String shortestString = shortestString(pathToFile);
        String longestString = longestString(pathToFile);
        statisticsPrinter.printFullStat(shortestString, longestString);
    }
}
