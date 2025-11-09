package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/reverse-vowels-of-a-string/description/
public class ReverseVowelsOfAString {
    public boolean isVowel(char c) {
        if(c >= 97 && c <= 122) {
            c -= 32;
        }

        if(c >= 65 && c <= 90) {
            return c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
        }

        return false;
    }

    public String reverseVowels(String str) {
        StringBuilder sb = new StringBuilder(str);

        int start = 0, end = sb.length() - 1;
        while(start < end) {
            char startChar = sb.charAt(start),
                    endChar = sb.charAt(end);

            if(!isVowel(startChar)) {
                start++;
                continue;
            }

            if(!isVowel(endChar)) {
                end--;
                continue;
            }

            sb.setCharAt(start, endChar);
            sb.setCharAt(end, startChar);

            start++;
            end--;
        }

        return sb.toString();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();

        String output = new ReverseVowelsOfAString().reverseVowels(input);
        System.out.println(output);
    }
}
