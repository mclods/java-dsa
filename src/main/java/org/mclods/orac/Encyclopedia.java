package org.mclods.orac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://orac.amt.edu.au/problem/325/
public class Encyclopedia {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numberOfPagesInEncyclopedia, numberOfQuestions;
        String[] inputs = br.readLine().split(" ");

        numberOfPagesInEncyclopedia = Integer.parseInt(inputs[0]);
        numberOfQuestions = Integer.parseInt(inputs[1]);

        int[] wordsCount = new int[numberOfPagesInEncyclopedia];
        int[] outputs = new int[numberOfQuestions];

        for(int i=0; i<numberOfPagesInEncyclopedia; ++i) {
            wordsCount[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<numberOfQuestions; ++i) {
            int pageNumber = Integer.parseInt(br.readLine());
            outputs[i] = wordsCount[pageNumber - 1];
        }

        for(int i : outputs) {
            System.out.println(i);
        }
    }
}
