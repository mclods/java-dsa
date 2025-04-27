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

        int diagonalLength = numRows - 2;
        StringBuilder output = new StringBuilder();

        for(int row = 1; row <=numRows; ++row) {
            // parseIndex is the actual string index
            int parseIndex = row - 1;

            // exact middle row exists only for odd numRows
            boolean isMiddleRow = numRows % 2 != 0 && row == (numRows / 2) + 1;

            /* increment = number of places to go down the column +
            number of places to come up the diagonal */
            /* altIncrement = number of places to go up the diagonal +
            number of places to come down the column */
            int increment = (numRows - row) * 2, altIncrement = (row - 1) * 2;

            // increment and altIncrement gets applied alternatively
            boolean applyAlt = false;

            while(parseIndex < input.length()) {
                output.append(input.charAt(parseIndex));

                // increment for starting and ending row is always fixed
                if(row == 1 || row == numRows) {
                    parseIndex += numRows + diagonalLength;
                }
                // increment for middle row is always fixed (if it exists)
                else if(isMiddleRow) {
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
