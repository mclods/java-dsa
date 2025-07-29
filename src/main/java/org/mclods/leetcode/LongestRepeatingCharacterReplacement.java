package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String input, int k) {
        int n = input.length();

        if(n == 0 || n == 1) {
            return n;
        }

        int maxSubStrSize = 0, currentSubStrSize = 1, replacementCount = k, start = 0, end = 1;
        char subStrLetter = input.charAt(0);

        while(end < n) {
            char currentLetter = input.charAt(end);

            if(currentLetter == subStrLetter) {
                currentSubStrSize++;
                end++;
            } else {
                if(replacementCount > 0) {
                    replacementCount--;
                    currentSubStrSize++;
                    end++;
                } else {
                    while(input.charAt(start) == subStrLetter) {
                        start++;
                    }

                    subStrLetter = input.charAt(start);
                    replacementCount = k;
                    currentSubStrSize = 1;
                    end = start + 1;
                }
            }

            if(currentSubStrSize > maxSubStrSize) {
                maxSubStrSize = currentSubStrSize;
            }
        }

        return maxSubStrSize;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int k = Integer.parseInt(br.readLine());

        int output = new LongestRepeatingCharacterReplacement().characterReplacement(input, k);
        System.out.println(output);
    }
}
