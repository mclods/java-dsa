package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // forwardProduct[i] contains products of all numbers from 0 to i
        int[] forwardProduct = new int[n],
                // backwardProduct[i] contains products of all numbers from n-1 to i
                backwardProduct = new int[n],
                productExceptSelfArr = new int[n];

        forwardProduct[0] = nums[0];
        for(int i=1; i<n; ++i) {
            forwardProduct[i] = forwardProduct[i-1] * nums[i];
        }

        backwardProduct[n-1] = nums[n-1];
        for(int i=n-2; i>=0; --i) {
            backwardProduct[i] = backwardProduct[i+1] * nums[i];
        }

        productExceptSelfArr[0] = backwardProduct[1];
        productExceptSelfArr[n-1] = forwardProduct[n-2];
        for(int i=1; i<=n-2; ++i) {
            productExceptSelfArr[i] = forwardProduct[i-1] * backwardProduct[i+1];
        }

        return productExceptSelfArr;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int[] nums = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        int[] output = new ProductOfArrayExceptSelf().productExceptSelf(nums);
        for(int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
