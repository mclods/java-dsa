package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/egg-drop-with-2-eggs-and-n-floors/description/
public class EggDropWith2EggsAndNFloors {
    public int twoEggDrop(int n) {
        // Follow example 2 and start from end keep increasing the gap (gap/jump between numbers) one by one until it
        // can't decrease further. The gap at that point of time represents the optimal number of attempts required.
        int gap = 1, i = n;

        while(i - gap > 0) {
            i = i - gap;
            ++gap;
        }

        return gap;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int output = new EggDropWith2EggsAndNFloors().twoEggDrop(n);
        System.out.println(output);
    }
}
