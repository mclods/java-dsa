package org.mclods.sortingAlgorithms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
    public void merge(int[] arr, int startIndex, int midIndex, int endIndex) {
        // Create 2 separate arrays (arr1 & arr2) one from startIndex to midIndex
        // and other from midIndex + 1 to endIndex and copy elements from the original array arr into arr1 & arr2
        int arr1Length = midIndex - startIndex + 1,
                arr2Length = endIndex - midIndex;

        int[] arr1 = new int[arr1Length],
                arr2 = new int[arr2Length];

        System.arraycopy(arr, startIndex, arr1, 0, arr1Length);
        System.arraycopy(arr, midIndex + 1, arr2, 0, arr2Length);

        // Merge the 2 arrays (arr1 & arr2) by sorting them into arr
        int i = 0, j = 0, k = startIndex;
        while(i < arr1Length && j < arr2Length) {
            if(arr1[i] < arr2[j]) {
                arr[k++] = arr1[i++];
            } else {
                arr[k++] = arr2[j++];
            }
        }

        while(i < arr1Length) {
            arr[k++] = arr1[i++];
        }

        while(j < arr2Length) {
            arr[k++] = arr2[j++];
        }
    }

    public void sort(int[] arr, int startIndex, int endIndex) {
        // Split the arrays into half until it contains only one element, then merge them into a sorted array
        if(startIndex == endIndex) {
            return;
        }

        int midIndex = (startIndex + endIndex) / 2;

        sort(arr, startIndex, midIndex);
        sort(arr, midIndex + 1, endIndex);
        merge(arr, startIndex, midIndex, endIndex);
    }

    public void applyMergeSort(int[] arr) {
        sort(arr, 0, arr.length-1);
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");

        int[] arr = new int[inputs.length];
        for(int i=0; i<inputs.length; ++i) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        new MergeSort().applyMergeSort(arr);

        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
