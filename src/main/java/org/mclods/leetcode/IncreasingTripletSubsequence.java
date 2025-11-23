package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/increasing-triplet-subsequence/description
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] maxNumsFromEnd = new int[n];

        int maxNum = maxNumsFromEnd[n-1] = nums[n-1];
        for(int i=n-2; i>=0; --i) {
            if(nums[i] > maxNum) {
                maxNum = maxNumsFromEnd[i] = nums[i];
            } else {
                maxNumsFromEnd[i] = maxNum;
            }
        }

        int firstTriplet = nums[0];
        boolean tripletExists = false;
        for(int i=0; i<n; ++i) {
            if(nums[i] != maxNumsFromEnd[i]) {
                if(nums[i] > firstTriplet) {
                    tripletExists = true;
                    break;
                } else if(nums[i] < firstTriplet) {
                    firstTriplet = nums[i];
                }
            }
        }

        return tripletExists;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int[] nums = new int[inputs.length];
        for(int i=0; i<inputs.length; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        boolean output = new IncreasingTripletSubsequence().increasingTriplet(nums);
        System.out.println(output);
    }
}
