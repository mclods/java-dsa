package org.mclods.orac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// https://orac.amt.edu.au/problem/338/
public class Dictionary {
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int d, w;
        String[] inputs = br.readLine().split(" ");

        d = Integer.parseInt(inputs[0]);
        w = Integer.parseInt(inputs[1]);

        HashMap<Integer, Integer> dictionary = new HashMap<>(d);
        String[] outputs = new String[w];

        for(int i=0; i<d; ++i) {
            inputs = br.readLine().split(" ");

            int integerLandeseWord = Integer.parseInt(inputs[0]);
            int wholeNumberLandeseWord = Integer.parseInt(inputs[1]);
            dictionary.put(integerLandeseWord, wholeNumberLandeseWord);
        }

        for(int i=0; i<w; ++i) {
            int integerLandeseWord = Integer.parseInt(br.readLine());

            if(dictionary.containsKey(integerLandeseWord)) {
                outputs[i] = dictionary.get(integerLandeseWord).toString();
            } else {
                outputs[i] = "C?";
            }
        }

        for(String i : outputs) {
            System.out.println(i);
        }
    }
}
