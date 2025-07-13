package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        // numbers for maintaining list of all unique numbers
        int[] numbers = new int[nums.length],
                // numbersCount for maintaining count of each unique number
                numbersCount = new int[nums.length];
        int index = 0;
        HashMap<Integer, Integer> numberIndexMap = new HashMap<>();

        for (int number : nums) {
            if(numberIndexMap.containsKey(number)) {
                int numberIndex = numberIndexMap.get(number);
                numbersCount[numberIndex]++;

                // Place number in its proper place so that numbersCount[] is always in decreasing order
                while(numberIndex > 0 && numbersCount[numberIndex] > numbersCount[numberIndex-1]) {
                    // Swap and update numbers[], numbersCount[] and numberIndexMap
                    int temp = numbers[numberIndex];
                    numbers[numberIndex] = numbers[numberIndex-1];
                    numbers[numberIndex-1] = temp;

                    temp = numbersCount[numberIndex];
                    numbersCount[numberIndex] = numbersCount[numberIndex-1];
                    numbersCount[numberIndex-1] = temp;

                    numberIndexMap.put(number, numberIndex-1);
                    numberIndexMap.put(numbers[numberIndex], numberIndex);

                    --numberIndex;
                }
            } else {
                numbers[index] = number;
                numbersCount[index]++;
                numberIndexMap.put(number, index);
                ++index;
            }
        }

        int[] topKFrequentNums = new int[k];
        System.arraycopy(numbers, 0, topKFrequentNums, 0, k);

        return topKFrequentNums;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int[] nums = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        int k = Integer.parseInt(br.readLine());

        int[] output = new TopKFrequentElements().topKFrequent(nums, k);
        for(int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
