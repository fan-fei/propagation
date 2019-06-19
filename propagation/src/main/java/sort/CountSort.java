package sort;

import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) {
        int arr[] = new int[] { 10, 9, 4, 7, 3, 3, 5, 6, 1, 0, 56, 56, 7, 8, 8, 234, 23, 44, 4, 4, 7, 67 };
        sort(arr);

        System.out.println(Arrays.toString(arr));

    }

    private static void sort(int arr[]) {
        int min = arr[0];
        int max = arr[0];
        for (int i : arr) {
            if (min > i) {
                min = i;
            }
            if (max < i) {
                max = i;
            }
        }

        int offset = max - min;
        int countArr[] = new int[offset + 1];

        for (int i = 0; i < arr.length; i++) {
            countArr[arr[i] - min] += 1;
        }

        int k = 0;
        for (int i = 0; i < countArr.length; i++) {
            for (int j = 0; j < countArr[i]; j++) {
                arr[k++] = i + min;
            }
        }

    }

}
