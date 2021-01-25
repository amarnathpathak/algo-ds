package com.snap;

import static com.snap.AlgoUtils.getListNode;
import static com.snap.AlgoUtils.reverse;

import java.util.Scanner;

public class ReverseList {
    public ListNode reverseList(ListNode A, int B) {
        ListNode head = new ListNode(0);
        ListNode prev = head;
        ListNode curr = A;
        ListNode next = A;
        ListNode l1 = null;
        int count = 1;
        while(curr!=null){
            ListNode subHead=next;
            next=next.next;
            while(count!=B&& next!=null){
                curr = curr.next;
                next=next.next;
                count++;
            }
            count=1;
            curr.next=null;
            l1 = reverse(subHead);
            subHead.next=next;
            curr=next;
            prev.next=l1;
            prev=subHead;
            
        }
        return head.next;
    }
    public int[][] generate(int A) {
        int[][] res = new int[A][];
        int[] col = new int[1];
        col[0]=1;
        res[0]=col;
        int count = 2;
        for(int i=1; i<A;i++){
            col = new int[count++];
            for(int j=0;j<count-1;j++){
                int k=j-1;
                int val = k==-1 ? 0 : res[i-1][k];
                col[j] = res[i-1][j] + val;
            }
            res[i] = col;
        }
        return res;
    }

    public static void main(String[] args) {
       ListNode head = getListNode(1,2,3,4,5,6,7,8,9,10,11);
       ReverseList rL = new ReverseList();
       int k=3;
       Scanner sc = new Scanner(System.in);
       System.out.println(head);
       System.out.println("Reverse K= "+ k);
       System.out.println(rL.reverseList(head, k));
        
    }

}
