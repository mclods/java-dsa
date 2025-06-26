package org.mclods.sortingAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SelectionSort {
    public void applySelectionSort(int[] arr) {
        int n = arr.length;

        for(int i=0; i < n-1; ++i) {
            int minTillNowIndex = i;

            // Find the minimum element's index in the unsorted part of the array starting from index j
            for(int j=i+1; j<n; ++j) {
                if(arr[j] < arr[minTillNowIndex]) {
                    minTillNowIndex = j;
                }
            }

            // Swap the element at index i with the minimum element
            int temp = arr[i];
            arr[i] = arr[minTillNowIndex];
            arr[minTillNowIndex] = temp;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int[] arr = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        new SelectionSort().applySelectionSort(arr);

        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
