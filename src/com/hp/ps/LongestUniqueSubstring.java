package com.hp.ps;

import java.util.Arrays;

public class LongestUniqueSubstring {
    static final int NO_OF_CHARS = 256;

    public int longestUniqueSubstring(String str) {
        int res = 0;

        int[] lastIndex = new int[NO_OF_CHARS];
        Arrays.fill(lastIndex, -1);

        int windowStartIndex = 0;

        for (int i = 0; i < str.length(); i++) {

            windowStartIndex = Math.max(windowStartIndex, lastIndex[str.charAt(i)] + 1);

            res = Math.max(res, i - windowStartIndex);

            lastIndex[str.charAt(i)] = i;
        }
        return res + 1;
    }
}
