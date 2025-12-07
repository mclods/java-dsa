package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/find-the-difference-of-two-arrays/description
public class FindTheDifferenceBetweenTwoArrays {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> n1Set = new HashSet<>();
        for(int i : nums1) {
            n1Set.add(i);
        }

        Set<Integer> n2Set = new HashSet<>();
        for(int i : nums2) {
            n2Set.add(i);
        }

        List<Integer> n1MinusN2 = new ArrayList<>();
        for(int i : n1Set) {
            if(!n2Set.contains(i)) {
                n1MinusN2.add(i);
            }
        }

        List<Integer> n2MinusN1 = new ArrayList<>();
        for(int i : n2Set) {
            if(!n1Set.contains(i)) {
                n2MinusN1.add(i);
            }
        }

        List<List<Integer>> diff = new ArrayList<>();
        diff.add(n1MinusN2);
        diff.add(n2MinusN1);

        return diff;
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

        var output = new FindTheDifferenceBetweenTwoArrays().findDifference(nums1, nums2);
        System.out.println(output);
    }
}
