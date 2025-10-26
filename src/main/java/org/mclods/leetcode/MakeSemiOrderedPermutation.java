package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/semi-ordered-permutation/
public class MakeSemiOrderedPermutation {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length, oneIndex = -1, nIndex = -1;

        for(int i=0; i<n; ++i) {
            if(nums[i] == 1) {
                oneIndex = i;
            } else if(nums[i] == n) {
                nIndex = i;
            }
        }

        // Calculate swaps needed to bring 1 to index 0 and n to index n-1
        int minSwapsForOne = oneIndex,
                minSwapsForN = n-1-nIndex,
                minSwapsNeeded = 0;

        if(oneIndex < nIndex) {
            minSwapsNeeded = minSwapsForOne + minSwapsForN;
        } else {
            minSwapsNeeded = minSwapsForOne + minSwapsForN - 1;
        }

        return minSwapsNeeded;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int[] nums = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        int output = new MakeSemiOrderedPermutation().semiOrderedPermutation(nums);
        System.out.println(output);
    }
}
