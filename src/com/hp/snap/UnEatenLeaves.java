package com.hp.snap;

import java.util.HashSet;

public class UnEatenLeaves {
    private static int lcm(int a, int b) {
        return a * (b / findGCD(a, b));
    }

    private static int findGCD(int number1, int number2) {
        // base case
        if (number2 == 0) {
            return number1;
        }

        return findGCD(number2, number1 % number2);
    }
    public static void main(String[] args) {
        // Read Input
        int N = 10;
        int K = 3;
        int[] A = {2,4,5 };
        System.out.println("total number of Leaves: " + N);
        System.out.println("total number of Caterpillars: " + K);
        System.out.print("Jump factor: ");
        for (int i = 0; i < K; i++) {
            System.out.print(A[i] + " ");
        }
        System.out.println();

        int balanceN = N;
        for (int i = 0; i < K; i++) {
            int gcd = A[i];
            for (int j = 0; j <= i && balanceN > 0; j++) {
                gcd = findGCD(A[j], A[i]);
                if (gcd > 1 && gcd < A[i]) {
                    break;
                }
            }
            if (gcd == A[i]) {
                balanceN = balanceN - (N / A[i]);
                HashSet<Integer> commonMultiples = new HashSet<Integer>();
                for (int j = 0; j < i; j++) {
                    int lcm = lcm(A[j], A[i]);

                    while (lcm <= N) {
                        commonMultiples.add(lcm);
                        lcm += lcm;

                    }
                }
                balanceN += commonMultiples.size();
            }

        }
        System.out.println("Balance " + balanceN);

    }

}
