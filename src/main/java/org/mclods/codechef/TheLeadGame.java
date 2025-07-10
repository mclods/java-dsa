package org.mclods.codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.codechef.com/practice/course/logical-problems/DIFF800/problems/TLG?tab=statement
public class TheLeadGame {
    public void findWinner(int[][] scores) {
        int player1TotalScore = 0,
                player2TotalScore = 0,
                maxLead = 0,
                maxLeadPlayer = -1;

        for (int[] score : scores) {
            player1TotalScore += score[0];
            player2TotalScore += score[1];

            int lead = Math.abs(player1TotalScore - player2TotalScore);
            if (lead > maxLead) {
                maxLead = lead;
                maxLeadPlayer = player1TotalScore > player2TotalScore ? 1 : 2;
            }
        }

        System.out.println(maxLeadPlayer + " " + maxLead);
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] scores = new int[n][2];

        for(int i=0; i<n; ++i) {
            String[] inputs = br.readLine().split(" ");

            scores[i][0] = Integer.parseInt(inputs[0]);
            scores[i][1] = Integer.parseInt(inputs[1]);
        }

        new TheLeadGame().findWinner(scores);
    }
}
