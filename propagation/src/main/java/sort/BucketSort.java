package sort;

import java.util.Arrays;

public class BucketSort {
    public static void main(String[] args) {
        int arr[] = new int[] { 10, 9, 4, 7, 3, 3, 5, 6, 1, 0, 56, 56, 7, 8, 8, 234, 23, 44, 4, 4, 7, 67 };
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

        int bucketCount = (int) Math.sqrt(arr.length);
        int buckets[][] = new int[bucketCount][0];

        for (int i : arr) {
            int inhanceIndex = (i - min) * bucketCount / (max - min + 1);
            buckets[inhanceIndex] = Arrays.copyOf(buckets[inhanceIndex], buckets[inhanceIndex].length + 1);
            buckets[inhanceIndex][buckets[inhanceIndex].length - 1] = i;
        }

        for (int[] bucket : buckets) {
            shellSort(bucket);
        }

        int arrIndex = 0;
        for (int i = 0; i < buckets.length; i++) {
            for (int j = 0; j < buckets[i].length; j++) {
                arr[arrIndex++] = buckets[i][j];
            }
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
