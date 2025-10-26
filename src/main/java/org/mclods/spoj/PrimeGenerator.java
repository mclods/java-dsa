package org.mclods.spoj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.spoj.com/problems/PRIME1/
public class PrimeGenerator {
    private static void printPrimes(int start, int end, List<Integer> outputs) {
        boolean[] sieve = new boolean[end];
        Arrays.fill(sieve, true);
        sieve[0] = false;

        for(int i=2; i * i <= end; ++i) {
            if(sieve[i-1]) {
                for(int j=i*i; j<=end; j += i) {
                    sieve[j-1] = false;
                }
            }
        }

        for(int i=start; i<=end; ++i) {
            if(sieve[i-1]) {
                outputs.add(i);
            }
        }
        outputs.add(-1);
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCases = Integer.parseInt(br.readLine());
        ArrayList<Integer> outputs = new ArrayList<>();
        while(testCases-- > 0) {
            String[] inputs = br.readLine().split(" ");
            printPrimes(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]), outputs);
        }

        for(int i : outputs) {
            System.out.println(i == -1 ? "" : i);
        }
    }
}
