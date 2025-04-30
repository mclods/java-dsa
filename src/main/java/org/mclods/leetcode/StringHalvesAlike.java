package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringHalvesAlike {
    private static int vowelCount(char input) {
        return switch (input) {
            case 'a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U' -> 1;
            default -> 0;
        };
    }

    public boolean halvesAreAlike(String input) {
        int vowelCountFirstHalf = 0, vowelCountSecondHalf = 0;

        for(int i=0; i<input.length(); ++i) {
            if(i < input.length() / 2) {
                vowelCountFirstHalf += vowelCount(input.charAt(i));
            } else {
                vowelCountSecondHalf += vowelCount(input.charAt(i));
            }
        }

        return vowelCountFirstHalf == vowelCountSecondHalf;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        boolean output = new StringHalvesAlike().halvesAreAlike(input);
        System.out.println(output);
    }
}
