package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/find-the-highest-altitude/description
public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0, highestAltitude = 0;

        for (int j : gain) {
            currentAltitude += j;

            if (currentAltitude > highestAltitude) {
                highestAltitude = currentAltitude;
            }
        }

        return highestAltitude;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");

        int[] gain = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            gain[i] = Integer.parseInt(inputs[i]);
        }

        int output = new FindTheHighestAltitude().largestAltitude(gain);
        System.out.println(output);
    }
}
