package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 1) {
            return 1;
        }

        int i=1, j=1;
        while(j < nums.length) {
            if(nums[j] > nums[i-1]) {
                nums[i] = nums[j];
                ++i;
            }

            ++j;
        }

        return i;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int[] nums = new int[inputs.length];

        for(int i=0; i<nums.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        int uniqueElementCount = new RemoveDuplicatesFromSortedArray().removeDuplicates(nums);
        for(int i = 0; i< uniqueElementCount; ++i) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
