package com.amichdev.excersices.medium.decoding_huffman;

class HuffmanLeaf extends Node {

    public HuffmanLeaf(int freq, char val) {
        super(freq);
        data = val;
    }
}