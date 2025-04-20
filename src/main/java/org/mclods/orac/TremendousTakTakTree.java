package org.mclods.orac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://orac.amt.edu.au/problem/331/
public class TremendousTakTakTree {
    public static void solution() throws IOException {
        int initialFruits, numFullMoons = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        initialFruits = Integer.parseInt(input);

        while((initialFruits - 1) % 11 != 0 && initialFruits <= 1000000000) {
            ++numFullMoons;
            initialFruits *= 2;
        }

        System.out.printf("%d %d", numFullMoons, initialFruits);
    }
}
