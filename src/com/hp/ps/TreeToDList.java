package com.hp.ps;

import com.hp.ds.BinaryTree;

public class TreeToDList {

    public BinaryTree<Integer> convertToDList(BinaryTree<Integer> root) {

        if (root.left() != null) {
            BinaryTree left = convertToDList(root.left());
            while (left.right() != null) {
                left = left.right();
            }
            root.left(left);
            left.right(root);
        }
        if (root.right() != null) {
            BinaryTree right = convertToDList(root.right());
            while (right.left() != null) {
                right = right.left();
            }
            root.right(right);
            right.left(root);

        }
        return root;
    }
}
