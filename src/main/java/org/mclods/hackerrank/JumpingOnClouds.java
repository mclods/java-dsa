package org.mclods.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=warmup
public class JumpingOnClouds {
    public static void sol() throws IOException {
        int n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        String[] clouds = br.readLine().split(" ");

        int i=0, jumps = 0;
        while(i < n-1) {
            if(clouds[i].equals("0")) {
                if(i < n-2 && clouds[i+1].equals("0") && clouds[i+2].equals("0")) {
                    jumps++;
                    i += 2;
                } else {
                    jumps++;
                    i++;
                }
            } else {
                i++;
            }
        }


        System.out.println(jumps);
    }
}
