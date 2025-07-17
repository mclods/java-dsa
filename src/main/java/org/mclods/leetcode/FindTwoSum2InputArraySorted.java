package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
public class FindTwoSum2InputArraySorted {
    public int[] twoSum(int[] numbers, int target) {
        int i=0, j=numbers.length-1;

        while(i < j) {
            int twoSum = numbers[i] + numbers[j];

            if(twoSum == target) {
                break;
            } else if(twoSum > target) {
                j--;
            } else {
                ++i;
            }
        }

        return new int[]{ i+1, j+1 };
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int[] numbers = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }

        int target = Integer.parseInt(br.readLine());

        int[] output = new FindTwoSum2InputArraySorted().twoSum(numbers, target);
        for(int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
