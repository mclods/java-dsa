package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/valid-anagram/description/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] sLetterCount = new int [26],
                tLetterCount = new int[26];

        for(int i=0; i<s.length(); ++i) {
            sLetterCount[s.charAt(i) - 97]++;
        }

        for(int i=0; i<t.length(); ++i) {
            tLetterCount[t.charAt(i) - 97]++;
        }

        boolean stringsAreAnagrams = true;
        for(int i=0; i<26; ++i) {
            if(sLetterCount[i] != tLetterCount[i]) {
                stringsAreAnagrams = false;
                break;
            }
        }

        return stringsAreAnagrams;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        boolean output = new ValidAnagram().isAnagram(s, t);
        System.out.println(output);
    }
}
