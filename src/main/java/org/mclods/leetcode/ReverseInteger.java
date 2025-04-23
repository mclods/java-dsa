package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/reverse-integer/description/
public class ReverseInteger {
    public int reverse(int n) {
        char[] inputNumber = String.valueOf(n).toCharArray();
        boolean isNegative = inputNumber[0] == '-', isStarting = true;

        long outputNumber = 0;

        if(isNegative) {
            for(int i = inputNumber.length-1; i>0; --i) {
                if(isStarting && inputNumber[i] != '0') {
                    isStarting = false;
                }

                if(isStarting && inputNumber[i] == '0') {
                    continue;
                }

                long digit =  (long)((inputNumber[i] - 48) * Math.pow(10, i-1));
                outputNumber += digit;

                if(outputNumber > Integer.MAX_VALUE) {
                    outputNumber = 0;
                    break;
                }
            }

            outputNumber *= -1;
        } else {
            for(int i = inputNumber.length-1; i>=0; --i) {
                if(isStarting && inputNumber[i] != '0') {
                    isStarting = false;
                }

                if(isStarting && inputNumber[i] == '0') {
                    continue;
                }

                long digit =  (long)((inputNumber[i] - 48) * Math.pow(10, i));
                outputNumber += digit;

                if(outputNumber > Integer.MAX_VALUE) {
                    outputNumber = 0;
                    break;
                }
            }
        }

        return (int)outputNumber;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int output = new ReverseInteger().reverse(input);
        System.out.println(output);
    }
}
