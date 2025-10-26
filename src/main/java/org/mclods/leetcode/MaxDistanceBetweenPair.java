package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/maximum-distance-between-a-pair-of-values/description/
public class MaxDistanceBetweenPair {
    public int searchPossiblePairIndex(int[] arr, int valueToSearch, int startIndex, int endIndex) {
        if(startIndex == endIndex) {
            if(arr[startIndex] <= valueToSearch) {
                return startIndex;
            } else {
                return -1;
            }
        }

        int mid = (startIndex + endIndex) / 2;
        if(arr[mid] > valueToSearch) {
            return searchPossiblePairIndex(arr, valueToSearch, mid+1, endIndex);
        } else {
            return searchPossiblePairIndex(arr, valueToSearch, startIndex, mid);
        }
    }

    public int maxDistance(int[] nums1, int[] nums2) {
        int maxPossibleDistance = 0, n1 = nums1.length, n2 = nums2.length;

        for(int j=n2-1; j>=0; j--) {
            int i = searchPossiblePairIndex(nums1, nums2[j], 0, n1-1);

            if(i != -1 && j-i > maxPossibleDistance) {
                maxPossibleDistance = j-i;
            }
        }

        return maxPossibleDistance;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int[] nums1 = new int[inputs.length];

        for(int i=0; i<inputs.length; ++i) {
            nums1[i] = Integer.parseInt(inputs[i]);
        }

        inputs = br.readLine().split(" ");
        int[] nums2 = new int[inputs.length];

        for(int i=0; i<inputs.length; ++i) {
            nums2[i] = Integer.parseInt(inputs[i]);
        }

        int output = new MaxDistanceBetweenPair().maxDistance(nums1, nums2);
        System.out.println(output);
    }
}
