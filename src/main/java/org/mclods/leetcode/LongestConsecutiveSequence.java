package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        HashSet<Integer> numsSet = new HashSet<>();
        for(int i : nums) {
            numsSet.add(i);
        }

        int longestSequence = 1;
        HashSet<Integer> parsedNumsSet = new HashSet<>();
        for (int num : nums) {
            if(parsedNumsSet.contains(num)) {
                continue;
            }

            if(
                    // Check num and next elements only if a sequence > longestSequence can be created
                    numsSet.contains(num + longestSequence) &&
                            // Check sequence only if nums can be the starting element of the sequence
                            // and skip check for other elements
                            !numsSet.contains(num-1)
            ) {
                int sequence = 1;

                while(numsSet.contains(++num)) {
                    sequence++;
                    parsedNumsSet.add(num);
                }

                if(sequence > longestSequence) {
                    longestSequence = sequence;
                }
            } else {
                parsedNumsSet.add(num);
            }
        }

        return longestSequence;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        int[] nums;
        if(input.isEmpty()) {
            nums = new int[0];
        } else {
            String[] inputSplit = input.split(" ");
            nums = new int[inputSplit.length];

            for(int i=0; i<inputSplit.length; ++i) {
                nums[i] = Integer.parseInt(inputSplit[i]);
            }
        }

        int output = new LongestConsecutiveSequence().longestConsecutive(nums);
        System.out.println(output);
    }
}
