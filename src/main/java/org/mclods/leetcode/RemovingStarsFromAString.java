package org.mclods.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

// https://leetcode.com/problems/removing-stars-from-a-string
public class RemovingStarsFromAString {
    public String removeStars(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for(int i=0; i<s.length(); ++i) {
            char current = s.charAt(i);

            if(current == '*') {
                stack.poll();
            } else {
                stack.push(current);
            }
        }

        StringBuilder sb = new StringBuilder();

        Iterator<Character> dItr = stack.descendingIterator();
        while(dItr.hasNext()) {
            sb.append(dItr.next());
        }

        return sb.toString();
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String output = new RemovingStarsFromAString().removeStars(input);
        System.out.println(output);
    }
}
