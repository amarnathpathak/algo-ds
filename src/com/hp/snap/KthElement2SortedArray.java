package com.hp.snap;

public class KthElement2SortedArray {
    private int[] array1  = {};
    private int[] array2 = {};

    public KthElement2SortedArray(int[] array1, int[] array2) {
        this.array1 = array1;
        this.array2 = array2;
    }

    int kth(int s1, int s2, int end1, int end2, int k) {
        if (s1 == end1)
            return array2[k];
        if (s2 == end2)
            return array1[k];

        int mid1 = (end1 - s1) / 2;
        int mid2 = (end2 - s2) / 2;

        if (mid1 + mid2 < k) {
            if (array1[mid1] > array2[mid2])
                return kth(s1, s2 + mid2 + 1, end1, end2,
                        k - mid2 - 1);
            else
                return kth(s1 + mid1 + 1, s2, end1, end2,
                        k - mid1 - 1);
        } else {
            if (array1[mid1] > array2[mid2])
                return kth(s1, s2, s1 + mid1, end2, k);
            else
                return kth(s1, s2, end1, s2 + mid2, k);
        }
    }
    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};
        KthElement2SortedArray kth = new KthElement2SortedArray(arr1, arr2);
        int k = 5;
        System.out.println(kth.kth(0, 0, 5, 4,  k - 1));
    }

}
