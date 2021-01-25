package com.snap;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.regex.Pattern;

import com.ds.List.Node;
import com.ds.tree.TreeNode;

public class AlgoUtils {

    private static final Pattern VALID_LETTER_REGEX = Pattern.compile("^[A-Za-z]\\w{2,49}$", Pattern.CASE_INSENSITIVE);

    private AlgoUtils() {

    }

    public static int titleToNumber(String a) {
        int result = 0;
        char[] charArray = a.toCharArray();
        int i = 0;
        while (i < charArray.length) {
            char c = charArray[i++];
            int n = c + (32 - 96);
            result = result * 26 + n;
        }

        return result;
    }
    public static boolean validLetterOnlyString(CharSequence obj) {
        if (obj!=null && VALID_LETTER_REGEX.matcher(obj).find()) {
            return true;
        }
        return false;
    }

    public static TwoList breakAtMid(ListNode A) {
        ListNode fast = A;
        ListNode slow = A;
        ListNode prev = A;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if (fast != null) {
            prev = slow;
            slow = slow.next;
        }
        prev.next = null;
        return new TwoList(A, slow);
    }

    public static ListNode reverse(ListNode A) {

        if (A == null || A.next == null) {
            return A;
        }
        ListNode prev, curr, next;
        prev = null;
        curr = A;
        next = curr;
        while (next != null) {
            next = next.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;

    }

    public static ListNode getListNode(int... a) {

        ListNode head = new ListNode(a[0]);
        ListNode curr = head;
        for (int i = 1; i < a.length; i++) {
            ListNode node = new ListNode(a[i]);
            curr.next = node;
            curr = curr.next;
        }
        return head;

    }

    public static Node getNode(Object... a) {

        Node<Object> head = new Node<Object>(a[0]);
        Node curr = head;
        for (int i = 1; i < a.length; i++) {
            Node node = new Node(a[i]);
            curr.next = node;
            curr = curr.next;
        }
        return head;

    }

    public static TreeNode<Integer> getBst(int... a) {

        TreeNode<Integer> root = new TreeNode<Integer>(a[0]);
        TreeNode<Integer> r = null;
        int i = 1;
        while (i < a.length) {
            r = root;
            TreeNode<Integer> t = new TreeNode<Integer>(a[i++]);
            while (r != null) {
                if (r.data.compareTo(t.data) > 0) {
                    if (r.left == null) {
                        r.left = t;
                        break;
                    }
                    r = r.left;
                } else {
                    if (r.right == null) {
                        r.right = t;
                        break;
                    }
                    r = r.right;
                }
            }
        }
        return root;

    }

    public static List<Integer> inOrder(TreeNode root) {
        List<Integer> inorder = new ArrayList<Integer>();
        if (root == null) {
            return new ArrayList<Integer>();
        }

        // keep the nodes in the path that are waiting to be visited
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;

        // first node to be visited will be the left one
        while (node != null) {
            stack.push(node);
            node = node.left;
        }

        // traverse the tree
        while (stack.size() > 0) {

            // visit the top node
            node = stack.pop();
            inorder.add((Integer) node.data);
            if (node.right != null) {
                node = node.right;

                // the next node to be visited is the leftmost
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return inorder;
    }

    public static void printArray(int[] num) {
        StringBuilder s = new StringBuilder();
        s.append(num[0]);
        for (int i = 1; i < num.length; i++) {
            s.append(", " + num[i]);

        }
        System.out.println(s);
    }

    public static void print2DArray(int[][] res){
    	for(int i=0;i<res.length;i++){
    		for(int val:res[i]){
    			System.out.print(" " + val);
    		}
    		System.out.println();
    	}
    }



}
