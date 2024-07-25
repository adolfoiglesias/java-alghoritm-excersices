package com.amichdev.excersices.medium.cycle_detection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* Ex:
file: detect-whether-a-linked-list-contains-a-cycle-English.pdf

 */

public class Result {

    public static void main(String[] args) {

        SinglyLinkedListNode node4 = new SinglyLinkedListNode();
        node4.data = 4;

        SinglyLinkedListNode node1 = new SinglyLinkedListNode();
        node1.data = 1;

        SinglyLinkedListNode node3 = new SinglyLinkedListNode();
        node3.data = 3;

        SinglyLinkedListNode node2 = new SinglyLinkedListNode();
        node2.data = 2;

        node4.next = null;
        node3.next = node1;
        node2.next = node3;
        node1.next = node2;

        System.out.println("Using Map"); // ambas funciono en hackerRank
        if (hasCycle(node1)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }

        System.out.println("Using Set"); // ambas funciono en hackerRank
        if (hasCycleUsingSet(node1)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }


    }

    static boolean hasCycleUsingSet(SinglyLinkedListNode head) {
        if (head == null) {
            return false;
        }

        //Map<SinglyLinkedListNode,Boolean> map = new HashMap<>();
        Set<SinglyLinkedListNode> set = new HashSet<>();

        boolean cycle = false;

        while(head != null ) {

            boolean added = set.add(head);

            if (!added) {
                cycle = true;
                break;
            }
            head = head.next;
        }
        return cycle;
    }

    static boolean hasCycle(SinglyLinkedListNode head) {

        if (head == null) {
            return false;
        }

        Map<SinglyLinkedListNode,Boolean> map = new HashMap<>();

        boolean cycle = false;

        while(head != null ) {

            if (map.get(head) != null) {
                cycle = true;
                break;
            } else {
                map.put(head, true);
                head = head.next;
            }
        }
        return cycle;
    }
}
