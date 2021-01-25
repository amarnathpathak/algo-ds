package com.snap;

import static com.snap.AlgoUtils.breakAtMid;
import static com.snap.AlgoUtils.reverse;

/*
 * Given a singly linked list
    L: L0 → L1 → … → Ln-1 → Ln,
   reorder it to:
    L0 → Ln → L1 → Ln-1 → L2 → Ln-2 → …
   
You must do this in-place without altering the nodes’ values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}. 
*/

public class ReorderList {
    public ListNode reorderList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        TwoList tl = breakAtMid(A);
        ListNode l1 = tl.l1;
        ListNode l2 = tl.l2;

        l2 = reverse(l2);

        ListNode head = l1;
        ListNode curr = null;
        ListNode curr2 = l2.next;
        while (l1 != null && l2 != null) {
            curr = l1.next;
            l1.next = l2;
            l1 = curr;
            curr2 = l2.next;
            l2.next = l1;
            l2 = curr2;
        }
        return head;

    }

}
