package com.amichdev.excersices.medium.bynaric_tree_level_order;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
Explicacion : como recorrer el arbol en level order
https://www.digitalocean.com/community/tutorials/level-order-traversal-in-a-binary-tree

 */
class Solution {

	/*

    class Node
    	int data;
    	Node left;
    	Node right;
	*/

public static void levelOrder(Node node, List<Integer> list){

    if (node == null) {
        return;
    }
    if (node.left != null) {
        list.add(node.left.data);
    }

    if( node.right != null) {
        list.add(node.right.data);
    }
    levelOrder(node.left, list);
    levelOrder(node.right, list);

}
public static void levelOrder(Node root) {
    List<Integer> list = new ArrayList<>();

    list.add(root.data);
    levelOrder(root, list);

    list.forEach( v -> System.out.print(v + " "));

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
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    Node root = null;
    while(t-- > 0) {
        int data = scan.nextInt();
        root = insert(root, data);
    }
    scan.close();
    levelOrder(root);
}
}