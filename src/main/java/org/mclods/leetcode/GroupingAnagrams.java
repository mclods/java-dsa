package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://leetcode.com/problems/group-anagrams/
public class GroupingAnagrams {
    // Each anagram must have the same frequency count for each alphabet, so we can create a frequency count
    // hash for each word which can be like - frequency for each alphabet starting from 'a' + '$' symbol appended
    // to it to create a unique string hash. This string hash can then act as a key in our map which then
    // stores words having the same hash thus creating the anagram groups
    public static String getFrequencyHash(String word) {
        int[] letterCount = new int[26];

        for(int i=0; i<word.length(); ++i) {
            char letter = word.charAt(i);
            letterCount[letter - 'a']++;
        }

        StringBuilder frequencyHash = new StringBuilder();
        for(int i : letterCount) {
            frequencyHash.append(i).append('$');
        }

        return new String(frequencyHash);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, HashSet<Integer>> anagramGroupIndexMap = new HashMap<>();

        for(int i=0; i<strs.length; ++i) {
            String word = strs[i];
            String frequencyHash = getFrequencyHash(word);

            HashSet<Integer> indexSet;
            if(anagramGroupIndexMap.containsKey(frequencyHash)) {
                indexSet = anagramGroupIndexMap.get(frequencyHash);
            } else {
                indexSet = new HashSet<>();
            }

            indexSet.add(i);
            anagramGroupIndexMap.put(frequencyHash, indexSet);
        }

        Set<Map.Entry<String, HashSet<Integer>>> mapEntrySet = anagramGroupIndexMap.entrySet();
        List<List<String>> anagramGroups = new ArrayList<>();

        for(Map.Entry<String, HashSet<Integer>> mapEntry : mapEntrySet) {
            List<String> anagramGroup = new ArrayList<>();

            for(Integer i : mapEntry.getValue()) {
                anagramGroup.add(strs[i]);
            }

            anagramGroups.add(anagramGroup);
        }

        return anagramGroups;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        List<List<String>> output = new GroupingAnagrams().groupAnagrams(strs);
        for(List<String> i: output) {
            for(String j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
