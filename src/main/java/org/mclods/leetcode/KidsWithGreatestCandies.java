package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/description/
public class KidsWithGreatestCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int n = candies.length;

        int maxCandies = candies[0];
        for(int i=1; i<n; ++i) {
            if(candies[i] > maxCandies) {
                maxCandies = candies[i];
            }
        }

        ArrayList<Boolean> results = new ArrayList<>(n);
        for (int candy : candies) {
            if (candy + extraCandies >= maxCandies) {
                results.add(true);
            } else {
                results.add(false);
            }
        }

        return results;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int[] candies = new int[inputs.length];
        for(int i=0; i<inputs.length; i++) {
            candies[i] = Integer.parseInt(inputs[i]);
        }

        int extraCandies = Integer.parseInt(br.readLine());

        List<Boolean> results = new KidsWithGreatestCandies().kidsWithCandies(candies, extraCandies);
        System.out.println(results);
    }
}
