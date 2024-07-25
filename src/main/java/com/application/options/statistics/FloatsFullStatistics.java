package com.application.options.statistics;


public class FloatsFullStatistics implements StatisticsProvider{
    private final StatisticsManagerForNumbers statManagerForNumbers = new StatisticsManagerForNumbers();
    private final StatisticsPrinter statisticsPrinter = new StatisticsPrinter();


    @Override
    public void provide(String pathToFile) {
        float min = (float)statManagerForNumbers.findMinNumber(pathToFile);
        float max = (float)statManagerForNumbers.findMaxNumber(pathToFile);
        float average = (float) statManagerForNumbers.findAverageNumber(pathToFile);
        float sum = (float)statManagerForNumbers.findSumNumber(pathToFile);
        statisticsPrinter.printFullStat(min, max, average, sum, "float");

    }
}
