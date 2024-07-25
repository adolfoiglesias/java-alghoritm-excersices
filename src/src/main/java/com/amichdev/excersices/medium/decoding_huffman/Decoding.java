package com.amichdev.excersices.medium.decoding_huffman;


class Decoding {

    /*
        class Node
            public  int frequency; // the frequency of this tree
            public  char data;
            public  Node left, right;

    */
    void showRes(char[] array, Node node, Node root,  int pos, StringBuilder builder){

        if (node != null && node.data != '\u0000') {
            builder.append(node.data);
            showRes(array, root, root, pos, builder);
            return;
        }

        if (pos < array.length) {

            if (array[pos] == '0' ){
                showRes(array, node.left, root, pos + 1, builder);

            } else {
                showRes(array, node.right, root, pos+1, builder);
            }
        }

    }

    void decode(String s, Node root) {

        char[] array = s.toCharArray();

        StringBuilder builder = new StringBuilder();

        showRes(array, root, root, 0, builder);
        System.out.println(builder);
    }




}