package com.amichdev.excersices.medium.binary_tree_top_view;


import java.util.*;
https://www.google.com/imgres?q=top%20view%20of%20a%20binary%20tree%20explanation%20interactive&imgurl=https%3A%2F%2Fmiro.medium.com%2Fv2%2Fresize%3Afit%3A797%2F1*yZbtPFoG_eJL-a_Q_v3keA.png&imgrefurl=https%3A%2F%2Fmedium.com%2F%40mithratalluri%2Ftrees-top-view-of-a-tree-438a775c21d3&docid=Deo2cxrJnpS-xM&tbnid=h1Kq1LsuQJLXOM&vet=12ahUKEwiJsfj_1_mGAxUhq4QIHccYBDAQM3oECEUQAA..i&w=797&h=471&hcb=2&ved=2ahUKEwiJsfj_1_mGAxUhq4QIHccYBDAQM3oECEUQAA
class Solution {

	/*

    class Node
    	int data;
    	Node left;
    	Node right;
	*/


    static void topViewHD(Node node,int height, int hdValue, Map<Integer, List<Integer>> map) {
        if (node == null) {
            return;
        }


        if (map.containsKey(hdValue)) {
            List<Integer> temp = map.get(hdValue);

            if (temp.get(0) > height ) {
                temp.set(0,height);
                temp.set(1,node.data);
            }
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(height);
            list.add(node.data);
            map.put(hdValue, list);
        }

        height++;

        topViewHD(node.left, height, hdValue - 1, map);

        topViewHD(node.right, height, hdValue + 1, map);



    }

    public static void topView(Node root) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        topViewHD(root, 0, 0, map );

        Map<Integer, List<Integer>> orderedMap = new TreeMap<>(map);

        orderedMap.values().stream().forEach(l -> System.out.print(l.get(1) + " "));

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
        //  Case 1: 6 ->  1 2 5 3 6 4  -> Expected: 1 2 5 6
        // Case 2: 8 -> 10 2 8 7 3 5 2 5  -> Expected:
        // Case 3: 15 ->  1 14 3 7 4 5 15 6 13 10 11 2 12 8 9  . Expected: 2 1 14 15 12
        // case 4: 50 -> 47 2 40 20 38 30 14 28 10 16 19 44 39 27 7 9 31 12 43 21 5 41 34 49 13 33 3 4 25 22 29 15 32 35 6 24 23 26 1 11 42 36 37 17 18 8 45 48 50 46. Expected: 3 5 7 10 1 2 47 49 50 46 37

        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();



        topView(root);
    }
}