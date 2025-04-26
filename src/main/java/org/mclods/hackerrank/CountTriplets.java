package org.mclods.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// https://www.hackerrank.com/challenges/count-triplets-1/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
public class CountTriplets {
    private static void addToMap(Map<Integer, Integer> map, Integer key) {
        if(map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] sizeInputs = br.readLine().split(" ");

        final int n = Integer.parseInt(sizeInputs[0]);
        final int r = Integer.parseInt(sizeInputs[1]);

        String[] numberInputs = br.readLine().split(" ");
        int[] numbers = new int[n];

        for(int i=0; i<n; ++i) {
            numbers[i] = Integer.parseInt(numberInputs[i]);
        }

        HashMap<Integer, Integer> duplicateNumbersCountMap = new HashMap<>();
        for(int i : numbers) {
            addToMap(duplicateNumbersCountMap, i);
        }

        HashSet<Integer> numbersSet = new HashSet<>();
        for(int i : numbers) {
            numbersSet.add(i);
        }

        int tripletCount = 0;
        HashSet<Integer> parsedNumbersSet = new HashSet<>();
        for(int current : numbers) {
            int firstTriplet = current % r == 0 ? current / r : 0;
            int thirdTriplet = current * r;

            if(parsedNumbersSet.contains(firstTriplet) &&
                    !parsedNumbersSet.contains(thirdTriplet) &&
                    numbersSet.contains(thirdTriplet)) {
                tripletCount += duplicateNumbersCountMap.get(firstTriplet) *
                        duplicateNumbersCountMap.get(thirdTriplet);
                parsedNumbersSet.add(current);
            } else {
                parsedNumbersSet.add(current);
            }
        }

        System.out.println(tripletCount);
    }
}
