package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/find-the-pivot-integer/description/
public class FindPivotInteger {
    public int pivotInteger(int n) {
        // Sum of all integers from 1 to n
        int totalSum = (n * (n+1))/2;

        int pivot = -1, currentSum = 0;
        for(int i=1; i<=n; ++i) {
            currentSum += i;

            if(currentSum == totalSum - currentSum + i) {
                pivot = i;
                break;
            }
        }

        return pivot;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int output = new FindPivotInteger().pivotInteger(n);
        System.out.println(output);
    }
}
