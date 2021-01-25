package com.ps;

import com.ds.tree.BinaryTree;

public class BinaryTreeProblem<T> {


    public boolean printAllAncestors(BinaryTree<T> root, T child) {

        if (root == null) return false;

        if (root.value() == child) {
            System.out.println(root.value());
            return true;
        }
        if (printAllAncestors(root.left(), child) || printAllAncestors(root.right(), child)) {
            System.out.println(root.value());
            return true;
        }
        return false;


    }


    public BinaryTree<T> getRandomTreeOfSize(int n) {
        return randomTree(n, 0);

    }

    enum LRN {L, R, N}

    LRN[] lrn = {LRN.L, LRN.R, LRN.N};

    private BinaryTree<T> randomTree(int n, int c) {
        BinaryTree node = new BinaryTree((int) (Math.random() * 1000) % 25);
        c++;
        if (c == n) return node;

        LRN d = lrn[(int) (Math.random() * 1000) % 3];
        if (d == LRN.L) {
            node.left(randomTree(n, c));
        }
        if (d == LRN.R) {
            node.right(randomTree(n, c));
        }
        return node;


    }

    public BinaryTree mirrorOf(BinaryTree node) {
        if (node == null) return node;
        BinaryTree left = mirrorOf(node.left);
        BinaryTree right = mirrorOf(node.right);
        node.left = right;
        node.right = left;
        return node;
    }


}
