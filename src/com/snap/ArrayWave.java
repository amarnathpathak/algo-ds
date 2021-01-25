package com.snap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayWave {
    public ArrayList<Integer> wave(List<Integer> a) {
        ArrayList<Integer> result = new ArrayList<>();
        if (a == null || a.isEmpty()) {
            return result;
        }
        Collections.sort(a);
        for (int i = 0; i < a.size(); i += 2) {
            result.add(a.get(i + 1));
            result.add(a.get(i));

        }

        return result;
    }

    public ArrayList<Integer> wave(int... a) {
        ArrayList<Integer> result = new ArrayList<>();
        if (a == null || a.length==0) {
            return result;
        }
        Arrays.sort(a);
        for (int i = 0; i < a.length; i += 2) {
            result.add(a[i + 1]);
            result.add(a[i]);

        }

        return result;
    }

    public ArrayList<String> fizzBuzz(int A) {
        ArrayList<String> res = new ArrayList<String>();
        for (int i = 1; i <= A; i++) {
            if (i % 15 == 0) {
                res.add("FizzBuzz");
            } else if (i % 3 == 0) {
                res.add("Fizz");
            } else if (i % 5 == 0) {
                res.add("Buzz");
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }

}
