package org.mclods.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.codechef.com/practice/course/logical-problems/DIFF800/problems/DICEGAME2
public class BestOfTwo {
    public String findWinner(int[] score) {
        int A1 = score[0], A2 = score[1], A3 = score[2],
                B1 = score[3], B2 = score[4], B3 = score[5];

        int AScore = 0, BScore = 0;
        if(A1 > A2) {
            AScore += A1 + Math.max(A2, A3);
        } else {
            AScore += A2 + Math.max(A1, A3);
        }

        if(B1 > B2) {
            BScore += B1 + Math.max(B2, B3);
        } else {
            BScore += B2 + Math.max(B1, B3);
        }

        if(AScore > BScore) {
            return "Alice";
        } else if(BScore > AScore) {
            return "Bob";
        } else {
            return "Tie";
        }
    }

    public String[] findWinners(int T, int[][] scores) {
        String[] winners = new String[T];

        for(int i=0; i<T; ++i) {
            winners[i] = findWinner(scores[i]);
        }

        return winners;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][] scores = new int[T][6];

        for(int i=0; i<T; ++i) {
            String[] inputs = br.readLine().split(" ");

            scores[i][0] = Integer.parseInt(inputs[0]);
            scores[i][1] = Integer.parseInt(inputs[1]);
            scores[i][2] = Integer.parseInt(inputs[2]);
            scores[i][3] = Integer.parseInt(inputs[3]);
            scores[i][4] = Integer.parseInt(inputs[4]);
            scores[i][5] = Integer.parseInt(inputs[5]);
        }

        String[] output = new BestOfTwo().findWinners(T, scores);
        for(String i : output) {
            System.out.println(i);
        }
    }
}
