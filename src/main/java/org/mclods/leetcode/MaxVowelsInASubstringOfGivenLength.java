package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description
public class MaxVowelsInASubstringOfGivenLength {
    public boolean isVowel(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }

    public int maxVowels(String s, int k) {
        int vowelsKLen = 0;
        for(int i=0; i<k; ++i) {
            char c = s.charAt(i);

            if(isVowel(c)) {
                vowelsKLen++;
            }
        }

        int maxVowelsKLen = vowelsKLen;
        for(int i=k; i<s.length(); ++i) {
            if(isVowel(s.charAt(i-k))) {
                vowelsKLen--;
            }

            if(isVowel(s.charAt(i))) {
                vowelsKLen++;
            }

            if(vowelsKLen > maxVowelsKLen) {
                maxVowelsKLen = vowelsKLen;
            }
        }

        return maxVowelsKLen;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int k = Integer.parseInt(br.readLine());

        int output = new MaxVowelsInASubstringOfGivenLength().maxVowels(input, k);
        System.out.println(output);
    }
}
