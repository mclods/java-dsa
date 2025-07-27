package org.mclods.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.codechef.com/practice/course/google-interview-questions/GOOGLEPREP/problems/PREP19
public class TrappingRainwater {
    public long getWaterTrapped(int[] heights, int n) {
        /*
         * Water trapped in a gap i is always equal to the min of the left max height and right max height
         * minus the height of the gap itself */
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

        long waterTrapped = 0;
        for(int i=1; i<n-1; ++i) {
            waterTrapped += Math.min(leftMax[i], rightMax[i]) - heights[i];
        }

        return waterTrapped;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        long[] outputs = new long[T];

        int index = 0;
        while(index < T) {
            int n = Integer.parseInt(br.readLine());
            int[] heights = new int[n];

            String[] inputs = br.readLine().split(" ");
            for(int i=0; i<n; ++i) {
                heights[i] = Integer.parseInt(inputs[i]);
            }

            outputs[index++] = new TrappingRainwater().getWaterTrapped(heights, n);
        }

        for(long i : outputs) {
            System.out.println(i);
        }
    }
}
