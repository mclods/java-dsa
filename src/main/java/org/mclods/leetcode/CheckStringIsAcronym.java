package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

// https://leetcode.com/problems/check-if-a-string-is-an-acronym-of-words/
public class CheckStringIsAcronym {
    public boolean isAcronym(List<String> words, String input) {
        StringBuilder sb = new StringBuilder(words.size());

        for(String word : words) {
            sb.append(word.charAt(0));
        }

        String acronymStr = sb.toString();
        return acronymStr.equals(input);
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] words = br.readLine().split(" ");
        String input = br.readLine();

        boolean output = new CheckStringIsAcronym().isAcronym(List.of(words), input);
        System.out.println(output);
    }
}
