package org.mclods.sortingAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSort {
    public void applyBubbleSort(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n; ++i) {
            boolean elementsSwapped = false;

            for(int j=0; j < n-1-i; ++j) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    elementsSwapped = true;
                }
            }

            if(!elementsSwapped) {
                break;
            }
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int[] arr = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        new BubbleSort().applyBubbleSort(arr);

        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
