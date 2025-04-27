package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/roman-to-integer/description/
public class RomanToInteger {
    public int romanToInt(String romanNumeral) {
        int numberOutput = 0;

        for(int i=0; i < romanNumeral.length();) {
            char numeral = romanNumeral.charAt(i);

            switch (numeral) {
                case 'M':
                    numberOutput += 1000;
                    ++i;
                    break;
                case 'D':
                    numberOutput += 500;
                    ++i;
                    break;
                case 'C':
                    // C can only come before D and M as 400 or 900, all other cases adds 100
                    if(i < romanNumeral.length() - 1) {
                        if(romanNumeral.charAt(i + 1) == 'D') {
                            numberOutput += 400;
                            i += 2;
                            break;
                        }

                        if(romanNumeral.charAt(i + 1) == 'M') {
                            numberOutput += 900;
                            i += 2;
                            break;
                        }
                    }
                    numberOutput += 100;
                    ++i;
                    break;
                case 'L':
                    numberOutput += 50;
                    ++i;
                    break;
                case 'X':
                    // X can only come before L or C as 40 or 90, all other cases adds 10
                    if(i < romanNumeral.length() - 1) {
                        if(romanNumeral.charAt(i + 1) == 'L') {
                            numberOutput += 40;
                            i += 2;
                            break;
                        }

                        if(romanNumeral.charAt(i + 1) == 'C') {
                            numberOutput += 90;
                            i += 2;
                            break;
                        }
                    }
                    numberOutput += 10;
                    ++i;
                    break;
                case 'V':
                    numberOutput += 5;
                    ++i;
                    break;
                case 'I':
                    // I can only come before V or X as 4 or 9, all other cases adds 1
                    if(i < romanNumeral.length() - 1) {
                        if(romanNumeral.charAt(i + 1) == 'V') {
                            numberOutput += 4;
                            i += 2;
                            break;
                        }

                        if(romanNumeral.charAt(i + 1) == 'X') {
                            numberOutput += 9;
                            i += 2;
                            break;
                        }
                    }
                    numberOutput += 1;
                    ++i;
                    break;
            }
        }

        return numberOutput;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int output = new RomanToInteger().romanToInt(input);
        System.out.println(output);
    }
}
