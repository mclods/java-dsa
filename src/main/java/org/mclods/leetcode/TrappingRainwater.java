package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/trapping-rain-water/description/
public class TrappingRainwater {
    public int trap(int[] heights) {
        /*
         * Water trapped in a gap i is always equal to the min of the left max height and right max height
         * minus the height of the gap itself */
        int n = heights.length;
        int[] leftMax = new int[n],
                rightMax = new int[n];

        int leftMaxValue = leftMax[0] = heights[0];
        for(int i=1; i<n; ++i) {
            if(heights[i] > leftMaxValue) {
                leftMaxValue = leftMax[i] = heights[i];
            } else {
                leftMax[i] = leftMaxValue;
            }
        }

        int rightMaxValue = rightMax[n-1] = heights[n-1];
        for(int i=n-2; i>=0; --i) {
            if(heights[i] > rightMaxValue) {
                rightMaxValue = rightMax[i] = heights[i];
            } else {
                rightMax[i] = rightMaxValue;
            }
        }

        int waterTrapped = 0;
        for(int i=1; i<n-1; ++i) {
            waterTrapped += Math.min(leftMax[i], rightMax[i]) - heights[i];
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
