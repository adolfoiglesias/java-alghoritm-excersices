package com.amichdev.excersices.medium.binary_tree_loop;

import java.util.ArrayList;
import java.util.List;


/*  DFS traversal of a Tree : PreOrder, InOrder and PostOrder son formas de recorrer el arbol de forma DFS ( depth First Search)
    PreOrder, In-Order, Post-order traversal tree
    - https://1.bp.blogspot.com/-bn3KHYB2BYk/V4OfyZQUnNI/AAAAAAAAGng/T_EEc1IOXEoOdVvFQpCEr-LXAKqyu8F5wCLcB/s1600/binary+tree+PreOrder+traversal+in+Java+.png
https://codesandbox.io/s/tree-traversal-visualisation-d1064
     */
class Solution {

/* you only have to complete the function given below.
Node is defined as

class Node {
    int data;
    Node left;
    Node right;
}

*/

    public static void main(String[] args) {

        Node node2 = new Node(2);
        Node node3 = new Node(5);
        Node node4 = new Node(3);
        Node node5 = new Node(6);
        Node node7 = new Node(4);

        node4.right = node7;

        node3.left = node4;
        node3.right = node5;

        node2.left = null;
        node2.right = node3;


        Node root = new Node(1);
        root.right = node2;
        System.out.print("pre order: ");
        preOrder(root);

        // postOrder
        System.out.println();
        System.out.print("post order: ");
        postOrder(root);

        System.out.println();
        System.out.print("in order: ");
        inOrder(root);


    }

    static void inOrder(Node node, StringBuilder builder) {

        if (node == null){
            return;
        }

        if (node.left != null) {
            inOrder(node.left, builder);
        }

        builder.append(node.data + " ");

        inOrder(node.right, builder);
    }

    public static void inOrder(Node root) {

        StringBuilder builder = new StringBuilder();

        inOrder(root, builder);

        System.out.println(builder.toString());
    }

    public static void postOrder(Node root) {

        List<Integer> values = new ArrayList<>();
        postOrder(root, values);
        values.forEach(v -> System.out.print(String.valueOf(v + " ")));

    }

    public static void postOrder(Node node, List<Integer> list) {

        if (node.left != null ){
            postOrder(node.left, list);
        }

        if (node.right != null ){
            postOrder(node.right, list);
        }
        list.add(node.data);


    }




    static void preOrder(Node node, List<Integer> values) {

        if (node != null) {
            values.add(node.data);
        }

        if (node.left != null) {
            preOrder(node.left, values);
        }
        if (node.right != null) {
            preOrder(node.right, values);
        }

    }


    public static void preOrder(Node root) {
        List<Integer> values = new ArrayList<>();
        preOrder(root, values);
        values.forEach(v -> System.out.print(String.valueOf(v + " ")));
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        } else {
            Node cur;
            if (data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }


}
