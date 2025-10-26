package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://leetcode.com/problems/3sum/
public class Find3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> triplets = new ArrayList<>();
        HashSet<Integer> aSet = new HashSet<>();

        Arrays.sort(nums);

        for(int i=0; i<n-2; ++i) {
            int a  = nums[i], b, c, sum;

            if(aSet.contains(a)) {
                continue;
            }

            aSet.add(a);

            int j = i+1, k = n-1;
            while(j < k) {
                b = nums[j];
                c = nums[k];
                sum = a + b + c;

                if(sum == 0) {
                    triplets.add(Arrays.asList(a, b, c));

                    // Move index j to the next non-equal element
                    while(nums[++j] == b && j < k);
                } else if(sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return triplets;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int[] nums = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        List<List<Integer>> output = new Find3Sum().threeSum(nums);
        for(List<Integer> i : output) {
            for(int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
