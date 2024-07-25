package com.application.options.statistics;

public class IntegersFullStatistics implements StatisticsProvider{

    private final StatisticsPrinter statisticsPrinter = new StatisticsPrinter();
    private final StatisticsManagerForNumbers statManagerForNumbers = new StatisticsManagerForNumbers();
    @Override
    public void provide(String pathToFile) {
        float minFloat = (float) statManagerForNumbers.findMinNumber(pathToFile);
        float maxFloat = (float) statManagerForNumbers.findMaxNumber(pathToFile);
        float averageFloat = (float) statManagerForNumbers.findAverageNumber(pathToFile);
        float sumFloat = (float) statManagerForNumbers.findSumNumber(pathToFile);

        int min = (int) minFloat;
        int max = (int) maxFloat;
        int average = (int) averageFloat;
        int sum = (int) sumFloat;

        statisticsPrinter.printFullStat(min, max, average, sum, "integer");
    }

}
