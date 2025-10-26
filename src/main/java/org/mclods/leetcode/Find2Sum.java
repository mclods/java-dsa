package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// https://leetcode.com/problems/two-sum/description/
public class Find2Sum {
    public int[] twoSum(int[] nums, int target) {
        int[] output = new int[2];
        output[0] = output[1] = -1;

        HashMap<Integer, Integer> numsMap = new HashMap<>();

        for(int i=0; i<nums.length; ++i) {
            int num1 = nums[i];
            int num2 = target - num1;

            if(numsMap.containsKey(num2)) {
                output[0] = numsMap.get(num2);
                output[1] = i;
                break;
            } else {
                numsMap.put(num1, i);
            }
        }

        return output;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int[] nums = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        int target = Integer.parseInt(br.readLine());

        int[] output = new Find2Sum().twoSum(nums, target);
        for (int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
