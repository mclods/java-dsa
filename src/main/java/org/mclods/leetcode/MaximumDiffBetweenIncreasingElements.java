package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/maximum-difference-between-increasing-elements/description/
public class MaximumDiffBetweenIncreasingElements {
    public int maximumDifference(int[] nums) {
        int maxDifference = -1;

        for(int i=0; i < nums.length-1; ++i) {
            int difference = -1;

            for(int j=i+1; j<nums.length; ++j) {
                if(nums[j] > nums[i] && nums[j] - nums[i] > difference) {
                    difference = nums[j] - nums[i];
                }
            }

            if(difference > maxDifference) {
                maxDifference = difference;
            }
        }

        return maxDifference;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int[] nums = new int[inputs.length];

        for(int i=0; i<inputs.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        int output = new MaximumDiffBetweenIncreasingElements().maximumDifference(nums);
        System.out.println(output);
    }
}
