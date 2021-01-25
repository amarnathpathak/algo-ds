package com.snap;

public class ListNode {

    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    @Override
    public String toString() {
        return " " + val + "->" + next;
    }

    public static ListNode getLastNode(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode last = node;
        while (last.next != null) {
            last = last.next;
        }
        return last;
    }

    public static ListNode getNode(ListNode node, int val) {
        if (node == null) {
            return node;
        }
        ListNode last = node;
        while (last.next != null) {
            last = last.next;
            if (last.val == val) {
                return last;
            }
        }
        return null;
    }
}
