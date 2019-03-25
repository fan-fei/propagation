package sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = new int[] { 10, 9, 8, 7, 3, 3, 5, 4, 1, 2 };
        sort(arr);
    }

    private static void sort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length  - i; j++) {
                if (arr[j-1] > arr[j]) {
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(arr.length);

    }
}
