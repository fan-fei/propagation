package sort;

import java.util.Arrays;

public class BucketSort {
    public static void main(String[] args) {
        int arr[] = new int[] { 10, 9, 4, 7, 3, 3, 5, 6, 1, 0 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int arr[]) {
        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            if (i < min) {
                min = i;
            } else if (i > max) {
                max = i;
            }
        }
        int distance = max - min;

        int bucket[][] = new int[arr.length / 4 + 1][arr.length];
        int gap = distance - arr.length / 4;

        for (int i : arr) {
            int inhanceIndex = i - min / 4 - 1;
        }

    }

    private static void shellSort(int arr[]) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < arr.length; i += gap) {
                for (int j = i - gap; j >= 0; j -= gap) {
                    if (arr[j] > arr[j + gap]) {
                        int temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
