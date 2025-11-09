package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;

// https://leetcode.com/problems/greatest-common-divisor-of-strings/description/
public class GreatestCommonDivisorOfStrings {
    public boolean isFactor(String factor, String original) {
        int factorLen = factor.length(),
                originalLen = original.length();

        if(originalLen % factorLen == 0) {
            StringBuilder sb = new StringBuilder(factor);

            while(sb.length() < originalLen) {
                sb.append(factor);
            }

            return sb.toString().equals(original);
        } else {
            return false;
        }
    }

    public String gcdOfStrings(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();

        LinkedHashSet<String> s1Factors = new LinkedHashSet<>();
        s1Factors.add(s1);

        for(int i=n1/2; i>=1; i--) {
            String subStr = s1.substring(0, i);

            if(isFactor(subStr, s1)) {
                s1Factors.add(subStr);
            }
        }

        LinkedHashSet<String> s2Factors = new LinkedHashSet<>();
        s2Factors.add(s2);

        for(int i=n2/2; i>=1; i--) {
            String subStr = s2.substring(0, i);

            if(isFactor(subStr, s2)) {
                s2Factors.add(subStr);
            }
        }

        String gcd = "";
        for(String i : s1Factors) {
            if(s2Factors.contains(i)) {
                gcd = i;
                break;
            }
        }
        return gcd;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s1 = br.readLine();
        String s2 = br.readLine();

        String output = new GreatestCommonDivisorOfStrings().gcdOfStrings(s1, s2);
        System.out.println(output);
    }
}
