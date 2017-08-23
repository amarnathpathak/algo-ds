package com.hp.snap;

public class Node {
    public int data;
    public Node next;

    Node(int x) {
        data = x;
        next = null;
    }

    @Override
    public String toString() {
        return " " + data + "->" + next;
    }

}
