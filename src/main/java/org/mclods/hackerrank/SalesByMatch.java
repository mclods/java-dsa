package org.mclods.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// https://www.hackerrank.com/challenges/sock-merchant/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
public class SalesByMatch {
    public static void sol() throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String[] sockColors = br.readLine().split(" ");

        HashMap<String, Integer> map = new HashMap<>();
        for(String i : sockColors) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        Set<Map.Entry<String, Integer>> mapEntries = map.entrySet();

        int pairs = 0;
        for(Map.Entry<String, Integer> i : mapEntries) {
            pairs += i.getValue()/2;
        }

        System.out.println(pairs);
    }
}
