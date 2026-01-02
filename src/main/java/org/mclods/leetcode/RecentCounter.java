package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/number-of-recent-calls/description
public class RecentCounter {
    Deque<Integer> pingQueue;

    public RecentCounter() {
        pingQueue = new ArrayDeque<>();
    }

    public int ping(int t) {
        pingQueue.add(t);

        int minTime = t - 3000;
        while(!pingQueue.isEmpty()) {
            int queueHead = pingQueue.peek();

            if(minTime > queueHead) {
                pingQueue.remove();
            } else {
                break;
            }
        }

        return pingQueue.size();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int n = inputs.length;
        int[] pings = new int[n];

        for(int i=0; i<n; ++i) {
            pings[i] = Integer.parseInt(inputs[i]);
        }

        int[] output = new int[n];

        RecentCounter rc = new RecentCounter();
        for(int i=0; i<n; ++i) {
            output[i] = rc.ping(pings[i]);
        }

        for(int i : output) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
