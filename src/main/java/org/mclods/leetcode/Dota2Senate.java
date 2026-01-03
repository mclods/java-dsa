package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/dota2-senate/description
public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        int n = senate.length(),
                dCount = 0, rCount = 0;

        Deque<Character> q1 = new ArrayDeque<>(),
                q2 = new ArrayDeque<>();

        for(int i=0; i<n; ++i) {
            char current = senate.charAt(i);

            if(current == 'D') {
                dCount++;
            } else {
                rCount++;
            }

            q1.add(current);
        }

        /* The best strategy for a senator to win is to remove the voting rights of the next senator (from opposite party)
        * whose turn is coming to vote in an ongoing round.
         */
        boolean q1Active = true;
        char senatorToRemove = 'X';
        int countToRemove = 0;
        while(dCount != 0 && rCount != 0) {
            if(q1Active) {
                if(!q1.isEmpty()) {
                    char senator = q1.remove();

                    if(senator == senatorToRemove) {
                        countToRemove--;
                        if(countToRemove == 0) {
                            senatorToRemove = 'X';
                        }

                        if(senator == 'D') {
                            dCount--;
                        } else {
                            rCount--;
                        }
                    } else {
                        q2.add(senator);

                       senatorToRemove = senator == 'D' ? 'R' : 'D';
                       countToRemove++;
                    }
                } else {
                    q1Active = false;
                }
            } else {
                if(!q2.isEmpty()) {
                    char senator = q2.remove();

                    if(senator == senatorToRemove) {
                        countToRemove--;
                        if(countToRemove == 0) {
                            senatorToRemove = 'X';
                        }

                        if(senator == 'D') {
                            dCount--;
                        } else {
                            rCount--;
                        }
                    } else {
                        q1.add(senator);

                        senatorToRemove = senator == 'D' ? 'R' : 'D';
                        countToRemove++;
                    }
                } else {
                    q1Active = true;
                }
            }
        }

        return dCount == 0 ? "Radiant" : "Dire";
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String senate = br.readLine();

        String output = new Dota2Senate().predictPartyVictory(senate);
        System.out.println(output);
    }
}
