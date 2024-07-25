package com.amichdev.excersices.basic.records;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static void main(String[] args) {

        var l = new ArrayList<>(List.of(1,2,3  ,4,5));

        Collections.rotate(l, 2 * -1);

        System.out.println("Rotate list");
        System.out.println(l);

        System.out.println("Case 1");
        System.out.println(breakingRecords(List.of(3,4,25,8,10,5,28))); ;

        System.out.println("Case 2");
        System.out.println(breakingRecords(List.of(13, 4, 10, 15, 2))); ;

        System.out.println("Case 3");
        System.out.println(breakingRecords(List.of(0,9,3,10,2,20))); ;
    }

    /*
     * Complete the 'breakingRecords' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY scores as parameter.
     */

    public static List<Integer> breakingRecords(List<Integer> scores) {



        // Write your code here

        int maxRecords = 0;
        int minRecords = 0;

        int maxValue = 0;
        int minValue = 0;

        for (int i = 1; i < scores.size(); i++) {
            if (maxValue < scores.get(i) ) {
                maxValue = scores.get(i);
                maxRecords++;
            } else if (minValue > scores.get(i)) {
                minValue = scores.get(i);
                minRecords++;
            }
        }


        return List.of(maxRecords, minRecords);

    }

}