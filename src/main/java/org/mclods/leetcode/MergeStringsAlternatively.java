package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/merge-strings-alternately/description/
public class MergeStringsAlternatively {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();

        int n1 = word1.length(), n2 = word2.length(), i = 0, j = 0;
        while (i < n1 && j < n2) {
            char c1 = word1.charAt(i);
            char c2 = word2.charAt(j);

            sb.append(c1);
            sb.append(c2);

            i++;
            j++;
        }

        if(i < n1) {
            sb.append(word1.substring(i));
        }

        if(j < n2) {
            sb.append(word2.substring(j));
        }

        return sb.toString();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String word1 = br.readLine();
        String word2 = br.readLine();

        String output = new MergeStringsAlternatively().mergeAlternately(word1, word2);
        System.out.println(output);
    }
}
