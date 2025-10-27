package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://leetcode.com/problems/permutation-in-string/description/
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        int s1Len = s1.length();
        int[] s1Frequency = new int[26];

        for(int i=0; i < s1Len; ++i) {
            s1Frequency[s1.charAt(i) - 'a']++;
        }

        int start = 0, end = 0, s2Len = s2.length();
        boolean containsPermutation = false;
        int[] s2Frequency = new int[26];

        while(end < s2Len) {
            char current = s2.charAt(end);
            int currentCharIndex = current - 'a';
            int windowLen = end - start + 1;

            if(s2Frequency[currentCharIndex] + 1 <= s1Frequency[currentCharIndex]) {
                s2Frequency[currentCharIndex]++;

                if(windowLen == s1Len && Arrays.equals(s1Frequency, s2Frequency)) {
                    containsPermutation = true;
                    break;
                }

                end++;
            } else {
                char startChar = s2.charAt(start);
                int startCharIndex = startChar - 'a';

                if(s2Frequency[startCharIndex] > 0) {
                    s2Frequency[startCharIndex]--;
                }

                if(start == end) {
                    end++;
                }
                start++;
            }
        }

        return containsPermutation;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        boolean output = new PermutationInString().checkInclusion(s1, s2);
        System.out.println(output);
    }
}
