//package com.ps;
//
//public class FIndDistanceOfTree {
//
//
//    public int findDistance(TNode root, int a, int b) {
//        TNode lcp = findLeastCommonParent(root, a, b);
//
//    }
//    /*
//                                1
//                           /       \
//                         2          3
//                      /   \       /   \
//                    4     5    6       7
//                                   \
//                                    8
//     */
//
//    private TNode findLeastCommonParent(TNode root, int a, int b) {
//
//        if (root == null) return null;
//
//        if (root.v == a || root.v == b) return root;
//
//        TNode temp = findLeastCommonParent(root.left, a, b);
//
//        if(temp!=null){
//
//        }else {
//          return findLeastCommonParent(root.right, a, b);
//        }
//
//
//
//
//        temp = findLeastCommonParent(root.right, a, b);
//        if (temp != null) {
//            return findLeastCommonParent(root.left, a, b);
//        }
//        return root;
//
//    }
//
//
//    private static class TNode {
//        public int v;
//        public TNode left;
//        public TNode right;
//
//        public TNode(int v) {
//            this.v = v;
//        }
//
//
//    }
//
//}
