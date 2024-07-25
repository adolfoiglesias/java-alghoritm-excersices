package com.amichdev.excersices.medium.lower_common_ancestor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Excersice : https://hackerrank-challenge-pdfs.s3.amazonaws.com/8831-binary-search-tree-lowest-common-ancestor-English?response-content-disposition=inline%3B%20filename%3Dbinary-search-tree-lowest-common-ancestor-English.pdf&response-content-type=application%2Fpdf&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAR6O7GJNX5DNFO3PV%2F20240531%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20240531T212232Z&X-Amz-Expires=3600&X-Amz-SignedHeaders=host&X-Amz-Signature=639b5d8b2d8cdf651d39af5df0d748d05a4eddd3d4771b4ffe49c3685ca4fbe4
 */

public class Solution {

    public static void main(String[] args) {
        //Scanner scan = new Scanner(System.in);
        int t = 0;
        Node root = null;

        /*
        int[] input = new int[] {5,3,8,2,4,6,7};
        int v1 = 7;
        int v2 = 3;
        // expected = 5

         */


        int[] input = new int[] {9,7,8,5,6,4,3,1};
        int v1 = 1;
        int v2 = 6;
        // expected = 5

        while(t < input.length) {
            int data = input[t];
            root = insert(root, data);
            t++;
        }


        Node ans = lca(root,v1,v2);
        System.out.println(ans.data);
    }

    public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }



    /*
    class Node
    	int data;
    	Node left;
    	Node right;
	*/

    static boolean isChildren(Node node, int v1) {
        if (node == null) {
            return false;
        }
        if (node.data == v1) {
            return true;
        } else {
            boolean res1 = isChildren(node.left, v1);
            boolean res2 = isChildren(node.right, v1);

            return res1 || res2;

        }
    }

    static Node getLCA(Node root, int v1, int v2, Node pointer) {

        if (v1 < root.data && root.data < v2 ) {
            if (isChildren(root, v1) && isChildren(root, v2)) {
                pointer = root;
                getLCA(root.left, v1, v2, pointer);
            }
        }
        else if (v1 > root.data){
            pointer = getLCA(root.right, v1, v2, root.right);
        } else if (root.data > v2 ) {
            pointer = getLCA(root.left, v1, v2, root.left);
        }
        return pointer;
    }

    public static Node lca(Node root, int v1, int v2) {
        // Write your code here.

        Node pointer = root;
        if(v1 < v2 ) {
            pointer = getLCA(root, v1, v2, pointer);
        } else {
            pointer = getLCA(root, v2, v1, pointer);
        }
        return pointer;

    }
}
