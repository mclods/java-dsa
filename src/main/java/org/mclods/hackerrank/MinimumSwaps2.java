package org.mclods.hackerrank;

import java.io.*;

// https://www.hackerrank.com/challenges/minimum-swaps-2/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
public class MinimumSwaps2 {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);

        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");

        int[] numberInputs = new int[n];
        int minNumber = Integer.MAX_VALUE;
        for(int i=0; i<n; ++i) {
            numberInputs[i] = Integer.parseInt(inputs[i]);
            if(numberInputs[i] < minNumber) {
                minNumber = numberInputs[i];
            }
        }

        int minSwaps = 0;
        for(int i=0; i<n;) {
            // element already in correct position
            if(minNumber + i == numberInputs[i]) {
                ++i;
            } else {
                /* swap the element to its correct index
                continue this process until the current index has correct element */
                int indexToSwap = numberInputs[i] - minNumber;
                boolean shouldIncrementIndex = numberInputs[indexToSwap] == minNumber + i;

                int temp = numberInputs[i];
                numberInputs[i] = numberInputs[indexToSwap];
                numberInputs[indexToSwap] = temp;
                ++minSwaps;

                if(shouldIncrementIndex) {
                    ++i;
                }
            }
        }

        pw.println(minSwaps);
    }
}
