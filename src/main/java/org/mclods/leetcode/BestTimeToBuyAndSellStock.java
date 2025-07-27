package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] leftMin = new int[n],
                rightMax = new int[n];

        int min = leftMin[0] = prices[0];
        for(int i=1; i<n; ++i) {
            if(prices[i] < min) {
                min = leftMin[i] = prices[i];
            } else {
                leftMin[i] = min;
            }
        }

        int max = rightMax[n-1] = prices[n-1];
        for(int i=n-2; i>=0; --i) {
            if(prices[i] > max) {
                max = rightMax[i] = prices[i];
            } else {
                rightMax[i] = max;
            }
        }

        int maxProfit = 0;
        for(int i=0; i<n; ++i) {
            if(rightMax[i] - leftMin[i] > maxProfit) {
                maxProfit = rightMax[i] - leftMin[i];
            }
        }

        return maxProfit;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int[] prices = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            prices[i] = Integer.parseInt(inputs[i]);
        }

        int output = new BestTimeToBuyAndSellStock().maxProfit(prices);
        System.out.println(output);
    }
}
