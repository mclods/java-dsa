package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/
public class MinOpsToMakeArrayIncreasing {
    public int minOperations(int[] inputs) {
        int minOps = 0;

        /* min number of operations needed to make any element input[i] > input[i-1]
        is input[i-1] - input[i] + 1  */
        for(int i=1; i<inputs.length; ++i) {
            if(inputs[i-1] >= inputs[i]) {
                minOps += inputs[i-1] - inputs[i] + 1;
                inputs[i] += inputs[i-1] - inputs[i] + 1;
            }
        }

        return minOps;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputStrings = br.readLine().split(" ");

        int[] inputs = new int[inputStrings.length];
        for(int i=0; i<inputStrings.length; ++i) {
            inputs[i] = Integer.parseInt(inputStrings[i]);
        }

        int output = new MinOpsToMakeArrayIncreasing().minOperations(inputs);
        System.out.println(output);
    }
}
