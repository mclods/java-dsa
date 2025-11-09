package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/greatest-common-divisor-of-strings/description/
public class GreatestCommonDivisorOfStrings {
    public String gcdOfStrings(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();

        return "";
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        String output = new GreatestCommonDivisorOfStrings().gcdOfStrings(s1, s2);
        System.out.println(output);
    }
}
