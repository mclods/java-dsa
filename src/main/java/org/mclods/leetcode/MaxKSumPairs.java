package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://leetcode.com/problems/max-number-of-k-sum-pairs/description
public class MaxKSumPairs {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);

        int start = 0, end = nums.length - 1, pairs = 0;
        while(start < end) {
            int sum = nums[start] + nums[end];

            if(sum == k) {
                pairs++;
                start++;
                end--;
            } else if(sum < k) {
                start++;
            } else {
                end--;
            }
        }

        return pairs;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int[] nums = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        int k = Integer.parseInt(br.readLine());

        int output = new MaxKSumPairs().maxOperations(nums, k);
        System.out.println(output);
    }
}
