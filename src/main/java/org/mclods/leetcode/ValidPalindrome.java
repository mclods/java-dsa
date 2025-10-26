package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
    public boolean isPalindrome(String input) {
        int length = 0;
        char[] inputChars = new char[input.length()];

        for(int i=0; i<input.length(); ++i) {
            char letter  = input.charAt(i);

            if((letter >= 'a' && letter <= 'z') || (letter >= '0' && letter <= '9')) {
                inputChars[length++] = letter;
            } else if(letter >= 'A' && letter <= 'Z') {
                inputChars[length++] = (char)(letter + 32);
            }
        }

        boolean checkPalindrome = true;
        for(int i=0; i < length / 2; ++i) {
            if(inputChars[i] != inputChars[length - 1 - i]) {
                checkPalindrome = false;
                break;
            }
        }

        return checkPalindrome;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        boolean output = new ValidPalindrome().isPalindrome(input);
        System.out.println(output);
    }
}
