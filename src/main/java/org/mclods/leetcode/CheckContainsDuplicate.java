package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// https://leetcode.com/problems/contains-duplicate/description/
public class CheckContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();
        boolean hasDuplicate = false;

        for(int i : nums) {
            if(numsSet.contains(i)) {
                hasDuplicate = true;
                break;
            } else {
                numsSet.add(i);
            }
        }

        return hasDuplicate;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int[] nums = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        boolean output = new CheckContainsDuplicate().containsDuplicate(nums);
        System.out.println(output);
    }
}
