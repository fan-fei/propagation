package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = new int[] { 10, 9, 4, 7, 3, 3, 5, 6, 1, 0 };
        System.out.println(Arrays.toString(divideAndMerge(arr)));
    }

    private static int[] divideAndMerge(int arr[]) {

        if (arr.length < 2) {
            return arr;
        }

        int leftLength = arr.length / 2;
        int[] left = new int[leftLength];
        int[] right = new int[arr.length - leftLength];
        System.arraycopy(arr, 0, left, 0, leftLength);
        System.arraycopy(arr, leftLength, right, 0, arr.length - leftLength);
        return merge(divideAndMerge(left), divideAndMerge(right));

    }

    private static int[] merge(int left[], int right[]) {
        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = 0;

        int merge[] = new int[left.length + right.length];

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                merge[mergeIndex] = left[leftIndex];
                leftIndex++;
            } else {
                merge[mergeIndex] = right[rightIndex];
                rightIndex++;
            }
            mergeIndex++;
        }

        if (leftIndex == left.length) {
            System.arraycopy(right, rightIndex, merge, mergeIndex, merge.length - mergeIndex);
        } else {
            System.arraycopy(left, leftIndex, merge, mergeIndex, merge.length - mergeIndex);
        }

        return merge;

    }

}
