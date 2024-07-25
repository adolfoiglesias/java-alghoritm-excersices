package com.amichdev.excersices.basic.number_line;

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
        // case 1: 0 3 4 2

        // case 2: 43 2 70 2


    }

    /*
     * Complete the 'kangaroo' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER x1
     *  2. INTEGER v1
     *  3. INTEGER x2
     *  4. INTEGER v2
     */

    public static String kangaroo(int x1, int v1, int x2, int v2) {

        boolean v1greater = v1 > v2;
        if (!v1greater) {
            return "NO";
        }

        boolean divisible = (x2 - x1) % (v1 - v2) == 0;
        return divisible ? "YES" : "NO";

    }

}
