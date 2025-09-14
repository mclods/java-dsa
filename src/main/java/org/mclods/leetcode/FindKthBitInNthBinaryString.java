package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/find-kth-bit-in-nth-binary-string/description/
public class FindKthBitInNthBinaryString {
    public char getInvertedBit(char bit) {
        return switch (bit) {
            case '0' -> '1';
            case '1' -> '0';
            default -> 0;
        };
    }

    public char findKthBit(int n, int k) {
        int i = 1, binaryStrLen = 1;
        while(binaryStrLen < k) {
            binaryStrLen = (int)(Math.pow(2, ++i) - 1);
        }

        StringBuilder sb = new StringBuilder(binaryStrLen);
        sb.append('0');

        for(int step = 2; step <= i; ++step) {
            int index = sb.length() - 1;

            sb.append('1');
            while(index >= 0) {
                sb.append(getInvertedBit(sb.charAt(index)));
                index--;
            }
        }

        return sb.charAt(k-1);
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]),
                k = Integer.parseInt(inputs[1]);

        char output = new FindKthBitInNthBinaryString().findKthBit(n, k);
        System.out.println(output);
    }
}
