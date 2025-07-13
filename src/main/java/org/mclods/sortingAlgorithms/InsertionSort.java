package org.mclods.sortingAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertionSort {
    public void applyInsertionSort(int[] arr) {
        int n = arr.length;

        for(int i=1; i<n; ++i) {
            int key = arr[i];
            int j = i-1;

            // We consider the part of array from 0 to j as sorted one and insert element at index i (or key)
            // in its correct position in the sorted array
            while(j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = key;
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int[] arr = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        new InsertionSort().applyInsertionSort(arr);

        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
