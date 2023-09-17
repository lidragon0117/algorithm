package com.lilong.sort;

/**
 * @author :lilong
 * @date :2023-09-07-13:14
 * @description : 快速排序
 */
public class QuickSort {
    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    /**
     * 快速排序
     *
     * @param arr   数组
     * @param left  左边
     * @param right 右边界
     */
    private void quickSort(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }
        //将数组分为两部分
        int mid = partition(arr, left, right);
        quickSort(arr, left, mid);
        quickSort(arr, mid + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        //基准
        int pivot = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            //交换小的值
            arr[left] = arr[right];
            while (left < right && arr[left] < pivot) {
                left++;
            }
            //交换大的值
            arr[right] = arr[left];
        }
        //扫描完成，基准到位
        arr[left] = pivot;
        //返回的是基准的位置
        return left;
    }
}
