package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// https://leetcode.com/problems/decode-string/description
public class DecodeString {
    public String decodeString(String s) {
        int n = s.length();

        ArrayDeque<String> stack = new ArrayDeque<>();

        StringBuilder decodedStr = new StringBuilder(),
                partialStr = new StringBuilder(),
                numStr = new StringBuilder();

        for(int i=0; i<n; ++i) {
            char current = s.charAt(i);

            // Append numbers and store in numStr
            if(current >= '0' && current <= '9') {
                // numbers can start coming after alphabets for ex: 3[a2[c]]
                if(!partialStr.isEmpty()) {
                    stack.push(partialStr.toString());
                    partialStr.setLength(0);
                }

                numStr.append(current);
            } else if(current == '[') {
                stack.push(numStr.toString());
                numStr.setLength(0);

                stack.push("[");
            } else if(current == ']') {
                while(!stack.isEmpty()) {
                    String top = stack.pop();

                    if(top.equals("[")) {
                        break;
                    }

                    partialStr.insert(0, top);
                }

                // It is expected that a number string is stored in the stack before "["
                int numReps = Integer.parseInt(stack.pop());
                String strToRepeat = partialStr.toString();
                partialStr.setLength(0);

                // Store partially decoded strings in the stack itself which can be appended later
                stack.push(strToRepeat.repeat(numReps));
            }
            // Case for parsing alphabets
            else {
                partialStr.append(current);
            }
        }

        // Needed for a case like 2[abc]3[cd]ef where "ef" just needs to be appended as it is
        if(!partialStr.isEmpty()) {
            stack.push(partialStr.toString());
        }

        while(!stack.isEmpty()) {
            String top = stack.pop();
            decodedStr.insert(0, top);
        }

        return decodedStr.toString();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String output = new DecodeString().decodeString(input);
        System.out.println(output);
    }
}
