package sort;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {
        int arr[] = new int[] { 10, 9, 4, 7, 3, 3, 5, 6, 1, 0, 56, 56, 7, 8, 8, 234, 23, 44, 4, 4, 7, 67 };
        sort(arr);

        System.out.println(Arrays.toString(arr));

    }

    private static void sort(int arr[]) {
        int lastIndex = arr.length - 1;

        for (int currentIndex = (lastIndex - 1) / 2; currentIndex >= 0; currentIndex--) {
            upDownSwap(arr, currentIndex, lastIndex);
        }

        while (lastIndex > 0) {
            int temp = arr[lastIndex];
            arr[lastIndex] = arr[0];
            arr[0] = temp;

            lastIndex--;
            upDownSwap(arr, 0, lastIndex);
        }
    }

    private static void upDownSwap(int[] arr, int currentIndex, int lastIndex) {
        int leftIndex = currentIndex * 2 + 1;
        int rightIndex = currentIndex * 2 + 2;

        if (leftIndex <= lastIndex && arr[currentIndex] < arr[leftIndex]) {
            int temp = arr[currentIndex];
            arr[currentIndex] = arr[leftIndex];
            arr[leftIndex] = temp;

            upDownSwap(arr, leftIndex, lastIndex);
        }

        if (rightIndex <= lastIndex && arr[currentIndex] < arr[rightIndex]) {
            int temp = arr[currentIndex];
            arr[currentIndex] = arr[rightIndex];
            arr[rightIndex] = temp;

            upDownSwap(arr, rightIndex, lastIndex);
        }
    }
}
