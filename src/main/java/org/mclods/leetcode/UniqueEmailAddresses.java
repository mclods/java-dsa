package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

// https://leetcode.com/problems/unique-email-addresses/
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        HashSet<String> emailsSet = new HashSet<>();

        for(String email : emails) {
            char[] emailArr = email.toCharArray();
            char[] formattedEmailArr = new char[emailArr.length];

            int domainSeparatorIndex = emailArr.length - 1, formatterIndex = 0;
            boolean skipIndex = false;

            for(int i=0; i<emailArr.length; ++i) {
                if(emailArr[i] == '@') {
                    domainSeparatorIndex = i;
                    skipIndex = false;

                    formattedEmailArr[formatterIndex++] = emailArr[i];
                } else if(i > domainSeparatorIndex) {
                    formattedEmailArr[formatterIndex++] = emailArr[i];
                } else if(i < domainSeparatorIndex && !skipIndex) {
                    // we need to skip dot (.) only if it comes in local name and comes before +
                    if(emailArr[i] == '.') {
                        continue;
                    }
                    // skip everything until separator @, if + is encountered
                    else if(emailArr[i] == '+') {
                        skipIndex = true;
                    } else {
                        formattedEmailArr[formatterIndex++] = emailArr[i];
                    }
                }
            }

            emailsSet.add(new String(formattedEmailArr, 0, formatterIndex));
        }

        return emailsSet.size();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] emails = br.readLine().split(" ");
        int output = new UniqueEmailAddresses().numUniqueEmails(emails);

        System.out.println(output);
    }
}
