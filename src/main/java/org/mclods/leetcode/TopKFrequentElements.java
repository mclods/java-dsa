package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

// https://leetcode.com/problems/top-k-frequent-elements/
public class TopKFrequentElements {
    public void updateCountNumsMap(HashMap<Integer, HashSet<Integer>> map,
                                   int prevCount,
                                   int numsIndex) {
        // Remove numsIndex from prevCount key in map
        if(map.containsKey(prevCount)) {
            HashSet<Integer> prevNumsIndexes = map.get(prevCount);
            prevNumsIndexes.remove(numsIndex);
            map.put(prevCount, prevNumsIndexes);
        }

        int newCount = prevCount + 1;

        // Add numsIndex to newCount key in map
        HashSet<Integer> numsIndexes;
        if(map.containsKey(newCount)) {
            numsIndexes = map.get(newCount);
        } else {
            numsIndexes = new HashSet<>();
        }

        numsIndexes.add(numsIndex);
        map.put(newCount, numsIndexes);
    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> numsCountMap = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> countNumsMap = new HashMap<>();

        for(int i : nums) {
            if(numsCountMap.containsKey(i)) {
                updateCountNumsMap(countNumsMap, numsCountMap.get(i), i);
                numsCountMap.put(i, numsCountMap.get(i) + 1);
            } else {
                updateCountNumsMap(countNumsMap, 0, i);
                numsCountMap.put(i, 1);
            }
        }

        int index = 0;
        int[] topKFrequentNums = new int[k];
        for(int i=nums.length; i>0 && k>0; --i) {
            if(!countNumsMap.containsKey(i)) {
                continue;
            }

            HashSet<Integer> numsIndexes = countNumsMap.get(i);
            Iterator<Integer> itr = numsIndexes.iterator();
            while(itr.hasNext() && k-- > 0) {
                topKFrequentNums[index++] = itr.next();
            }
        }

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
