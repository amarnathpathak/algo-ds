package com.ds.List;

public class Node<T> {
    public T data;
    public Node next;

    public Node(T x) {
        data = x;
        next = null;
    }

    @Override
    public String toString() {
        return " " + data + "->" + next;
    }

}
