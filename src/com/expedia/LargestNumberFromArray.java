package com.expedia;

import java.util.Arrays;
import java.util.Comparator;

//Expedia Round 2 ~ 1
public class LargestNumberFromArray {


    int getNumberFromDigit(int firstNumber, int secondNumber) {
        int secondNumberDigit = digitCount(secondNumber);
        Double pow = Math.pow(10, secondNumberDigit);
        firstNumber = firstNumber * pow.intValue();
        return (firstNumber + secondNumber);

    }

    int digitCount(int a) {
        int count = 0;
        while (a != 0) {
            a /= 10;
            count++;
        }
        return count;
    }

    public void printLargestNumberFromIntegerArray(Integer[] arr) {

        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer X, Integer Y) {
                Integer XY = getNumberFromDigit(X, Y);
                Integer YX = getNumberFromDigit(Y, X);
                return XY.compareTo(YX);
            }
        });
        System.out.println(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }


    public static void main(String[] args) {
        LargestNumberFromArray fe = new LargestNumberFromArray();
        Integer[] arr = {3, 30, 34, 5, 9};
        fe.printLargestNumberFromIntegerArray(arr);
    }


}
