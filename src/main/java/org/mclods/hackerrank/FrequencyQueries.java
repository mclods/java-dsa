package org.mclods.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// https://www.hackerrank.com/challenges/frequency-queries/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
public class FrequencyQueries {
    private static void addToMap(Map<Integer, Integer> map, Integer key) {
        if(map.containsKey(key)) {
            map.put(key, map.get(key) + 1);
        } else {
            map.put(key, 1);
        }
    }

    private static void removeFromMap(Map<Integer, Integer> map, Integer key) {
        if(map.containsKey(key)) {
            int value = map.get(key);
            if(value > 0) {
                map.put(key, value - 1);
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);

        int q = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> dataMap = new HashMap<>();
        ArrayList<Integer> outputs = new ArrayList<>();

        for(int i=0; i<q; ++i) {
            String[] inputs = br.readLine().split(" ");
            int operation = Integer.parseInt(inputs[0]);
            int data = Integer.parseInt(inputs[1]);

            switch (operation) {
                case 1:
                    addToMap(dataMap, data);
                    break;
                case 2:
                    removeFromMap(dataMap, data);
                    break;
                case 3:
                    if(dataMap.containsValue(data)) {
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
