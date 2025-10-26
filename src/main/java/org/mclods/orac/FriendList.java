package org.mclods.orac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://orac.amt.edu.au/problem/333/
public class FriendList {
    public void printBiggestFriendList(int[][] friends) {
        int[] friendsCount = new int[1001];
        int maxFriendsCount = 0;

        for (int[] friend : friends) {
            friendsCount[friend[0]]++;
            friendsCount[friend[1]]++;

            if(friendsCount[friend[0]] > maxFriendsCount) {
                maxFriendsCount = friendsCount[friend[0]];
            }

            if(friendsCount[friend[1]] > maxFriendsCount) {
                maxFriendsCount = friendsCount[friend[1]];
            }
        }

        for(int i=0; i<1001; ++i) {
            if(friendsCount[i] == maxFriendsCount) {
                System.out.println(i);
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int f = Integer.parseInt(br.readLine());
        int[][] friends = new int[f][2];
        for(int i=0; i<f; ++i) {
            String[] inputs = br.readLine().split(" ");
            friends[i][0] = Integer.parseInt(inputs[0]);
            friends[i][1] = Integer.parseInt(inputs[1]);
        }

        new FriendList().printBiggestFriendList(friends);
    }
}
