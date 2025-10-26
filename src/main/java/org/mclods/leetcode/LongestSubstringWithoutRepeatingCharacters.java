package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String str) {
        int n = str.length();

        if(n == 0) {
            return 0;
        }

        int start = 0, end = 0, longestSubStrLength = 0;
        HashSet<Character> charSet = new HashSet<>();

        while(end < n) {
            char current = str.charAt(end);

            if(!charSet.contains(current)) {
                charSet.add(current);

                if(charSet.size() > longestSubStrLength) {
                    longestSubStrLength = charSet.size();
                }

                ++end;
            } else {
                char startingChar = str.charAt(start);
                charSet.remove(startingChar);

                ++start;
            }
        }

        return longestSubStrLength;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int output = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(input);
        System.out.println(output);
    }
}
