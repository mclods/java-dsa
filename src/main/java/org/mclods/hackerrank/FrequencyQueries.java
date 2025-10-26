package org.mclods.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

// https://www.hackerrank.com/challenges/frequency-queries/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
public class FrequencyQueries {
    private static void addCountToMap(Map<Integer, Integer> map, Integer key) {
        if(map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    private static void removeCountFromMap(Map<Integer, Integer> map, Integer key) {
        if(map.containsKey(key)) {
            int value = map.get(key);
            if(value > 0) {
                map.put(key, value - 1);
            }
        }
    }

    private static void updateFrequencyMap(HashMap<Integer, HashSet<Integer>> map,
                                           Integer entry, Integer prevFrequency, Integer newFrequency) {
        HashSet<Integer> frequencySet;
        if(map.containsKey(newFrequency)) {
            frequencySet = map.get(newFrequency);
        } else {
            frequencySet = new HashSet<>();
        }
        frequencySet.add(entry);
        map.put(newFrequency, frequencySet);

        if(prevFrequency != null && map.containsKey(prevFrequency)) {
            map.get(prevFrequency).remove(entry);
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);

        int q = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> dataMap = new HashMap<>();

        /* maintaining a map whose keys are element frequencies and values are elements set
        helps in faster retrieval of frequency data */
        HashMap<Integer, HashSet<Integer>> frequencyMap = new HashMap<>();
        ArrayList<Integer> outputs = new ArrayList<>();

        for(int i=0; i<q; ++i) {
            String[] inputs = br.readLine().split(" ");
            int operation = Integer.parseInt(inputs[0]);
            int data = Integer.parseInt(inputs[1]);
            switch (operation) {
                case 1: {
                    Integer prevFrequency = dataMap.get(data);
                    addCountToMap(dataMap, data);
                    Integer newFrequency = dataMap.get(data);
                    updateFrequencyMap(frequencyMap, data, prevFrequency, newFrequency);
                    break;
                }
                case 2: {
                    Integer prevFrequency = dataMap.get(data);
                    removeCountFromMap(dataMap, data);
                    Integer newFrequency = dataMap.get(data);
                    updateFrequencyMap(frequencyMap, data, prevFrequency, newFrequency);
                    break;
                }
                case 3:
                    if(frequencyMap.containsKey(data) && !frequencyMap.get(data).isEmpty()) {
                        outputs.add(1);
                    } else {
                        outputs.add(0);
                    }
                    break;
            }
        }

        for(Integer i : outputs) {
            pw.println(i);
        }
    }
}
