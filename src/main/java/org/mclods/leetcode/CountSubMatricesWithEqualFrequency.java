package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/count-submatrices-with-equal-frequency-of-x-and-y/description/
public class CountSubMatricesWithEqualFrequency {
    public int numberOfSubmatrices(char[][] grid) {
        int subMatricesCount = 0, rowSize = grid.length, colSize = grid[0].length;

        int[][] xCounts = new int[rowSize][colSize];
        int[][] yCounts = new int[rowSize][colSize];

        switch (grid[0][0]) {
            case 'X':
                xCounts[0][0]++;
                break;
            case 'Y':
                yCounts[0][0]++;
                break;
        }

        for(int i=1; i<colSize; ++i) {
            xCounts[0][i] = xCounts[0][i-1];
            yCounts[0][i] = yCounts[0][i-1];

            switch (grid[0][i]) {
                case 'X':
                    xCounts[0][i]++;
                    break;
                case 'Y':
                    yCounts[0][i]++;
                    break;
            }

            if(xCounts[0][i] > 0 && xCounts[0][i] == yCounts[0][i]) {
                ++subMatricesCount;
            }
        }

        for(int i=1; i<rowSize; ++i) {
            xCounts[i][0] = xCounts[i-1][0];
            yCounts[i][0] = yCounts[i-1][0];

            switch (grid[i][0]) {
                case 'X':
                    xCounts[i][0]++;
                    break;
                case 'Y':
                    yCounts[i][0]++;
                    break;
            }

            if(xCounts[i][0] > 0 && xCounts[i][0] == yCounts[i][0]) {
                ++subMatricesCount;
            }
        }

        for(int i=1; i<rowSize; ++i) {
            for(int j=1; j<colSize; ++j) {
                xCounts[i][j] = xCounts[i][j-1] + xCounts[i-1][j] - xCounts[i-1][j-1];
                yCounts[i][j] = yCounts[i][j-1] + yCounts[i-1][j] - yCounts[i-1][j-1];

                switch (grid[i][j]) {
                    case 'X':
                        xCounts[i][j]++;
                        break;
                    case 'Y':
                        yCounts[i][j]++;
                        break;
                }

                if(xCounts[i][j] > 0 && xCounts[i][j] == yCounts[i][j]) {
                    ++subMatricesCount;
                }
            }
        }

        return subMatricesCount;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int rowSize = Integer.parseInt(br.readLine());
        int colSize = Integer.parseInt(br.readLine());
        char[][] grid = new char[rowSize][colSize];

        for(int i=0; i<rowSize; ++i) {
            String[] inputs = br.readLine().split(" ");
            for(int j=0; j<colSize; ++j) {
                grid[i][j] = inputs[j].charAt(0);
            }
        }

        int output = new CountSubMatricesWithEqualFrequency().numberOfSubmatrices(grid);
        System.out.println(output);
    }
}
