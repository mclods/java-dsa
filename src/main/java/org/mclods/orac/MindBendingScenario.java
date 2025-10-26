package org.mclods.orac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://orac.amt.edu.au/problem/336/
public class MindBendingScenario {
    public int area(int[][] coordinates) {
        int x1 = coordinates[0][0],
                y1 = coordinates[0][1],
                x2 = coordinates[0][2],
                y2 = coordinates[0][3];

        int x3 = coordinates[1][0],
                y3 = coordinates[1][1],
                x4 = coordinates[1][2],
                y4 = coordinates[1][3];

        int areaR1 = (x2 - x1) * (y2 - y1),
                areaR2 = (x4 - x3) * (y4 - y3);

        int totalArea = areaR1 + areaR2;

        // Inverse of condition for non overlap (x3 > x2 || x1 > x4 || y3 > y2 || y1 > y4)
        if(x3 <= x2 && x1 <= x4 && y3 <= y2 && y1 <= y4) {
            int intersectingArea = (Math.min(x2, x4) - Math.max(x1, x3)) *
                    (Math.min(y2, y4) - Math.max(y1, y3));

            totalArea = areaR1 + areaR2 - intersectingArea;
        }

        return totalArea;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] coordinates = new int[2][4];

        String[] inputs = br.readLine().split(" ");
        coordinates[0][0] = Integer.parseInt(inputs[0]);
        coordinates[0][1] = Integer.parseInt(inputs[1]);
        coordinates[0][2] = Integer.parseInt(inputs[2]);
        coordinates[0][3] = Integer.parseInt(inputs[3]);

        inputs = br.readLine().split(" ");
        coordinates[1][0] = Integer.parseInt(inputs[0]);
        coordinates[1][1] = Integer.parseInt(inputs[1]);
        coordinates[1][2] = Integer.parseInt(inputs[2]);
        coordinates[1][3] = Integer.parseInt(inputs[3]);

        int output = new MindBendingScenario().area(coordinates);
        System.out.println(output);
    }
}
