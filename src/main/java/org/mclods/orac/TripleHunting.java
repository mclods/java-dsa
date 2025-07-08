package org.mclods.orac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://orac.amt.edu.au/problem/334/
public class TripleHunting {
    public void printTriples(int[] numbers) {
        int triplesCount = 0;
        int [] triplesIndexes = new int[numbers.length];

        for(int i=0; i<numbers.length; ++i) {
            if(numbers[i] % 3 == 0) {
                triplesIndexes[triplesCount++] = i;
            }
        }

        if(triplesCount > 0) {
            System.out.println(triplesCount);
            for(int i=0; i<triplesCount; ++i) {
                System.out.print((triplesIndexes[i] + 1) + " ");
            }
            System.out.println();
        } else {
            System.out.println("Nothing here!");
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        for(int i=0; i<n; ++i) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        new TripleHunting().printTriples(numbers);
    }
}
