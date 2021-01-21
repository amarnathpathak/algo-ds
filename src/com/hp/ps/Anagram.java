package com.hp.ps;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

    static int countAlteration(String str1, String str2) {
        int count = 0;
        int[] frequency = new int[26];
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        for (int i = 0; i < str1.length(); i++)
            frequency[s1[i] - 'A']++;
        for (int i = 0; i < str2.length(); i++){
            frequency[s2[i] - 'A']--;
            if (frequency[s2[i] - 'A'] < 0)
                count++;
        }
        return count;
    }

    static int countAlter(String str1, String str2) {
        int count = 0;
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        for (int i = 0; i < str1.length(); i++) {
            Character c = s1[i];
            if (!frequency.containsKey(c)) {
                frequency.put(c, 0);
            }
            int cnt = frequency.get(c);
            frequency.put(c, ++cnt);

        }
        for (int i = 0; i < str2.length(); i++){
            Character c = s2[i];
            if (!frequency.containsKey(c) || frequency.get(c) <= 0) {
                count++;
            } else {
                int cnt = frequency.get(c);
                frequency.put(c, --cnt);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String str1 = "SILLLT";
        String str2 = "LISENT";
        System.out.println(countAlteration(str1,str2));
        System.out.println(countAlter(str1,str2));
        int[][] dp = {{1,2,3},
                {4,5,6} };
        System.out.println("m: " + dp[0].length);
        System.out.println("n: " + dp.length);

    }
}
