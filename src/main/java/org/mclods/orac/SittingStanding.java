package org.mclods.orac;

import java.util.Scanner;

// https://orac.amt.edu.au/problem/330/
public class SittingStanding {
    public static void sol() {
        int r, s, totalPeople, totalSeats, peopleSitting, peopleStanding;
        Scanner sc = new Scanner(System.in);

        r = sc.nextInt();
        s = sc.nextInt();
        totalPeople = sc.nextInt();

        totalSeats = r * s;

        if(totalPeople <= totalSeats) {
            peopleSitting = totalPeople;
            peopleStanding = 0;
        } else {
            peopleSitting = totalSeats;
            peopleStanding = totalPeople - totalSeats;
        }

        System.out.printf("%d %d", peopleSitting, peopleStanding);
    }
}
