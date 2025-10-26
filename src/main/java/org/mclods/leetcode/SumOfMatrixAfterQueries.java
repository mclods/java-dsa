package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/sum-of-matrix-after-queries/description/
public class SumOfMatrixAfterQueries {
    public long matrixSumQueries(int n, int[][] queries) {
        // Create two arrays to store indexes on with rowFill and columnFill operations were already performed
        int[] rowFill = new int[n],
                colFill = new int[n];
        int emptyMatrixEntries = n * n;

        for(int i=0; i<n; ++i) {
            rowFill[i] = colFill[i] = -1;
        }

        long matrixSum = 0;

        // Queries should be parsed from end until the matrix becomes full as we only need the sum of
        // the final matrix.
        for(int i = queries.length - 1; i>=0; --i) {
            if(emptyMatrixEntries == 0) {
                break;
            }

            int type = queries[i][0],
                    index = queries[i][1],
                    value = queries[i][2];

            if(type == 0 && rowFill[index] == -1) {
                rowFill[index] = value;

                for(int j=0; j<n; ++j) {
                    if(colFill[j] == -1) {
                        matrixSum += value;
                        --emptyMatrixEntries;
                    }
                }
            } else if(type == 1 && colFill[index] == -1) {
                colFill[index] = value;

                for(int j=0; j<n; ++j) {
                    if(rowFill[j] == -1) {
                        matrixSum += value;
                        --emptyMatrixEntries;
                    }
                }
            }
        }

        return matrixSum;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int q = Integer.parseInt(br.readLine());

        int[][] queries = new int[q][3];
        for(int i=0; i<q; ++i) {
            String[] inputs = br.readLine().split(" ");

            for(int j=0; j<inputs.length; ++j) {
                queries[i][j] = Integer.parseInt(inputs[j]);
            }
        }

        long output = new SumOfMatrixAfterQueries().matrixSumQueries(n, queries);
        System.out.println(output);
    }
}
