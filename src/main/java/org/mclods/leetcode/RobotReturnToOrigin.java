package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/robot-return-to-origin/description
public class RobotReturnToOrigin {
    public boolean judgeCircle(String moves) {
        char[] movesArr = moves.toCharArray();

        int b = 0, h = 0;
        for(char c : movesArr) {
            switch (c) {
                case 'U':
                    h++;
                    break;
                case 'D':
                    h--;
                    break;
                case 'L':
                    b--;
                    break;
                case 'R':
                    b++;
                    break;
            }
        }

        return b * b + h * h == 0;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String moves = br.readLine();
        boolean output = new RobotReturnToOrigin().judgeCircle(moves);
        System.out.println(output);
    }
}
