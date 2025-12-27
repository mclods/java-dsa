package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/determine-if-two-strings-are-close/description
public class DetermineIfTwoStringsAreClose {
    public int find(int[] arr, int key) {
        for(int i=0; i < arr.length; ++i) {
            if(arr[i] == key) {
                return i;
            }
        }

        return -1;
    }

    public boolean closeStrings(String word1, String word2) {
        int[] w1CharCounts = new int[26],
                w2CharCounts = new int[26];

        for(int i=0; i < word1.length(); ++i) {
            w1CharCounts[word1.charAt(i) - 'a']++;
        }

        for(int i=0; i < word2.length(); ++i) {
            w2CharCounts[word2.charAt(i) - 'a']++;
        }

        boolean stringsAreClose = true;
        for(int i=0; i < 26; ++i) {
            if(w1CharCounts[i] == w2CharCounts[i]) {
                w1CharCounts[i] = w2CharCounts[i] = -1;
            } else {
                if(w1CharCounts[i] == 0 || w2CharCounts[i] == 0) {
                    stringsAreClose = false;
                    break;
                }

                int index = find(w2CharCounts, w1CharCounts[i]);

                if(index != -1) {
                    w1CharCounts[i] = w2CharCounts[index] = -1;
                } else {
                    stringsAreClose = false;
                    break;
                }
            }
        }

        return stringsAreClose;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word1 = br.readLine();
        String word2 = br.readLine();

        var output = new DetermineIfTwoStringsAreClose().closeStrings(word1, word2);
        System.out.println(output);
    }
}
