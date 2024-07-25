package com.application.options.statistics;

import com.application.files.Type;


public class FullStatisticsManager{
    private final ShortStatisticsManager shortStatisticsManager = new ShortStatisticsManager();
    private final StringsFullStatistics stringsFullStatistics = new StringsFullStatistics();
    private final IntegersFullStatistics integersFullStatistics = new IntegersFullStatistics();
    private final FloatsFullStatistics floatsFullStatistics = new FloatsFullStatistics();

    public void gatherStatistics(String pathToFile, Type typeOfFile) {
        shortStatisticsManager.gatherStatistics(pathToFile, typeOfFile);
        switch (typeOfFile){
            case STRINGS:
                stringsFullStatistics.provide(pathToFile);
                break;
            case INTEGERS:
                integersFullStatistics.provide(pathToFile);
                break;
            case FLOATS:
                floatsFullStatistics.provide(pathToFile);
                break;
        }
    }

}
