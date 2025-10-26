package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/permutation-in-string/description/
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        return true;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        boolean output = new PermutationInString().checkInclusion(s1, s2);
        System.out.println(output);
    }

}
