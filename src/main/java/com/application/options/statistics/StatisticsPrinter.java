package com.application.options.statistics;

import com.application.files.Type;
import com.application.options.OptionsConstants;

public class StatisticsPrinter {

    public void printShortStat(int numberOfElements, Type typeOfFile) {
        String message = String.format("Number of elements of type %s: %d", typeOfFile.toString().toLowerCase(), numberOfElements);
        System.out.println(message);
    }

    public void printFullStat(Number min, Number max, Number average, Number sum, String type) {
        System.out.println("Minimum " + type + " in provided file(s): " + min);
        System.out.println("Maximum " + type + " in provided file(s): " + max);
        System.out.println("Average " + type + " in provided file(s): " + average);
        System.out.println("Sum of all " + type + "s in provided file(s): " + sum);
    }

    public void printFullStat(String shortestString, String longestString){
        System.out.println("Shortest string in provided file(s): " + shortestString);
        System.out.println("Its length: " + shortestString.length());
        System.out.println("Longest string in provided file(s): " + longestString);
        System.out.println("Its length: " + longestString.length());
    }

    public void startMessage(){
        boolean shortStat = OptionsConstants.isShortStatRequired();
        System.out.println("Here is the " + (shortStat ? "short" : "full") + " statistics of final files:");
    }
}
