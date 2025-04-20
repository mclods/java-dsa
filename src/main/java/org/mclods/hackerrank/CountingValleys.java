package org.mclods.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerrank.com/challenges/counting-valleys/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
public class CountingValleys {
    public static void solution() throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        String[] paths = br.readLine().split("");

        int altLevel = 0, valleys = 0;

        for(String i : paths) {
            int currentLevel = altLevel;

            if(i.equals("U")) {
                altLevel++;
            } else {
                altLevel--;
            }

            if(altLevel < 0 && currentLevel == 0) {
                valleys++;
            }
        }

        System.out.println(valleys);
    }
}
