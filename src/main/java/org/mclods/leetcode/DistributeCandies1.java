package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/distribute-candies-among-children-i/description/
public class DistributeCandies1 {
    public int countWaysToDistribute(int candiesRemaining, int childrenRemaining, int limit) {
        int count = 0;

        if(childrenRemaining == 0) {
            if(candiesRemaining == 0) {
                return 1;
            } else {
                return 0;
            }
        }

        for(int i=0; i<=limit; ++i) {
            count += countWaysToDistribute(
                    candiesRemaining - i,
                    childrenRemaining - 1,
                    limit
            );
        }

        return count;
    }

    public int distributeCandies(int n, int limit) {
        return countWaysToDistribute(n, 3, limit);
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = Integer.parseInt(inputs[0]), limit = Integer.parseInt(inputs[1]);

        int output = new DistributeCandies1().distributeCandies(n, limit);
        System.out.println(output);
    }
}
