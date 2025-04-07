package org.mclods.orac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

// https://orac.amt.edu.au/problem/340/
public class Drought {
    public static void sol() throws IOException {
        int n, c, totalRainfall = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        c = Integer.parseInt(input[1]);

        ArrayList<Integer> rainFallLevels = new ArrayList<>();
        for(int i=0; i<n; ++i) {
            rainFallLevels.add(Integer.parseInt(br.readLine()));
        }

        for(int i=0; i<n; ++i) {
            totalRainfall += rainFallLevels.get(i);

            if(totalRainfall >= c) {
                System.out.println(i + 1);
                break;
            }
        }
    }
}
