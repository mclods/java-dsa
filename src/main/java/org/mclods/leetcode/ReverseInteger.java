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

        while(absN >= 10) {
            output = output * 10 + (absN % 10);
            absN /= 10;
        }

        if(output > 214748364) {
            return 0;
        } else if(output == 214748364) {
            if(isNegative && absN > 8) {
                return 0;
            } else if(!isNegative && absN > 7) {
                return 0;
            }
        }

        output = output * 10 + absN;

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
