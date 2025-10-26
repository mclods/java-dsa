package org.mclods.orac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://orac.amt.edu.au/problem/1415/
public class Palindrome {
    public String makePalindrome(int n, String word) {
        char[] wordArr = word.toCharArray();

        for(int i=0; i < n / 2; ++i) {
            if(wordArr[i] != wordArr[n-1-i]) {
                wordArr[i] = wordArr[n-1-i] = (char)Math.min(wordArr[i], wordArr[n-1-i]);
            }
        }

        return new String(wordArr);
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String word = br.readLine();

        String output = new Palindrome().makePalindrome(n, word);
        System.out.println(output);
    }
}
