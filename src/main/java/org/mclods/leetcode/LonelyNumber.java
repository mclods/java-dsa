package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/find-all-lonely-numbers-in-the-array/
public class LonelyNumber {
    public List<Integer> findLonely(int[] numbers) {
        ArrayList<Integer> lonelyNumbers = new ArrayList<>();
        HashMap<Integer, Integer> numberCountMap = new HashMap<>();

        for(int i : numbers) {
            if(numberCountMap.containsKey(i)) {
                numberCountMap.put(i, numberCountMap.get(i) + 1);
            } else {
                numberCountMap.put(i, 1);
            }
        }

        for(int i : numbers) {
            if(numberCountMap.get(i) == 1 &&
                    !numberCountMap.containsKey(i -1) &&
                    !numberCountMap.containsKey(i + 1)) {
                lonelyNumbers.add(i);
            }
        }

        return lonelyNumbers;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int[] numbers = new int[inputs.length];

        for(int i=0; i< inputs.length; ++i) {
            numbers[i] = Integer.parseInt(inputs[i]);
        }

        List<Integer> outputs = new LonelyNumber().findLonely(numbers);
        for(int i : outputs) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
