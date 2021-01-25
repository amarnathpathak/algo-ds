package com.snap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LargestNumber {
    public String getLargest(final int[] A) {
        boolean prevZero = true;
        List<Bubble> ss = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i] != 0) {
                prevZero = false;
            }
            ss.add(new Bubble(A[i]));

        }
        if (prevZero) {
            return "0";
        }
        Collections.sort(ss, LargestNumber.NumberComparator);
        String largestNumber = "";
        for (int i = 0; i < A.length; i++) {
            largestNumber = largestNumber + ss.get(i).getNumber();
        }
        return largestNumber.trim();

    }

    public static Comparator<Bubble> NumberComparator = new Comparator<Bubble>() {

        @Override
        public int compare(Bubble o1, Bubble o2) {
            if (o1.getNumber() == o2.getNumber())
                return 0;
            if (Integer.valueOf(String.valueOf(o1.getNumber()) + String.valueOf(o2.getNumber())) > Integer
                    .valueOf(String.valueOf(o2.getNumber()) + String.valueOf(o1.getNumber())))
                return -1;
            return 1;
        }
    };

}
