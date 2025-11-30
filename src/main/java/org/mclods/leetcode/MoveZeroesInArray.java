package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/move-zeroes/description/
public class MoveZeroesInArray {
    public void moveZeroes(int[] nums) {
        int start = 0, end = 0, n = nums.length;

        while(start < n && end < n) {
            if(nums[start] == 0 && nums[end] != 0) {
                if(start < end) {
                    // Swap zero and non-zero values
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;

                    start++;
                    end++;
                } else {
                    end++;
                }
                continue;
            }

            if(nums[start] != 0) {
                start++;
            }

            if(nums[end] == 0) {
                end++;
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int[] nums = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        new MoveZeroesInArray().moveZeroes(nums);
        for(int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
