package org.mclods.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// https://www.hackerrank.com/challenges/count-triplets-1/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
public class CountTriplets {
    private static void addToMap(Map<Integer, Integer> map, Integer key) {
        if(map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 0);
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);

        String[] sizeInputs = br.readLine().split(" ");

        final int n = Integer.parseInt(sizeInputs[0]);
        final int r = Integer.parseInt(sizeInputs[1]);

        String[] numberInputs = br.readLine().split(" ");
        int[] numbers = new int[n];

        for(int i=0; i<n; ++i) {
            numbers[i] = Integer.parseInt(numberInputs[i]);
        }

        HashMap<Integer, Integer> duplicateNumbersMap = new HashMap<>();
        for(int i : numbers) {
            addToMap(duplicateNumbersMap, i);
        }

        HashSet<Integer> numbersSet = new HashSet<>();
        for(int i : numbers) {
            numbersSet.add(i);
        }

        int tripletCount = 0;
        HashSet<Integer> parsedNumbersSet = new HashSet<>();
        HashMap<Integer, Integer> parsedDuplicateNumbersMap = new HashMap<>();
        for(int current : numbers) {
            int firstTriplet = current % r == 0 ? current / r : 0;
            int thirdTriplet = current * r;

            if(parsedNumbersSet.contains(firstTriplet) &&
                    numbersSet.contains(thirdTriplet) &&
                    !parsedNumbersSet.contains(thirdTriplet)) {
                tripletCount++;

                if(parsedDuplicateNumbersMap.containsKey(firstTriplet) &&
                        parsedDuplicateNumbersMap.get(firstTriplet) > 0) {
                    tripletCount += parsedDuplicateNumbersMap.get(firstTriplet);
                }

                if(duplicateNumbersMap.containsKey(thirdTriplet) &&
                        duplicateNumbersMap.get(thirdTriplet) > 0) {
                    tripletCount += duplicateNumbersMap.get(thirdTriplet);
                }

                parsedNumbersSet.add(current);
                addToMap(parsedDuplicateNumbersMap, current);
            } else {
                parsedNumbersSet.add(current);
                addToMap(parsedDuplicateNumbersMap, current);
            }
        }

        pw.println(tripletCount);
    }
}
