package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/shortest-completing-word/
public class FindShortestCompletingWord {
    public int[] getWordLetterCount(String word) {
        int[] wordLetterCount = new int[26];

        for(int i=0; i<word.length(); ++i) {
            char letter = word.charAt(i);

            if(letter >= 65 && letter <= 90) {
                wordLetterCount[letter-65]++;
            } else if(letter >= 97 && letter <= 122) {
                wordLetterCount[letter-97]++;
            }
        }

        return wordLetterCount;
    }

    public boolean checkIsCompletingWord(int[] licensePlateLettersCount, String word) {
        int[] wordLetterCount  = getWordLetterCount(word);

        boolean isCompletingWord = true;
        for(int i=0; i<26; ++i) {
            if(licensePlateLettersCount[i] > 0 && wordLetterCount[i] < licensePlateLettersCount[i]) {
                isCompletingWord = false;
                break;
            }
        }

        return isCompletingWord;
    }

    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licensePlateLettersCount = getWordLetterCount(licensePlate);

        String shortestCompletingWord = "";
        for (String word : words) {
            if (checkIsCompletingWord(licensePlateLettersCount, word)) {
                if(shortestCompletingWord.isEmpty()) {
                    shortestCompletingWord = word;
                } else if(word.length() < shortestCompletingWord.length()) {
                    shortestCompletingWord = word;
                }
            }
        }

        return shortestCompletingWord;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String licensePlate = br.readLine();
        String[] words = br.readLine().split(" ");

        String output = new FindShortestCompletingWord().shortestCompletingWord(licensePlate, words);
        System.out.println(output);
    }
}
