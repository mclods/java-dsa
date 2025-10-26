package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

// https://leetcode.com/problems/finding-3-digit-even-numbers/description/
public class Find3DigitEvenNumbers {
    public int[] findEvenNumbers(int[] digits) {
        int[] digitCounts = new int[10];

        // Create digit count array
        for (int i : digits) {
            digitCounts[i]++;
        }

        int index = 0;
        int[] evenNumbers = new int[900];

        // Parse digit count array and form numbers
        // i starts from 1 to skip making digit 0 as the first digit
        for(int i=1; i<10; ++i) {
            if(digitCounts[i] == 0) {
                continue;
            }

            // Reduce count as number with first digit i is being formed
            digitCounts[i]--;

            for(int j=0; j<10; ++j) {
                if(digitCounts[j] == 0) {
                    continue;
                }

                // Reduce count as number with second digit as j is being formed
                digitCounts[j]--;

                for(int k=0; k<10; k += 2) {
                    if(digitCounts[k] == 0) {
                        continue;
                    }

                    int number = (i * 10 + j) * 10 + k;
                    evenNumbers[index++] = number;
                }

                // Restore count as number with second digit as j has been formed
                digitCounts[j]++;
            }

            // Restore count as number with first digit i has been formed
            digitCounts[i]++;
        }

        return Arrays.copyOf(evenNumbers, index);
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int[] digits = new int[inputs.length];

        for(int i=0; i<inputs.length; ++i) {
            digits[i] = Integer.parseInt(inputs[i]);
        }

        int[] outputs = new Find3DigitEvenNumbers().findEvenNumbers(digits);
        for(int i : outputs) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
