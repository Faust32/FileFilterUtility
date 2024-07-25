package com.application.options.statistics;

import com.application.files.Type;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ShortStatisticsManager {
    private final StatisticsPrinter statisticsPrinter = new StatisticsPrinter();
    public void gatherStatistics(String pathToFile, Type typeOfFile) {
        int numberOfElements = countElements(pathToFile);
        statisticsPrinter.printShortStat(numberOfElements, typeOfFile);
    }

    public int countElements(String pathToFile) {
        int k = 0;
        try {
            File file = new File(pathToFile);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                k++;
            }
            scanner.close();
        } catch (IOException e) {
            System.out.println("File not found: " + pathToFile);
        }
        return k;
    }
}
