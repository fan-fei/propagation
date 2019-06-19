package sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int arr[] = new int[] { 10, 9, 4, 7, 3, 3, 5, 6, 1, 0, 56, 56, 7, 8, 8, 234, 23, 44, 4, 4, 7, 67 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int arr[]) {

        int max = arr[0];
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }

        int radix = 1;

        while (radix <= max) {

            int buckets[][] = new int[10][0];

            for (int i : arr) {
                int index = i / radix % 10;
                buckets[index] = Arrays.copyOf(buckets[index], buckets[index].length + 1);
                buckets[index][buckets[index].length - 1] = i;
            }

            int arrIndex = 0;
            for (int i = 0; i < buckets.length; i++) {
                for (int j = 0; j < buckets[i].length; j++) {
                    arr[arrIndex++] = buckets[i][j];
                }
            }

            radix *= 10;
        }

    }

}
