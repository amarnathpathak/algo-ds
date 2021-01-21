package com.hp.ds;

public class Node<T> {

    protected T value;
    protected Node next;

    public Node(T value, Node next) {
        this.value = value;
        this.next = next;

    }

    public Node(T value) {
        this(value, null);
    }

    public Node() {
        this(null);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("{");
        sb.append(value);
        sb.append('}');
        sb.append("->");
        sb.append(next);
        return sb.toString();
    }
}
