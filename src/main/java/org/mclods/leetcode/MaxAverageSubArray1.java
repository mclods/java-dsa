package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/maximum-average-subarray-i/description
public class MaxAverageSubArray1 {
    public double findMaxAverage(int[] nums, int k) {
        int kLenSum = 0;
        for(int i=0; i<k; ++i) {
            kLenSum += nums[i];
        }

        int maxKLenSum = kLenSum;
        for(int i=k; i<nums.length; ++i) {
            kLenSum = kLenSum - nums[i-k] + nums[i];

            if(kLenSum > maxKLenSum) {
                maxKLenSum = kLenSum;
            }
        }

        return (double)maxKLenSum / k;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int[] nums = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        int k = Integer.parseInt(br.readLine());

        double output = new MaxAverageSubArray1().findMaxAverage(nums, k);
        System.out.println(output);
    }
}
