package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/asteroid-collision/description
public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;

        int[] stack = new int[n];
        int head = -1;

        int i = 0;
        while(i < n) {
            int current = asteroids[i];

            if(head == -1) {
                head++;
                stack[head] = current;
                i++;
            } else {
                int top = stack[head];

                // Condition for collision
                if(top > 0 && current < 0) {
                    int topAbs = Math.abs(top), currentAbs = Math.abs(current);

                    if(topAbs > currentAbs) {
                        i++;
                    } else if(topAbs < currentAbs) {
                        stack[head] = 0;
                        head--;
                    } else {
                        stack[head] = 0;
                        head--;
                        i++;
                    }
                } else {
                    head++;
                    stack[head] = current;
                    i++;
                }
            }
        }

        int[] output = new int[head + 1];
        System.arraycopy(stack, 0, output, 0, head + 1);

        return output;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int[] asteroids = new int[inputs.length];
        for(int i=0; i < inputs.length; ++i) {
            asteroids[i] = Integer.parseInt(inputs[i]);
        }

        int[] output = new AsteroidCollision().asteroidCollision(asteroids);
        for(int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
