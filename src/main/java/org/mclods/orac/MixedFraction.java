package org.mclods.orac;

import java.util.Scanner;

// https://orac.amt.edu.au/problem/329/
public class MixedFraction {
    public static void sol() {
        int n, d, a, b;
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        d = sc.nextInt();

        a = n / d;
        b = n % d;

        if(b != 0) {
            System.out.printf("%d %d/%d\n", a, b, d);
        } else {
            System.out.println(a);
        }
    }
}
