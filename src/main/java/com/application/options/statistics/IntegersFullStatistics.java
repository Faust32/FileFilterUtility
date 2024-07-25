package com.application.options.statistics;

public class IntegersFullStatistics implements StatisticsProvider{

    private final StatisticsPrinter statisticsPrinter = new StatisticsPrinter();
    private final StatisticsManagerForNumbers statManagerForNumbers = new StatisticsManagerForNumbers();
    @Override
    public void provide(String pathToFile) {
        int min = (int) statManagerForNumbers.findMinNumber(pathToFile);
        int max = (int) statManagerForNumbers.findMaxNumber(pathToFile);
        int average = (int) statManagerForNumbers.findAverageNumber(pathToFile);
        int sum = (int) statManagerForNumbers.findSumNumber(pathToFile);
        statisticsPrinter.printFullStat(min, max, average, sum, "integer");
    }
}
