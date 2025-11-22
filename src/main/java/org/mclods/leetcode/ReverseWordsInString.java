package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/reverse-words-in-a-string/description
public class ReverseWordsInString {
    public String reverseWords(String input) {
        int n = input.length();
        StringBuilder sb = new StringBuilder();

        int start = n-1, end = n-1;
        while(start >= 0) {
            char current = input.charAt(start);

            if(current == ' ') {
                if (end != start) {
                    String word = input.substring(start + 1, end + 1);
                    sb.append(word).append(" ");
                }
                start--;
                end = start;
            } else if(start == 0) {
                String word = input.substring(start, end + 1);
                sb.append(word).append(" ");
                start--;
                end = start;
            } else {
                start--;
            }
        }

        if(sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.toString();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String output = new ReverseWordsInString().reverseWords(input);
        System.out.println(output);
    }
}
