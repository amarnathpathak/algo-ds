package com.snap;

import static com.snap.AlgoUtils.getListNode;

public class CircularLinkedList {
    public boolean detectLoop(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow, fast;
        slow = fast = head;
        fast = fast.next;
        while (slow != fast && (fast != null && fast.next != null)) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow == fast) {
            return true;
        }
        return false;
    }

    public int removeTheLoop(ListNode head) {

        if (head == null || head.next == null) {
            return 1;
        }
        ListNode slow, fast, prev;
        slow = fast = head;
        fast = fast.next;
        prev = null;
        while (slow != fast && (fast != null && fast.next != null)) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == fast) {
            fast = head;
            while (fast != slow.next) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = null;
        }
        return 1;

    }

    public static void main(String[] args) {
        ListNode head = getListNode(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11);
        CircularLinkedList cLL = new CircularLinkedList();
        System.out.println(head);
        System.out.println(cLL.detectLoop(head));
        ListNode.getLastNode(head).next = ListNode.getNode(head, 6);
        System.out.println(cLL.detectLoop(head));
        cLL.removeTheLoop(head);

    }

}
