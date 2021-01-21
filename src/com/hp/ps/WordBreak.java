package com.hp.ps;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    Set<String> dictionary = new HashSet<String>();

    public void addWordInDictionary(String word) {
        dictionary.add(word);
    }

    private boolean dictionaryContains(String str) {
        return dictionary.contains(str);
    }

    public boolean wordBreak(String str) {
        int size = str.length();
        if (size == 0) return true;

        // Create the DP table to store results of subroblems. The value wb[i]
        // will be true if str[0..i-1] can be segmented into dictionary words,
        // otherwise false.
        boolean[] wb = new boolean[size + 1];

        for (int i = 1; i <= size; i++) {
            // if wb[i] is false, then check if current prefix can make it true.
            // Current prefix is "str.substr(0, i)"
            String substr = str.substring(0, i);
            if (wb[i] == false && dictionaryContains(substr)) {
                wb[i] = true;
            }


            // wb[i] is true, then check for all substrings starting from
            // (i+1)th character and store their results.
            if (wb[i] == true) {
                // If we reached the last prefix
                if (i == size)
                    return true;

                for (int j = i + 1; j <= size; j++) {
                    // Update wb[j] if it is false and can be updated
                    // Note the parameter passed to dictionaryContains() is
                    // substring starting from index 'i' and length 'j-i'
                    substr = str.substring(i, j);
                    if (wb[j] == false && dictionaryContains(substr))
                        wb[j] = true;

                    // If we reached the last character
                    if (j == size && wb[j] == true)
                        return true;
                }
            }
        }

    /* Uncomment these lines to print DP table "wb[]"
     for (int i = 1; i <= size; i++)
        cout << " " << wb[i]; */

        // If we have tried all prefixes and none of them worked
        return false;
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        wb.addWordInDictionary("mobile");
        wb.addWordInDictionary("samsung");
        wb.addWordInDictionary("sam");
        wb.addWordInDictionary("sung");
        wb.addWordInDictionary("man");
        wb.addWordInDictionary("mango");
        wb.addWordInDictionary("icecream");
        wb.addWordInDictionary("and");
        wb.addWordInDictionary("go");
        wb.addWordInDictionary("i");
        wb.addWordInDictionary("like");
        wb.addWordInDictionary("ice");
        wb.addWordInDictionary("cream");
        System.out.println(Boolean.valueOf(wb.wordBreak("likesamsung")));

    }
}
