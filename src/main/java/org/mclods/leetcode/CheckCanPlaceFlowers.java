package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/can-place-flowers/description/
public class CheckCanPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i=0; i < flowerbed.length && n > 0; ++i) {
            if(flowerbed[i] == 1) {
                continue;
            }

            boolean prevEmpty = i == 0 || flowerbed[i - 1] == 0,
                    nextEmpty = i == flowerbed.length - 1 || flowerbed[i + 1] == 0;

            if(prevEmpty && nextEmpty) {
                flowerbed[i] = 1;
                n--;
            }
        }

        return n == 0;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int[] flowerBed = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            flowerBed[i] = Integer.parseInt(inputs[i]);
        }

        int n = Integer.parseInt(br.readLine());

        boolean output = new CheckCanPlaceFlowers().canPlaceFlowers(flowerBed, n);
        System.out.println(output);
    }
}
