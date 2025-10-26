package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/rectangle-overlap/description/
public class RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        int x1 = rec1[0],
                y1 = rec1[1],
                x2 = rec1[2],
                y2 = rec1[3];

        int x3 = rec2[0],
                y3 = rec2[1],
                x4 = rec2[2],
                y4 = rec2[3];

        boolean rectanglesOverlap = false;

        // Inverse of condition for non overlap (x3 > x2 || x1 > x4 || y3 > y2 || y1 > y4)
        if(x3 <= x2 && x1 <= x4 && y3 <= y2 && y1 <= y4) {
            long intersectingArea = (long)(Math.min(x2, x4) - Math.max(x1, x3)) *
                    (Math.min(y2, y4) - Math.max(y1, y3));

            if(intersectingArea > 0) {
                rectanglesOverlap = true;
            }
        }

        return rectanglesOverlap;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] rec1 = new int[4];
        int[] rec2 = new int[4];

        String[] inputs = br.readLine().split(" ");
        rec1[0] = Integer.parseInt(inputs[0]);
        rec1[1] = Integer.parseInt(inputs[1]);
        rec1[2] = Integer.parseInt(inputs[2]);
        rec1[3] = Integer.parseInt(inputs[3]);

        inputs = br.readLine().split(" ");
        rec2[0] = Integer.parseInt(inputs[0]);
        rec2[1] = Integer.parseInt(inputs[1]);
        rec2[2] = Integer.parseInt(inputs[2]);
        rec2[3] = Integer.parseInt(inputs[3]);

        boolean output = new RectangleOverlap().isRectangleOverlap(rec1, rec2);
        System.out.println(output);
    }
}
