package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinEqualArraySumReplacingZeroes {
    public long minSum(int[] numArr1, int[] numArr2) {
        long numArr1Sum = 0, numArr2Sum = 0, numArr1ZeroesCount = 0, numArr2ZeroesCount = 0;

        for (int i : numArr1) {
            if (i == 0) {
                numArr1ZeroesCount++;
            }
            numArr1Sum += i;
        }
        for(int i : numArr2) {
            if(i == 0) {
                numArr2ZeroesCount++;
            }
            numArr2Sum += i;
        }

        long numArr1MaxSum = numArr1Sum + numArr1ZeroesCount,
                numArr2MaxSum = numArr2Sum + numArr2ZeroesCount;

        if(numArr1MaxSum > numArr2MaxSum && numArr2ZeroesCount != 0) {
            return numArr1MaxSum;
        } else if(numArr2MaxSum > numArr1MaxSum && numArr1ZeroesCount != 0) {
            return numArr2MaxSum;
        } else if(numArr1MaxSum == numArr2MaxSum) {
            return numArr1MaxSum;
        } else {
            return -1;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] numInputs1 = br.readLine().split(" ");
        String[] numInputs2 = br.readLine().split(" ");

        int[] numArr1 = new int[numInputs1.length];
        int[] numArr2 = new int[numInputs2.length];

        for(int i=0; i<numInputs1.length; ++i) {
            numArr1[i] = Integer.parseInt(numInputs1[i]);
        }
        for(int i=0; i<numInputs2.length; ++i) {
            numArr2[i] = Integer.parseInt(numInputs2[i]);
        }

        long output = new MinEqualArraySumReplacingZeroes().minSum(numArr1, numArr2);
        System.out.println(output);
    }
}
