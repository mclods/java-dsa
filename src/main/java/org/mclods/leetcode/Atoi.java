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
            }
            // only numbers can come after first + or - is encountered so setting readStarted = true
            else if(!readStarted && (digit == '-' || digit == '+')) {
                readStarted = true;
                isNegative = digit == '-';
            } else if(digitVal >= 0 && digitVal <= 9) {
                readStarted = true;

                // number will exceed integer limits so round it off
                if(output > 214748364) {
                    if(isNegative) {
                        output = Integer.MIN_VALUE;
                    } else {
                        output = Integer.MAX_VALUE;
                    }
                    break;
                } else if(output == 214748364) {
                    /* in digitVal >= 8, equality is needed as output is being parsed as positive integer
                    and 2147483648 cannot be stored in output. This is the case when input is -2147483648 */
                    if(isNegative && digitVal >= 8) {
                        output = Integer.MIN_VALUE;
                        break;
                    } else if(!isNegative && digitVal > 7) {
                        output = Integer.MAX_VALUE;
                        break;
                    }
                }

                output = output * 10 + digitVal;
            }
            /* if any invalid character comes parsing will stop
            and whatever was parsed till now will be returned */
            else {
                break;
            }
        }

        // don't multiply with -1 if minus sign is already present
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
