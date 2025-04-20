package org.mclods.orac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://orac.amt.edu.au/problem/324/
public class CountInfinity {
    public static void solution() throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; ++i) {
            System.out.println(i);
        }
    }
}
