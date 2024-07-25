package com.amichdev.excersices.basic.sparse_arrays;

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

        System.out.println("Case 1");
        System.out.println(matchingStrings(List.of("aba", "baba", "aba", "xzxb"),
                List.of("aba", "xzxb", "ab")));

        System.out.println("Case 2");
        System.out.println(matchingStrings(List.of("def", "de", "fgh"),
                List.of("de", "lmn", "fgh")));
    }

    /*
     * Complete the 'matchingStrings' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING_ARRAY stringList
     *  2. STRING_ARRAY queries
     */

    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        // Write your code here

        List<Integer> result = new ArrayList<>(queries.size());

        Consumer<String> c = (q) -> {
            int total = Long.valueOf(stringList.stream()
                    .filter(value -> value.equals(q)).count()).intValue();
            result.add(total);
        };

        queries.forEach(c);

        return result;
    }

}