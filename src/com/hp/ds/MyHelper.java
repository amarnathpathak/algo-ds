package com.hp.ds;

public class MyHelper {

    public static void printArray(int[] num) {
        StringBuilder s = new StringBuilder();
        s.append(num[0]);
        for (int i = 1; i < num.length; i++) {
            s.append(", " + num[i]);

        }
        System.out.println(s);
    }


}
