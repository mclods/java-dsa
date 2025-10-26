package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/sum-of-subarray-ranges/description/
public class SumOfSubArrayRanges {
    public long subArrayRanges(int[] nums) {
        long sumOfSubArrayRanges = 0;

        // Start from first index, parse elements till end one by one and recalculate min/max each time
        // then add to the sum. Start from second index and repeat the same process again
        // till we reach the second last element
        for(int i=0; i < nums.length-1; ++i) {
            int maxTillNow = nums[i], minTillNow = nums[i];

            for(int j=i+1; j < nums.length; ++j) {
                if(nums[j] > maxTillNow) {
                    maxTillNow = nums[j];
                }

                if(nums[j] < minTillNow) {
                    minTillNow = nums[j];
                }

                sumOfSubArrayRanges += maxTillNow - minTillNow;
            }
        }

        return sumOfSubArrayRanges;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int[] nums = new int[inputs.length];

        for(int i=0; i<inputs.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        long output = new SumOfSubArrayRanges().subArrayRanges(nums);
        System.out.println(output);
    }
}
