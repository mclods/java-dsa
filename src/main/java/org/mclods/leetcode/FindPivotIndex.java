package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/find-pivot-index/description
public class FindPivotIndex {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] lSum = new int[n],
                rSum = new int[n];

        int sum = 0;
        for(int i=0; i<n; ++i) {
            sum += nums[i];
            lSum[i] = sum;
        }

        sum = 0;
        for(int i=n-1; i>=0; --i) {
            sum += nums[i];
            rSum[i] = sum;
        }

        int pivotIndex = -1;
        for(int i=0; i<n; ++i) {
            if(lSum[i] == rSum[i]) {
                pivotIndex = i;
                break;
            }
        }

        return pivotIndex;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int[] nums = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        int output = new FindPivotIndex().pivotIndex(nums);
        System.out.println(output);
    }
}
