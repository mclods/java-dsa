package org.mclods.orac;

import java.util.Scanner;

// https://orac.amt.edu.au/problem/332/
public class Addition {
    public static void sol() {
        int a, b, sum;
        Scanner sc = new Scanner(System.in);

        a = sc.nextInt();
        b = sc.nextInt();

        sum = a + b;

        System.out.println(sum);
    }
}
