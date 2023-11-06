package com.lilong.面试;

/**
 * @author :lilong
 * @date :2023-10-15-19:31
 * @description :
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 8, 2, 5, 1, 4, 7, 6};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
//  有且只有一对，三张顺子，三张，三张    10张扑克牌   四张朝上
    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        while (low < high) {
            while (low < high && arr[high] <= pivot) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] >= pivot) {
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}



