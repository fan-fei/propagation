package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = new int[] { 10, 9, 4, 7, 3, 3, 5, 6, 1, 0 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int arr[]) {

    }

    private static int[] merge(int left[], int right[]) {
        int leftIndex = 0;
        int rightIndex = 0;
        int mergeIndex = 0;

        int merge[] = new int[left.length + right.length];

        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] < right[rightIndex]) {
                merge[mergeIndex] = left[leftIndex];
                leftIndex++;
            } else {
                merge[mergeIndex] = right[rightIndex];
                rightIndex++;
            }
            mergeIndex++;
        }

        if (leftIndex == left.length - 1) {
            System.arraycopy(right, rightIndex, merge, mergeIndex, merge.length - mergeIndex);
        }

        return merge;

    }

}
