package com.amichdev.excersices.basic.apple_and_orange;
import java.util.*;

import static java.util.stream.Collectors.joining;

class Result {

    public static void main(String[] args) {

        // case 1
        System.out.println("Case 1: one intersection");
        countApplesAndOranges(7, 11, 5, 15, List.of(-2, 2, 1 ), List.of(5, -6));

        //case 2
        System.out.println("Case 2: no intersection");
        countApplesAndOranges(7, 11, 2, 15, List.of(-2, 2, 1 ), List.of(5, 6));

        // case 3
        // countApplesAndOranges(7, 11, 5, 15, List.of(-2, 2, 1 ), List.of(5, -6));

    }

    /*
     * Complete the 'countApplesAndOranges' function below.
     *
     * The function accepts following parameters:
     *  1. INTEGER s
     *  2. INTEGER t
     *  3. INTEGER a
     *  4. INTEGER b
     *  5. INTEGER_ARRAY apples
     *  6. INTEGER_ARRAY oranges
     */

    public static void countApplesAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges) {

        long applesIn = apples.stream()
                .map(pos -> a + pos )
                .filter(newPos ->  s <= newPos && newPos <= t )
                .count();

        long orangeIn = oranges.stream()
                .map(pos -> b + pos )
                .filter(newPos ->  s <= newPos && newPos <= t )
                .count();

        System.out.println(applesIn);
        System.out.println(orangeIn);




    }

}
