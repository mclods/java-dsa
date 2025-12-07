package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/unique-number-of-occurrences/description
public class UniqueNumberOfOccurrences {
    public boolean uniqueOccurrences(int[] arr) {
        int[] frequencyArr = new int[2001];

        for(int i : arr) {
            frequencyArr[i + 1000]++;
        }

        boolean hasUniqueOccurrences = true;
        Set<Integer> frequencySet = new HashSet<>();
        for(int i : frequencyArr) {
            if(i == 0) {
                continue;
            }

            if(!frequencySet.contains(i)) {
                frequencySet.add(i);
            } else {
                hasUniqueOccurrences = false;
                break;
            }
        }

        return hasUniqueOccurrences;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int[] arr = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        var output = new UniqueNumberOfOccurrences().uniqueOccurrences(arr);
        System.out.println(output);
    }
}
