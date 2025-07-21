package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWater {
    public int maxArea(int[] heights) {
        int i=0, j = heights.length-1, area = 0;

        while(i < j) {
            int currentHeight = Math.min(heights[i], heights[j]);
            int currentArea = (j - i) * currentHeight;
            if(currentArea > area) {
                area = currentArea;
            }

            if(heights[i] == currentHeight) {
                ++i;
            } else if(heights[j] == currentHeight) {
                --j;
            } else {
                ++i;
                --j;
            }
        }

        return area;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int[] heights = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            heights[i] = Integer.parseInt(inputs[i]);
        }

        int output = new ContainerWithMostWater().maxArea(heights);
        System.out.println(output);
    }
}
