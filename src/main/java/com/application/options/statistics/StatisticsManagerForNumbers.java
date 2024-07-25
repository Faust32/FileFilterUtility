package com.application.options.statistics;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.function.BiFunction;

public class StatisticsManagerForNumbers {
    private final ShortStatisticsManager shortStatisticsManager = new ShortStatisticsManager();

    public Number processFile(String pathToFile, float initialValue, BiFunction<Float, Float, Float> operation) {
        float result = initialValue;
        try (Scanner scanner = new Scanner(new File(pathToFile))) {
            while (scanner.hasNextLine()) {
                float currentFloat = Float.parseFloat(scanner.nextLine());
                result = operation.apply(result, currentFloat);
            }
        } catch (IOException e) {
            System.out.println("File not found: " + pathToFile);
        }
        return result;
    }

    public Number findMinNumber(String pathToFile) {
        return processFile(pathToFile, Float.MAX_VALUE, Math::min);
    }

    public Number findMaxNumber(String pathToFile) {
        return processFile(pathToFile, Float.MIN_VALUE, Math::max);
    }

    public Number findSumNumber(String pathToFile) {
        return processFile(pathToFile, 0, Float::sum);
    }

    public Number findAverageNumber(String pathToFile) {
        Number sum = findSumNumber(pathToFile);
        int numberOfElements = shortStatisticsManager.countElements(pathToFile);
        return (float) sum / numberOfElements;
    }
    // of course, it would be much better to make a method that returns all of this stuff in a list and then work with it,
    // but I feel a bit lazy right now so... later...
}
