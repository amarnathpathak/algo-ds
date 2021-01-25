package com.ps;

import java.util.ArrayList;
import java.util.List;

public class HackerrankProblem {

    public static List<Integer> getMaxStreaks(List<String> toss) {
        // Return an array of two integers containing the maximum streak of heads and tails respectively
        List<Integer> res = new ArrayList<Integer>();
        System.out.println(toss);
        int htos = 0;
        int ttos = 0;
        int i = 0;
        while (i < toss.size()) {
            String t = toss.get(i);
            int j = i;
            while (i < toss.size() && toss.get(i) == "Heads") {
                i++;
            }
            if (i - j > htos) htos = i - j;
            j = i;
            while (i < toss.size() && toss.get(i) == "Tails") {
                i++;
            }
            if (i - j > ttos) ttos = i - j;
        }
        res.add(htos);
        res.add(ttos);
        return res;


    }

    public static void main(String[] args) {
        List<String> toss = new ArrayList<String>();
        toss.add("Heads");
        toss.add("Tails");
        toss.add("Tails");
        toss.add("Tails");
        toss.add("Heads");
        toss.add("Heads");
        toss.add("Tails");
        System.out.println(getMaxStreaks(toss));


    }
}
