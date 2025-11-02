package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring {
    private int getCharIndex(char c) {
        if(c >= 65 && c <= 90) {
            return c - 'A';
        } else if(c >= 97 && c <= 122) {
            return c - 'a' + 26;
        }

        return -1;
    }

    public String minWindow(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();

        if(n2 > n1) {
            return "";
        }

        final int FREQ_ARR_LEN = 52;

        int[] s2CharFreq = new int[FREQ_ARR_LEN];
        for(int i=0; i<n2; ++i) {
            char current = s2.charAt(i);
            s2CharFreq[getCharIndex(current)]++;
        }

        // neededChars = Number of different chars in s2
        int neededChars = 0;
        for(int i : s2CharFreq) {
            if(i > 0) {
                neededChars++;
            }
        }

        int[] window = new int[FREQ_ARR_LEN];
        int start = 0, end = 0, parsedChars = 0, minWindowLen = n1 + 1;
        boolean startIsValid = false;
        String minWindowStr = "";

        while(start < n1 && end < n1) {
            if(startIsValid) {
                char endingChar = s1.charAt(end);
                int endingCharIndex = getCharIndex(endingChar);

                // s2 contains the ending character
                if(s2CharFreq[endingCharIndex] > 0) {
                    window[endingCharIndex]++;

                    if(s2CharFreq[endingCharIndex] == window[endingCharIndex]) {
                        parsedChars++;
                    }

                    // Entire string s2 has been parsed
                    if(parsedChars == neededChars) {
                        int windowLen = end - start + 1;

                        if (windowLen < minWindowLen) {
                            minWindowLen = windowLen;
                            minWindowStr = s1.substring(start, end + 1);
                        }

                        char startingChar = s1.charAt(start);
                        int startingCharIndex = getCharIndex(startingChar);

                        window[startingCharIndex]--;
                        start++;
                        startIsValid = false;
                    } else {
                        end++;
                    }
                } else {
                    end++;
                }
            } else {
                char startingChar = s1.charAt(start);
                int startingCharIndex = getCharIndex(startingChar);

                // s2 contains the starting character, reset the window
                if(s2CharFreq[startingCharIndex] > 0) {
                    parsedChars = 0;
                    end = start;
                    Arrays.fill(window, 0);

                    startIsValid = true;
                } else {
                    start++;
                }
            }
        }

        return minWindowStr;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        String output = new MinimumWindowSubstring().minWindow(s1, s2);
        System.out.println(output);
    }
}
