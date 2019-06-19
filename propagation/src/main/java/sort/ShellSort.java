package sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int arr[] = new int[] { 10, 9, 4, 7, 3, 3, 5, 6, 1, 0, 56, 56, 7, 8, 8, 234, 23, 44, 4, 4, 7, 67 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int arr[]) {

        for (int k = arr.length / 2; k > 0; k /= 2) {
            for (int i = 0; i < arr.length; i += k) {
                for (int j = i - k; j >= 0; j -= k) {
                    if (arr[j] > arr[j + k]) {
                        int temp = arr[j];
                        arr[j] = arr[j + k];
                        arr[j + k] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }
}
