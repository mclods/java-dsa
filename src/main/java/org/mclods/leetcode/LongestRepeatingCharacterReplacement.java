package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String input, int k) {
        int n = input.length();

        // Compute letter count of the input string
        int[] letterCount = new int[26];
        for(int i=0; i<n; ++i) {
            letterCount[input.charAt(i) - 'A']++;
        }

        // Find the letter with the highest count
        int maxCount = letterCount[0];
        char mostPopularLetter = 'A';
        for(int i=1; i<26; ++i) {
            if(letterCount[i] > maxCount) {
                maxCount = letterCount[i];
                mostPopularLetter = (char)('A' + i);
            }
        }

        int startIndex = 0, endIndex = 0,
                subStrLen = 0, maxSubStrLen = 0,
                replaceableCharCount = k;
        while(endIndex < n) {
            char letter = input.charAt(endIndex);

            if(letter == mostPopularLetter) {
                ++subStrLen;
                ++endIndex;
            } else {
                if(replaceableCharCount > 0) {
                    ++subStrLen;
                    --replaceableCharCount;
                    ++endIndex;
                } else {
                    // We have replaced k chars already, it's time to shift the window
                    // We'll remove the letter at startIndex from the window
                    if(subStrLen > 0) {
                        --subStrLen;
                    }

                    // If the letter at start index was replaced earlier
                    if(input.charAt(startIndex) != mostPopularLetter && k != 0) {
                        ++replaceableCharCount;
                    }

                    if(startIndex < endIndex) {
                        // Window is shrunk and moved to right
                        ++startIndex;
                    } else {
                        // Window cannot be shrunk anymore so entire window is moved to right
                        ++startIndex;
                        ++endIndex;
                    }
                }
            }

            if(subStrLen > maxSubStrLen) {
                maxSubStrLen = subStrLen;
            }
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
