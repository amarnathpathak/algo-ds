package com.hp.ds;

import java.util.*;

public class BinaryTree<T> {
    public T value;
    public BinaryTree left;
    public BinaryTree right;

    public BinaryTree() {
    }


    public BinaryTree(T value) {
        this.value = value;
    }

    public BinaryTree(T value, BinaryTree left, BinaryTree right) {
        this(value);
        this.left = left;
        this.right = right;
    }

    public T value() {
        return value;
    }

    public BinaryTree left() {
        return left;
    }

    public BinaryTree right() {
        return right;
    }

    public BinaryTree left(BinaryTree left) {
        this.left = left;
        return this;
    }

    public BinaryTree right(BinaryTree right) {
        this.right = right;
        return this;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public int height() {

        int lh = 0;
        if (this.left != null) {
            lh = this.left.height();
        }
        int rh = 0;
        if (this.right != null) {
            rh = this.right.height();
        }
        return Math.max(lh, rh) + 1;
    }

    private static <T extends Comparable<?>> int maxLevel(BinaryTree<T> node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    public void printLevelOrder() {
        if (this == null) return;
        int l = 1;
        System.out.print(l + "-> ");
        Queue<BinaryTree> q = new LinkedList<BinaryTree>();
        BinaryTree lb = new BinaryTree(-1);

        q.add(this);
        q.add(lb);

        while (!q.isEmpty()) {
            BinaryTree curr = q.poll();
            if (curr != lb) {
                System.out.print(curr.value + ", ");
                if (curr.left != null) {
                    q.add(curr.left);
                } else {

                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            } else {
                if (q.isEmpty()) break;
                System.out.println();
                l++;
                System.out.print(l + "-> ");
                q.add(curr);

            }
        }

    }

    public static <T extends Comparable<?>> void printNode(BinaryTree<T> root) {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<BinaryTree<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<BinaryTree<T>> newNodes = new ArrayList<BinaryTree<T>>();
        for (BinaryTree<T> node : nodes) {
            if (node != null) {
                System.out.print(node.value);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
