package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/trapping-rain-water/description/
public class TrappingRainwater {
    public int trap(int[] heights) {
        int i=0, j=heights.length-1,
                leftHeight = heights[i], rightHeight = heights[j],
                currentHeight = Math.min(leftHeight, rightHeight),
                waterTrapped = currentHeight * (j - i - 1);

        while(++i < --j) {
            waterTrapped -= currentHeight * (j - i - 1);

            if(heights[i] > leftHeight) {
                leftHeight = heights[i];
                waterTrapped -= currentHeight;
            } else {
                waterTrapped -= heights[i];
            }

            if(heights[j] > rightHeight) {
                rightHeight = heights[j];
                waterTrapped -= currentHeight;
            } else {
                waterTrapped -= heights[j];
            }

            currentHeight = Math.min(leftHeight, rightHeight);
            waterTrapped += currentHeight * (j - i - 1);
        }

        return waterTrapped;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int[] heights = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            heights[i] = Integer.parseInt(inputs[i]);
        }

        int output = new TrappingRainwater().trap(heights);
        System.out.println(output);
    }
}
