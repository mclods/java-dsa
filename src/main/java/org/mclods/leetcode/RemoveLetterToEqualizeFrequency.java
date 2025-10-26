package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/remove-letter-to-equalize-frequency/
public class RemoveLetterToEqualizeFrequency {
    public boolean equalFrequency(String word) {
        int[] letterCounts = new int[26];
        int[] letterFrequencyCounts = new int[100];

        for(int i=0; i<word.length(); ++i) {
            letterCounts[word.charAt(i) - 97]++;
        }

        int mostCommonFrequency = 0, mostCommonFrequencyCount = 0;
        for(int i : letterCounts) {
            if(i == 0) {
                continue;
            }

            letterFrequencyCounts[i - 1]++;
            if(letterFrequencyCounts[i-1] > mostCommonFrequencyCount) {
                mostCommonFrequencyCount = letterFrequencyCounts[i-1];
                mostCommonFrequency = i;
            }
        }

        // All letters have same frequency
        if(mostCommonFrequency * mostCommonFrequencyCount == word.length()) {
            // Same letter is repeating multiple times. For ex: aaaa
            if(mostCommonFrequencyCount == 1) {
                return true;
            }
            // Is mostCommonFrequencyCount != 1 then it means different letters have same frequencies.
            // It's possible to equalize only if all letters have frequency == 1. For ex: abcd
            else {
                return mostCommonFrequency == 1;
            }
        } else {
            int singleDifferentFrequency = 0, temp = 0;
            for(int i : letterCounts) {
                if(i == 0 || i == mostCommonFrequency) {
                    continue;
                }

                singleDifferentFrequency = i;
                temp++;
                if(temp > 1) {
                    break;
                }
            }

            // There are more than one different frequencies so it's not possible to equalize frequency
            // Cases where there is only one different frequency repeating multiple times like
            // aabbccde = [2, 2, 2, 1, 1] also cannot be equalized
            if(temp > 1) {
                return false;
            }
            // There is a single frequency which is different
            else {
                if(Math.abs(mostCommonFrequency - singleDifferentFrequency) == 1) {
                    // There are only 2 different letters and difference between their frequencies == 1.
                    // So they can always be equalized. For ex: aaaabbb
                    if(mostCommonFrequencyCount == 1) {
                        return true;
                    }
                    // As mostCommonFrequency occurs more than once so in this case we need to remove one letter
                    // from the letter which has a different frequency. If that letter gets completely removed, or
                    // it's frequency becomes == mostCommonFrequency then only equalization is possible.
                    // For ex: aabbccd, aabbccdddd
                    else {
                        return singleDifferentFrequency - 1 == 0 ||
                                singleDifferentFrequency - 1 == mostCommonFrequency;
                    }
                }
                // Absolute difference between frequencies > 1
                else {
                    // There are only 2 different letters, and they can be equalized if either of
                    // their frequencies == 1, For ex: aaab, abbb
                    if(mostCommonFrequencyCount == 1) {
                        return mostCommonFrequency == 1 || singleDifferentFrequency == 1;
                    }
                    // As mostCommonFrequency occurs more than once so in this case we need to remove one letter
                    // from the letter which has a different frequency. Equalization is possible only if that
                    // letter is completely removed. For ex: aaabbbc
                    else {
                        return singleDifferentFrequency == 1;
                    }
                }
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word =  br.readLine();

        boolean output = new RemoveLetterToEqualizeFrequency().equalFrequency(word);
        System.out.println(output);
    }
}
