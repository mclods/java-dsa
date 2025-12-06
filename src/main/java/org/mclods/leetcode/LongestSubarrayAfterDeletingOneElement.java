package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description
public class LongestSubarrayAfterDeletingOneElement {
    public int longestSubarray(int[] nums) {
        int start = 0, end = 0, n = nums.length, maxLen = 0, numDeletions = 1;

        while(end < n) {
            int current = nums[end];

            if(current == 1) {
                int len = end - start + 1;

                if(len > maxLen) {
                    maxLen = len;
                }

                end++;
            } else {
                if(numDeletions == 1) {
                    int len = end - start + 1;

                    if(len > maxLen) {
                        maxLen = len;
                    }

                    end++;
                    numDeletions = 0;
                } else {
                    if(nums[start] == 0) {
                        numDeletions = 1;
                    }

                    start++;
                }
            }
        }

        return maxLen - 1;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int[] nums = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        int output = new LongestSubarrayAfterDeletingOneElement().longestSubarray(nums);
        System.out.println(output);
    }
}
