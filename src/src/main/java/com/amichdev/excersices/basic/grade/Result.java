package com.amichdev.excersices.basic.grade;

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

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        // Write your code here
        List<Integer> list = new ArrayList<>();
        grades.stream().forEach(grade -> {
            list.add(round(grade));
        });
        return list;

    }

    private static Integer round(Integer grade) {
        if (grade < 38) {
            return grade;
        }

        Integer nm5 = IntStream.iterate(grade, (number) -> number + 1)
                .filter(number -> number % 5 == 0)
                .findFirst().getAsInt();

        return (nm5 - grade) < 3 ? nm5 : grade;
    }

}