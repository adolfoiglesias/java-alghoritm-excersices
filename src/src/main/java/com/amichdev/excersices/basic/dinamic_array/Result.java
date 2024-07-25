package com.amichdev.excersices.basic.dinamic_array;
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

/**
 * Excercices : https://drive.google.com/drive/u/0/folders/1hrz6TFAVPK1kR5ZOKi9goQuvx6G4Rm55
 *
 * pdf: dynamic-array-English.pdf
 */
class Result {

    public static void main(String[] args) {


        int n = 2;

        System.out.println("Otro");

        List<List<Integer>> queries = new ArrayList<>(5);

        queries.add(List.of(1, 0, 5));
        queries.add(List.of(1, 1, 7));
        queries.add(List.of(1, 0, 3));
        queries.add(List.of(2, 1, 0));
        queries.add(List.of(2, 1, 1));

        var result = dynamicArray(n, queries);

        result.forEach(System.out::println);

    }

    /*
     * Complete the 'dynamicArray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here

        int lastAnswers = 0;

        List<Integer> result = new ArrayList<>();
        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, n).forEach( number -> {
            arr.add(new ArrayList<Integer>());
        });

        for (List<Integer> query : queries) {

            int queryType = query.get(0);
            int x = query.get(1);
            int y = query.get(2);

            int idx = (x ^ lastAnswers) % n;
            if (queryType == 1) {
                arr.get(idx).add(y);

            } else if (queryType == 2){

                lastAnswers  = arr.get(idx).get(y % arr.get(idx).size());
                result.add(lastAnswers);
            }
        }
        return result;

    }

}