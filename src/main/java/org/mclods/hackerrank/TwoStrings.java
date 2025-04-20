package org.mclods.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;

// https://www.hackerrank.com/challenges/two-strings/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
public class TwoStrings {
    private static boolean checkCommonSubstring(char[] inputA, char[] inputB) {
        HashSet<Character> characterSetA = new HashSet<>();
        for(char i : inputA) {
            characterSetA.add(i);
        }

        boolean hasCommonSubstring = false;
        for(char i : inputB) {
            if(characterSetA.contains(i)) {
                hasCommonSubstring = true;
                break;
            }
        }

        return hasCommonSubstring;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);

        int p = Integer.parseInt(br.readLine());
        String[] outputs = new String[p];

        for(int i=0; i<p; ++i) {
            char[] inputA = br.readLine().toCharArray();
            char[] inputB = br.readLine().toCharArray();

            boolean hasCommonSubstring = checkCommonSubstring(inputA, inputB);
            outputs[i] = hasCommonSubstring ? "YES" : "NO";
        }

        for(String output: outputs) {
            pw.println(output);
        }
    }
}
