package sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = new int[] { 10, 9, 4, 7, 3, 3, 5, 6, 1, 0, 56, 56, 7, 8, 8, 234, 23, 44, 4, 4, 7, 67 };
        System.out.println(Arrays.toString(quickSort(arr)));
    }

    private static int[] quickSort(int arr[]) {

        if (arr.length < 2) {
            return arr;
        }

        int pivot = arr[0];

        int[] left = new int[arr.length];
        int[] right = new int[arr.length];

        int leftIndex = 0;
        int rightIndex = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < pivot) {
                left[leftIndex] = arr[i];
                leftIndex++;
            } else {
                right[rightIndex] = arr[i];
                rightIndex++;
            }
        }

        left[leftIndex] = pivot;
        int[] finalLeft = new int[++leftIndex];
        int[] finalRight = new int[rightIndex];

        System.arraycopy(left, 0, finalLeft, 0, finalLeft.length);

        System.arraycopy(right, 0, finalRight, 0, finalRight.length);

        int[] merged = new int[arr.length];

        System.arraycopy(quickSort(finalLeft), 0, merged, 0, leftIndex);
        System.arraycopy(quickSort(finalRight), 0, merged, leftIndex, rightIndex);

        return merged;

    }

}
