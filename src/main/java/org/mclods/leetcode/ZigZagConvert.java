package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/zigzag-conversion/description/
public class ZigZagConvert {
    public String convert(String input, int numRows) {
        if(numRows == 1) {
            return input;
        }

        int diagonal = numRows - 2;
        StringBuilder output = new StringBuilder();

        for(int row = 1; row <=numRows; ++row) {
            int parseIndex = row - 1;
            boolean isMiddleRow = numRows % 2 != 0 && row == (numRows / 2) + 1;

            int increment = (numRows - row) * 2, altIncrement = (row - 1) * 2;
            boolean applyAlt = false;

            while(parseIndex < input.length()) {
                output.append(input.charAt(parseIndex));

                if(row == 1 || row == numRows) {
                    parseIndex += numRows + diagonal;
                } else if(isMiddleRow) {
                    parseIndex += increment;
                } else {
                    if(applyAlt) {
                        parseIndex += altIncrement;
                    } else {
                        parseIndex += increment;
                    }

                    applyAlt = !applyAlt;
                }
            }
        }

        return output.toString();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int numRows = Integer.parseInt(br.readLine());

        String output = new ZigZagConvert().convert(input, numRows);
        System.out.println(output);
    }
}
