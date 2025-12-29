package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/equal-row-and-column-pairs/description
public class EqualRowAndColumnPairs {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowMap = new HashMap<>(),
                colMap = new HashMap<>();

        for(int i=0; i<n; ++i) {
            StringBuilder sb = new StringBuilder();

            for(int j=0; j<n; ++j) {
                sb.append(grid[i][j] + 1);
            }

            String key = sb.toString();
            rowMap.put(key, rowMap.getOrDefault(key, 0) + 1);
        }

        for(int i=0; i<n; ++i) {
            StringBuilder sb = new StringBuilder();

            for(int j=0; j<n; ++j) {
                sb.append(grid[j][i] + 1);
            }

            String key = sb.toString();
            colMap.put(key, colMap.getOrDefault(key, 0) + 1);
        }

        int pairCount = 0;
        for(var entrySet : rowMap.entrySet()) {
            pairCount += entrySet.getValue() * colMap.getOrDefault(entrySet.getKey(), 0);
        }

        return pairCount;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = (int) Math.sqrt(inputs.length), index = 0;
        int[][] grid = new int[n][n];

        for(int i=0; i<n; ++i) {
            for(int j=0; j<n; ++j) {
                grid[i][j] = Integer.parseInt(inputs[index++]);
            }
        }

        int output = new EqualRowAndColumnPairs().equalPairs(grid);
        System.out.println(output);
    }
}
