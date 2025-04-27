package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/integer-to-roman/description/
public class IntegerToRoman {
    private static StringBuilder getSymbol(int digit,
                                    char decimalPlaceSymbol,
                                    char midPlaceSymbol,
                                    char endPlaceSymbol) {
        StringBuilder symbol = new StringBuilder();

        switch(digit) {
            case 1:
                symbol.append(decimalPlaceSymbol);
                break;
            case 2:
                symbol.append(decimalPlaceSymbol)
                        .append(decimalPlaceSymbol);
                break;
            case 3:
                symbol.append(decimalPlaceSymbol)
                        .append(decimalPlaceSymbol)
                        .append(decimalPlaceSymbol);
                break;
            case 4:
                symbol.append(decimalPlaceSymbol)
                        .append(midPlaceSymbol);
                break;
            case 5:
                symbol.append(midPlaceSymbol);
                break;
            case 6:
                symbol.append(midPlaceSymbol)
                        .append(decimalPlaceSymbol);
                break;
            case 7:
                symbol.append(midPlaceSymbol)
                        .append(decimalPlaceSymbol)
                        .append(decimalPlaceSymbol);
                break;
            case 8:
                symbol.append(midPlaceSymbol)
                        .append(decimalPlaceSymbol)
                        .append(decimalPlaceSymbol)
                        .append(decimalPlaceSymbol);
                break;
            case 9:
                symbol.append(decimalPlaceSymbol)
                        .append(endPlaceSymbol);
                break;
        }

        return symbol;
    }

    public String intToRoman(int number) {
        StringBuilder romanNumeral = new StringBuilder();

        // Parse number from end and keep adding roman numeral as prefix
        int decimalPlace = 0;
        while(number > 0) {
            int digit = number % 10;
            StringBuilder symbol = new StringBuilder();
            symbol = switch (decimalPlace) {
                case 0 -> getSymbol(digit, 'I', 'V', 'X');
                case 1 -> getSymbol(digit, 'X', 'L', 'C');
                case 2 -> getSymbol(digit, 'C', 'D', 'M');
                case 3 -> getSymbol(digit, 'M', '_', '_');
                default -> symbol;
            };
            romanNumeral.insert(0, symbol);

            decimalPlace++;
            number /= 10;
        }
        
        return romanNumeral.toString();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        String output = new IntegerToRoman().intToRoman(input);
        System.out.println(output);
    }
}
