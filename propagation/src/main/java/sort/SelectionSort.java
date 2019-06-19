package sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = new int[] { 10, 9, 4, 7, 3, 3, 5, 6, 1, 0, 56, 56, 7, 8, 8, 234, 23, 44, 4, 4, 7, 67 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
}
