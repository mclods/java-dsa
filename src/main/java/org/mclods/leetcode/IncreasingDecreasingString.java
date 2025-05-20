package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/increasing-decreasing-string/
public class IncreasingDecreasingString {
    public String sortString(String input) {
        int[] charCount = new int[26];

        for(int i=0; i<input.length(); ++i) {
            charCount[input.charAt(i) - 97]++;
        }

        boolean parsingComplete = false;
        StringBuilder output = new StringBuilder(input.length());
        while (!parsingComplete) {
            int i=0;
            parsingComplete = true;

            while(i < charCount.length) {
                if(charCount[i] > 0) {
                    output.append((char)(i + 97));
                    charCount[i]--;
                    parsingComplete = false;
                }
                ++i;
            }

            --i;
            if(parsingComplete) {
                break;
            } else {
                parsingComplete = true;
            }

            while(i >= 0) {
                if(charCount[i] > 0) {
                    output.append((char)(i + 97));
                    charCount[i]--;
                    parsingComplete = false;
                }
                --i;
            }
        }

        return output.toString();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        String output = new IncreasingDecreasingString().sortString(input);

        System.out.println(output);
    }
}
