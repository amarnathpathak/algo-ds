package com.ps;

import com.snap.AlgoUtils;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestIncreasingSubsSequence {

    public int findLIS(int[] num) {

        int[][] LIS = new int[num.length][num.length];


        for (int i = 0; i < num.length; i++) {
            LIS[i][i] = 1;
        }
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                LIS[i][j] = LIS[i][j - 1];
                if (num[j - 1] < num[j]) {
                    LIS[i][j] = LIS[i][j] + 1;
                }
            }

        }

        return LIS[0][num.length - 1];

    }

    public int findLIS2(int[] num) {

        int[] LIS = new int[num.length];

        int max = 1;
        for (int i = 0; i < num.length; i++) {
            LIS[i] = max;
        }
        for (int i = 0; i < num.length; i++) {
            LIS[i] = 1;
            for (int j = 0; j <= i; j++) {
                if (num[i] > num[j]) {
                    LIS[i] = Math.max(LIS[i], LIS[j] + 1);
                }

            }
            if (max < LIS[i]) {
                max = LIS[i];
            }


        }

        return max;

    }

    static int findLongestConseqSubseq(int arr[], int N) {
        // add your code here
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < N; i++) {
            set.add(arr[i]);
        }
        int max = 0;
        for (int i = 0; i < N; i++) {
            if (!set.contains(arr[i] - 1)) {
                int num = arr[i];
                while (set.contains(num)) {
                    num++;
                }
                max = Math.max(max, num - arr[i]);
            }
        }
        return max;

    }

    public static void main(String[] args) {
        LongestIncreasingSubsSequence lis = new LongestIncreasingSubsSequence();
        int[] num = {2, 6, 1, 9, 4, 5, 3};
        AlgoUtils.printArray(num);

        int k =3;
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for(int i=0;i<num.length;i++){
            heap.add(num[i]);
        }
        for(int i=0;i<k;i++){
            System.out.println(heap.poll());
        }

    }
}
