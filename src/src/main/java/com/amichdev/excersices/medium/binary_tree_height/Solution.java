package com.amichdev.excersices.medium.binary_tree_height;


import java.util.Scanner;
/*
https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree/problem?isFullScreen=false
https://hackerrank-challenge-pdfs.s3.amazonaws.com/8793-tree-height-of-a-binary-tree-English?response-content-disposition=inline%3B%20filename%3Dtree-height-of-a-binary-tree-English.pdf&response-content-type=application%2Fpdf&X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAR6O7GJNX5DNFO3PV%2F20240610%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20240610T233701Z&X-Amz-Expires=3600&X-Amz-SignedHeaders=host&X-Amz-Signature=c2036d7e6de6daeec540467fa513ddd37d10e49cdaa54b38c551c82f3fad0907

 Altura de un Arbol:
 - La altura de un árbol binario es el número de aristas entre la raíz del árbol y su hoja más alejada.

 */
class Solution {

	/*
    class Node
    	int data;
    	Node left;
    	Node right;
	*/

    static int internalHeigth(Node node, int total) {

        if (node == null || (node.left == null && node.right == null) ) {
            return total;
        }
        total++;
        int totalLeft = 0;
        int totalRigth = 0;

        totalLeft = internalHeigth(node.left, total);
        totalRigth = internalHeigth(node.right, total);

        if (totalLeft > totalRigth) {
            total= totalLeft;
        } else {
            total= totalRigth;
        }

        return total;


    }
    public static int height(Node root) {
        // Write your code here.
        int total = 0;
        return internalHeigth(root, total);

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

    public static void main(String[] args) {

        Node root0 = new Node(3);
        Node node1 = new Node(1);
        Node node2 = new Node(7);
        Node node3 = new Node(5);
        Node node4 = new Node(4);


        root0.left = node1;
        root0.right = node2;

        node1.left = node3;
        node1.right = node4;

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();

        int height = height(root);
        System.out.println(height);
    }
}
