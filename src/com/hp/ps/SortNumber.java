package com.hp.ps;

import com.hp.ds.heap.Heap;
import com.hp.ds.heap.MaxHeap;
import com.hp.ds.heap.MinHeap;
import com.hp.ds.MyHelper;

import java.math.BigInteger;

public class SortNumber {

    public static void sort012(int a[], int n) {


        int zIndex = 0;
        int oIndex = 1;
        int tIndex = n - 1;

        int temp;
        int currentNum = a[0];
        int i = 0;
        while (i < n) {
            if (currentNum == 0) {
                a[zIndex] = currentNum;
                zIndex++;
                oIndex++;
                currentNum = a[zIndex];
                i++;
                continue;
            }
            if (currentNum == 1) {
                temp = a[oIndex];
                a[oIndex] = currentNum;
                currentNum = temp;
                oIndex++;
                i++;
                continue;
            }
            if (currentNum == 2) {
                temp = a[tIndex];
                a[tIndex] = currentNum;
                currentNum = temp;
                tIndex--;
                i++;
                continue;
            }

        }
    }

    public static int minDiff(int[] a) {
        int n = a.length;
        for (int distance = 1; distance < n; distance++) {
            for (int i = 0; i < n - distance; i++) {
                if (a[i] == a[distance + i]) {
                    return distance;
                }
            }
        }
        return -1;
    }

    public static int getStrength(String password, int weight_a) {
        // Complete the function
        //int aWheight = 97-'a' + weight_a;

        int weight = 0;
        for (char c : password.toCharArray()) {
            int w = c + weight_a - 97;
            w = w % (26);
            weight += w;
        }
        return weight;
    }

    public static void main(String[] args) {
        int[] a = {6, 7, 5, 8, 1, 7, 8};
        //MyHelper.printArray(a);
        //sort012(a, a.length);
        MyHelper.printArray(a);
        // System.out.println(minDiff(a));
        Heap minHeap = new MinHeap(a.length);
        for (int i = 0; i < a.length; i++) {
            minHeap.add(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(minHeap.poll());
        }

        System.out.println("----");
        Heap maxHeap = new MaxHeap(a.length);
        for (int i = 0; i < a.length; i++) {
            maxHeap.add(a[i]);
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(maxHeap.poll());
        }



        int n = 10;
        BigInteger bn = BigInteger.valueOf(n);
        //System.out.println(getStrength("hellomrz", 2));


    }
}
