package com.hp.snap.tree;

public class TreeNode<T extends Comparable<?>> {
    public T data;
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;
    private static int level = 0;

    public TreeNode(T val) {
        this.data = val;
        this.val=val;
        this.left = null;
        this.right = null;
    }

    public TreeNode(T val, TreeNode<T> left, TreeNode<T> right) {
        this(val);
        this.left = left;
        this.right = right;

    }

    public static void printLeftView(TreeNode root) {
        level = 0;
        printLeftView(root, 1);
    }

    private static void printLeftView(TreeNode root, int curlLevel) {
        if (root == null) {
            return;
        }
        if (curlLevel > level) {
            level = curlLevel;
            System.out.print(root.data + " ");
        }
        printLeftView(root.left, curlLevel + 1);
        printLeftView(root.right, curlLevel + 1);
    }

    public static void printRightView(TreeNode root) {
        level = 0;
        printRightView(root, 1);
    }

    private static void printRightView(TreeNode root, int curlLevel) {
        if (root == null) {
            return;
        }
        if (curlLevel > level) {
            level = curlLevel;
            System.out.print(root.data + " ");
        }
        printRightView(root.right, curlLevel + 1);
        printRightView(root.left, curlLevel + 1);
    }

}
