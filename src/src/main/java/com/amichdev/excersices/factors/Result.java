package com.amichdev.excersices.factors;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Result {

    public static void main(String[] args) {

        List a = List.of(2, 6);
        List b = List.of(24, 36);

        System.out.println(getTotalX(a, b));

        System.out.println("Case 2");
        a = List.of(2, 4);
        b = List.of(16, 32, 96);

        System.out.println(getTotalX(a, b));
    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {

        int max = Collections.max(a);
        int min = Collections.min(b);

        List<Integer> list = IntStream.range(max, min+1)
                .filter(n ->  a.stream().allMatch(value ->  n % value == 0)
                        && b.stream().allMatch(value -> value % n == 0))
                .boxed().collect(Collectors.toList());

        return list.size();
    }
}
