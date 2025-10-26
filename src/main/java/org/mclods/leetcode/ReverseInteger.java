package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/reverse-integer/description/
public class ReverseInteger {
    public int reverse(int n) {
        boolean isNegative = n < 0;

        if(n == Integer.MIN_VALUE) {
            return 0;
        }

        int absN = Math.abs(n), output = 0;

        while(absN > 0) {
            int digit = absN % 10;

            // integer will exceed limits stop parsing
            if(output > 214748364) {
                output = 0;
                break;
            }
            // integer will exceed limits stop parsing
            else if(output == 214748364) {
                if(isNegative && digit > 8) {
                    output = 0;
                    break;
                } else if(!isNegative && digit > 7) {
                    output = 0;
                    break;
                }
            }

            output = output * 10 + digit;
            absN /= 10;
        }

        if(isNegative) {
            output *= -1;
        }

        return output;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int output = new ReverseInteger().reverse(input);
        System.out.println(output);
    }
}
