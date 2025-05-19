package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://leetcode.com/problems/license-key-formatting/
public class FormatLicenseKeys {
    public String licenseKeyFormatting(String input, int partLength) {
        int initCapacity = input.length() + (input.length() / partLength);
        StringBuilder rawString = new StringBuilder(initCapacity);

        // Logic to create groups is easier if string is formatted from end
        int partCount = 0;
        for(int i=input.length() - 1; i>=0; --i) {
            char currentChar = input.charAt(i);

            if(currentChar >= 97 && currentChar <= 122) {
                currentChar -= 32;
            }

            if(currentChar != '-') {
                if(partCount == partLength) {
                    rawString.insert(0, currentChar + "-");
                    partCount = 1;
                } else {
                    rawString.insert(0, currentChar);
                    ++partCount;
                }
            }
        }

        return rawString.toString();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int partLength = Integer.parseInt(br.readLine());

        String output = new FormatLicenseKeys().licenseKeyFormatting(input, partLength);
        System.out.println(output);
    }
}
