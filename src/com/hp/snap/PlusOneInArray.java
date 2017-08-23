package com.hp.snap;

public class PlusOneInArray {

    public int[] plusOne(int[] A) {
        int carry = 1;
        int lastIndex = 0;
        boolean set = false;
        boolean isAll9 = true;
        for (int i = A.length - 1; i >= 0; i--) {
            isAll9 = isAll9 && (A[i] == 9);
            A[i] = A[i] + carry;
            if (A[i] > 9) {
                A[i] = A[i] % 10;
                carry = 1;
            } else {
                carry = 0;
            }
            if (A[i] != 0) {
                set = false;
            }
            if (A[i] == 0 && !set) {
                lastIndex = i;
                set = true;
            }
        }
        if (isAll9) {
            int[] B = new int[A.length + 1];
            B[0] = 1;
            for (int j = 0; j < A.length; j++) {
                B[j + 1] = A[j];
            }
            return B;
        }
        if (A[0] == 0 && set) {
            int[] B = new int[A.length - lastIndex - 1];
            for (int k = 0; k < (A.length - lastIndex - 1); k++) {
                B[k] = A[lastIndex + k + 1];
            }
            return B;
        }
        return A;
    }
}
