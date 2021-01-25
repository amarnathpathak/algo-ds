package com.ds.tree;

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

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
