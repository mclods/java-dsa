package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/is-subsequence/description/
public class CheckIsSubSequence {
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        for(int tIndex = 0; sIndex < s.length() && tIndex < t.length(); ++tIndex) {
            char sChar = s.charAt(sIndex),
                    tChar = t.charAt(tIndex);

            if(sChar == tChar) {
                sIndex++;
            }
        }

        return sIndex == s.length();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String t = br.readLine();

        boolean output = new CheckIsSubSequence().isSubsequence(s, t);
        System.out.println(output);
    }
}
