package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/delete-columns-to-make-sorted-ii/
public class DeleteColumnsToMakeSorted2 {
    public int minDeletionSize(String[] strs) {
        int minDeletions = 0;
        int[] indexesToBeDeleted = new int[100];

        for(int i=0; i < strs.length - 1; ++i) {
            String str1 = strs[i], str2 = strs[i+1];

            for(int j=0; j<str1.length(); ++j) {
                // Skip comparison for deleted indexes
                if(indexesToBeDeleted[j] > 0) {
                    continue;
                }

                // str1 is lexicographically smaller than str2, no need to compare further
                if(str1.charAt(j) < str2.charAt(j)) {
                    break;
                } else if(str1.charAt(j) > str2.charAt(j)) {
                    indexesToBeDeleted[j]++;

                    // If any index is deleted then all strings needs to reevaluated again
                    // for ex ["vdy", "vei", "zvc", "zld"]
                    i=-1;
                }
            }
        }

        for(int i : indexesToBeDeleted) {
            if(i > 0) {
                ++minDeletions;
            }
        }

        return minDeletions;
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");

        int output = new DeleteColumnsToMakeSorted2().minDeletionSize(strs);
        System.out.println(output);
    }
}
