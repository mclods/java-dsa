package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/string-to-integer-atoi/description/
public class Atoi {
    public int myAtoi(String input) {
        int output = 0;
        boolean isNegative = false, readStarted = false;

        for(int i=0; i<input.length(); ++i) {
            char digit = input.charAt(i);
            int digitVal = digit - 48;

            if(!readStarted && digit == ' ') {
                continue;
            } else if(!readStarted && (digit == '-' || digit == '+')) {
                readStarted = true;
                isNegative = digit == '-';
            } else if(digitVal >= 0 && digitVal <= 9) {
                readStarted = true;
                if(output > 214748364) {
                    if(isNegative) {
                        output = Integer.MIN_VALUE;
                    } else {
                        output = Integer.MAX_VALUE;
                    }
                    break;
                } else if(output == 214748364) {
                    if(isNegative && digitVal >= 8) {
                        output = Integer.MIN_VALUE;
                        break;
                    } else if(!isNegative && digitVal > 7) {
                        output = Integer.MAX_VALUE;
                        break;
                    }
                }

                output = output * 10 + digitVal;
            } else {
                break;
            }
        }

        if(isNegative && output != Integer.MIN_VALUE) {
            output *= -1;
        }

        return output;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int output = new Atoi().myAtoi(input);
        System.out.println(output);
    }
}
