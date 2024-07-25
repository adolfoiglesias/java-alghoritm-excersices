package com.amichdev.excersices.hard.array_manipulation;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {


    public static void main(String[] args){

        List<List<Integer>> queries = new ArrayList<>();


        queries.add(List.of(1, 2, 100));
       // queries.add(List.of(2, 5, 100));
       // queries.add(List.of(3, 4, 100));

        System.out.println(arrayManipulation(5, queries));
    }

    /*
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY queries
     */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        // Write your code here


        List<Long> list = IntStream.range(0, n)
                .boxed()
                .map(number -> 0L)
                .collect(Collectors.toList());


        //Long[] arr = list.toArray(new Long[n]);

        //Stream.of(arr).forEach(System.out::println);

        // List<Long> list = new ArrayList<>(n);
        //long max = 0;

        for(List<Integer> query: queries) {
            int index1 = query.get(0);
            int index2 = query.get(1);
            int k = query.get(2);

            List<Long> subList = list.subList(index1-1, index2);

            AtomicInteger index = new AtomicInteger(0);

            System.out.println("Sublist---");
            subList.forEach(System.out::println);


            subList.parallelStream().forEach(num -> {
                int currentIndex = index.getAndIncrement();
                subList.set(currentIndex, num + k);
            });
            System.out.println("List change---");
            list.forEach(System.out::println);

            //Arrays.parallelPrefix(arr, index1-1, index2, (number1, number2) -> number1 + k);
            /*
            for(int i = index1; i <= index2; i++){

                long temp = list.get(i-1) + k;
                list.set(i-1, temp);
                if (max < temp) {
                    max = temp;
                }
            }*/
        }

        return Collections.max(list);
        //return Collections.max(Arrays.asList(arr));

    }

}
