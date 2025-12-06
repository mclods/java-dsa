package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/max-consecutive-ones-iii/description
public class MaxConsecutiveOnes3 {
    public int longestOnes(int[] nums, int k) {
        int start = 0, end = 0, availableFlips = k, n = nums.length, maxLen = 0;

        while(end < n) {
            int current = nums[end];

            if(current == 1) {
                int len = end - start + 1;

                if(len > maxLen) {
                    maxLen = len;
                }

                end++;
            } else {
                if(availableFlips > 0) {
                    int len = end - start + 1;

                    if(len > maxLen) {
                        maxLen = len;
                    }

                    end++;
                    availableFlips--;
                } else {
                    if(nums[start] == 0) {
                        availableFlips++;
                    }

                    start++;
                }
            }
        }

        return maxLen;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int[] nums = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        int k = Integer.parseInt(br.readLine());

        int output = new MaxConsecutiveOnes3().longestOnes(nums, k);
        System.out.println(output);
    }
}
