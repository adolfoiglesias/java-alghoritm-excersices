package com.amichdev.excersices;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {


        List<Integer> list1 = List.of(7, 8, 9, 10);
        List<Integer> list2 = List.of(7, 5, 12, 10);

        Set set = new HashSet(list1);


        System.out.println("Hello world!");
    }
}