package org.mclods.orac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// https://orac.amt.edu.au/problem/328/
public class DishServedCold {
    public static void solution() throws IOException {
        int n, min, max, sum = 0, avg;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        ArrayList<Integer> numberInputs = new ArrayList<>(n);
        for(int i=0; i<n; ++i) {
            numberInputs.add(Integer.parseInt(br.readLine()));
        }

        min = Collections.min(numberInputs);
        max = Collections.max(numberInputs);

        for(int i: numberInputs) {
            sum += i;
        }

        avg = sum / n;

        System.out.printf("%d %d %d", min, max, avg);
    }
}
