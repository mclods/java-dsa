package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class LongestRepeatingCharacterReplacement {
    int getMax(int[] arr) {
        int max = arr[0];

        for(int i=1; i < arr.length; ++i) {
            if(arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    public int characterReplacement(String input, final int k) {
        int n = input.length();

        int[] charFrequency = new int[26];
        int start = 0, end = 0, maxSubStrLen = 0, maxCharFrequency = 0;

        while(end < n) {
            char currentChar = input.charAt(end);
            int currentCharIndex = currentChar - 'A';

            charFrequency[currentCharIndex]++;

            if(charFrequency[currentCharIndex] > maxCharFrequency) {
                maxCharFrequency = charFrequency[currentCharIndex];
            }

            int windowLen = end - start + 1;

            // Check if window is valid
            if(windowLen - maxCharFrequency <= k) {
                if(windowLen > maxSubStrLen) {
                    maxSubStrLen = windowLen;
                }

            } else {
                // Move the window right. Don't shrink
                char startingChar = input.charAt(start);
                int startingCharIndex = startingChar - 'A';

                charFrequency[startingCharIndex]--;

                maxCharFrequency = getMax(charFrequency);
                ++start;
            }
            ++end;
        }

        return maxSubStrLen;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int k = Integer.parseInt(br.readLine());

        int output = new LongestRepeatingCharacterReplacement().characterReplacement(input, k);
        System.out.println(output);
    }
}
