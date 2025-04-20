package org.mclods.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

// https://www.hackerrank.com/challenges/ctci-ransom-note/problem?isFullScreen=true&h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=dictionaries-hashmaps
public class RansomNote {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out, true);

        String[] sizeInput = br.readLine().split(" ");

        int m = Integer.parseInt(sizeInput[0]);
        int n = Integer.parseInt(sizeInput[1]);

        String[] magazineWords = br.readLine().split(" ");
        String[] noteWords = br.readLine().split(" ");

        HashMap<String, Integer> magazineWordsMap = new HashMap<>();
        for(String word : magazineWords) {
            if(magazineWordsMap.containsKey(word)) {
                magazineWordsMap.put(word, magazineWordsMap.get(word) + 1);
            } else {
                magazineWordsMap.put(word, 1);
            }
        }

        HashMap<String, Integer> noteWordsMap = new HashMap<>();
        for(String word : noteWords) {
            if(noteWordsMap.containsKey(word)) {
                noteWordsMap.put(word, noteWordsMap.get(word) + 1);
            } else {
                noteWordsMap.put(word, 1);
            }
        }

        Set<Map.Entry<String, Integer>> noteWordsEntrySet = noteWordsMap.entrySet();
        boolean replicationPossible = true;

        for(Map.Entry<String, Integer> entry : noteWordsEntrySet) {
            if(magazineWordsMap.get(entry.getKey()) == null ||
                    magazineWordsMap.get(entry.getKey()) < entry.getValue()) {
                replicationPossible = false;
                break;
            }
        }

        pw.println(replicationPossible ? "Yes" : "No");
    }
}
