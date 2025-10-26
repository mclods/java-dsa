package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/palindrome-number/description/
public class Palindrome {
    public boolean isPalindrome(int number) {
        if(number < 0) {
            return false;
        }

        int reversedNumber = 0, numCopy = number;

        while(numCopy > 0) {
            int lastDigit = numCopy % 10;

            // reversedNumber will exceed integer limit, no need to reverse it further
            if(reversedNumber > 214748364) {
                break;
            }
            // reversedNumber will exceed integer limit, no need to reverse it further
            else if(reversedNumber == 214748364 && lastDigit > 7) {
                break;
            } else {
                reversedNumber = reversedNumber * 10 + lastDigit;
                numCopy /= 10;
            }
        }

        return number == reversedNumber;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        boolean output = new Palindrome().isPalindrome(input);
        System.out.println(output);
    }
}
