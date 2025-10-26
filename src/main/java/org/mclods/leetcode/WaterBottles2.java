package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/water-bottles-ii/description/
public class WaterBottles2 {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int emptyBottles = 0, bottlesDrunk = 0;

        // Round 1 - Drink numBottles
        emptyBottles = bottlesDrunk = numBottles;

        while(emptyBottles >= numExchange) {
            // Round 2 - Exchange numExchange bottles and get 1 full bottle
            emptyBottles -= numExchange;

            // Round 3 - Drink 1 full bottle
            bottlesDrunk++;
            emptyBottles++;

            // Round 4 - Exchange numExchange bottles, get 1 full bottle and continue the cycle until no more
            // bottles can be exchanged
            numExchange++;
        }

        return bottlesDrunk;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int numBottles = Integer.parseInt(inputs[0]),
                numExchange = Integer.parseInt(inputs[1]);

        int output = new WaterBottles2().maxBottlesDrunk(numBottles, numExchange);
        System.out.println(output);
    }
}
