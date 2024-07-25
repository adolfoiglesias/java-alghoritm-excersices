package com.amichdev.excersices.medium.decoding_huffman;


class MainTest {
/*
    public static void main(String[] args) {


        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();

        node4.data = 'B';

        node5.data = 'C';

        node3.data = 'A';

        node2.data = 'ϕ';
        node2.left = node4;
        node2.right = node5;


        Node root = new Node();
        root.data = 'ϕ';
        root.left = node2;
        root.right = node3;

        String code = "1001011";
        Stirng code2 = "ABACA"

        char[] array = code.toCharArray();

        StringBuilder builder = new StringBuilder();

        showRes(array, root, root, 0, builder);
        System.out.println(builder);

       // decode(code, root);
    }

    static void showRes(char[] array, Node node, Node root,  int pos, StringBuilder builder){

        if (node != null && node.data != 'ϕ') {
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

    static char decode(char[] array, Node node, Integer pos) {

        if (node.data != 'ϕ') {
            return node.data;
        }

        if (array[pos] == '0' ){
            return decode(array, node.left, pos+1);
        } else {
            char v = decode(array, node.right, pos+1);

            return v;
        }
    }
*/

}
