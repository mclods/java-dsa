package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/next-permutation/description/
public class FindNextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int[] numsCount = new int[101];
        for (int i : nums) {
            numsCount[i]++;
        }

        // The nums permutation will always have a certain index after which all the numbers
        // will be in descending order. Let's call this index as breakIndex. Now all the numbers in nums before
        // breakIndex will be as it is unmodified. The number at breakIndex should be replaced
        // with the next greater number available. Then all numbers after it should be arranged in increasing
        // orders of the numbers still available.

        // Find breakIndex
        int breakIndex = 0;
        for(int i=n-2; i>=0; --i) {
            if(nums[i] < nums[i+1]) {
                breakIndex = i;
                break;
            }
        }

        // Arrange all numbers before breakIndex as it is
        for(int i=0; i<breakIndex; ++i) {
            numsCount[nums[i]]--;
        }

        // Find next greater number to be placed at breakIndex. Place it and increment breakIndex. If no greater
        // number is found breakIndex won't be incremented
        for(int i = nums[breakIndex]+1; i<101; ++i) {
            if(numsCount[i] > 0) {
                numsCount[i]--;
                nums[breakIndex++] = i;
                break;
            }
        }

        // Now set the element at breakIndex and afterward with numbers in increasing order which are still available
        for(int i = breakIndex, j=0; i<n; ++i) {
            while(numsCount[j] == 0) {
                ++j;
            }

            nums[i] = j;
            numsCount[j]--;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int[] nums = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        new FindNextPermutation().nextPermutation(nums);
        for(int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
