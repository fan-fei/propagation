package sort;

import java.util.Arrays;

public class CountSort {

    public static void main(String[] args) {
        int arr[] = new int[] { 10, 9, 4, 7, 5, 5, 6, 1, 0, 2 };
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
        
        

    }

}
