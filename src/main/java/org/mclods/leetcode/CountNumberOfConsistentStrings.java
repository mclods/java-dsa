package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/count-the-number-of-consistent-strings/description/
public class CountNumberOfConsistentStrings {
    public int countConsistentStrings(String allowed, String[] words) {
        int consistentStringsCount = 0;
        int[] allowedChars = new int[26];

        for(int i=0; i<allowed.length(); ++i) {
            allowedChars[allowed.charAt(i) - 97]++;
        }

        for (String word : words) {
            boolean wordIsConsistent = true;
            for (int j = 0; j < word.length(); ++j) {
                if (allowedChars[word.charAt(j) - 97] == 0) {
                    wordIsConsistent = false;
                    break;
                }
            }

            if (wordIsConsistent) {
                ++consistentStringsCount;
            }
        }

        return consistentStringsCount;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String allowed = br.readLine();
        String[] words = br.readLine().split(" ");

        int output = new CountNumberOfConsistentStrings().countConsistentStrings(allowed, words);
        System.out.println(output);
    }
}
