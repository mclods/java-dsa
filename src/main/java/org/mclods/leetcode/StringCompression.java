package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/string-compression/description
public class StringCompression {
    public int getDigitCount(int n) {
        int digitCount = 0;

        if(n == 0) {
            return 1;
        }

        while(n > 0) {
            n /= 10;
            ++digitCount;
        }

        return digitCount;
    }

    public int compress(char[] chars) {
        char currentChar = chars[0];
        int currentCharCount = 1, charsIndex = 0;

        for(int i=1; i < chars.length; ++i) {
            if(chars[i] != currentChar) {
                chars[charsIndex++] = currentChar;

                if(currentCharCount > 1) {
                    int digits = getDigitCount(currentCharCount);

                    while(digits > 0) {
                        int decimalExp = (int)Math.pow(10, digits - 1);
                        chars[charsIndex++] = (char)(currentCharCount / decimalExp + '0');

                        currentCharCount %= decimalExp;
                        digits--;
                    }
                }

                currentChar = chars[i];
                currentCharCount = 1;
            } else {
                currentCharCount++;
            }
        }

        // Parse the last char data
        chars[charsIndex++] = currentChar;

        if(currentCharCount > 1) {
            int digits = getDigitCount(currentCharCount);

            while(digits > 0) {
                int decimalExp = (int)Math.pow(10, digits - 1);
                chars[charsIndex++] = (char)(currentCharCount / decimalExp + '0');

                currentCharCount %= decimalExp;
                digits--;
            }
        }

        return charsIndex;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        char[] chars = input.toCharArray();

        int arrLen = new StringCompression().compress(chars);
        for(int i=0; i<arrLen; ++i) {
            System.out.print(chars[i]);
        }
        System.out.println();
    }
}
