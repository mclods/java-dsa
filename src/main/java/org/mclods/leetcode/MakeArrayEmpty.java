package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

// https://leetcode.com/problems/make-array-empty/
public class MakeArrayEmpty {
    public long countOperationsToEmptyArray(int[] nums) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for(int i : nums) {
            linkedList.add(i);
        }

        Arrays.sort(nums);

        int minElementIndex = 0;
        long numOps = 0;

        while(!linkedList.isEmpty() && minElementIndex < nums.length) {
            if(linkedList.getFirst() == nums[minElementIndex]) {
                linkedList.removeFirst();
                ++minElementIndex;
            } else {
                int firstElement = linkedList.getFirst();
                linkedList.removeFirst();
                linkedList.addLast(firstElement);
            }

            ++numOps;
        }

        return numOps;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int[] nums = new int[inputs.length];

        for(int i=0; i<inputs.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        long output = new MakeArrayEmpty().countOperationsToEmptyArray(nums);
        System.out.println(output);
    }
}
