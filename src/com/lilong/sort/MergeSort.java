package com.lilong.sort;

/**
 * @author :lilong
 * @date :2023-09-07-12:44
 * @description : 归并排序
 */
public class MergeSort {
    /**
     * 归并排序
     *
     * @param nums 数组
     */
    public void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        internalMergeSort(nums, temp, 0, nums.length - 1);
    }

    private void internalMergeSort(int[] nums, int[] temp, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            internalMergeSort(nums, temp, left, mid);
            internalMergeSort(nums, temp, mid + 1, right);
            mergeSortedArray(nums, temp, left, mid, right);
        }
    }

    /**
     * 进行合并排序
     *
     * @param nums  数组
     * @param temp  临时数组
     * @param left  左边界
     * @param mid   中间值
     * @param right 右边界
     *
     */
    private void mergeSortedArray(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = nums[i] < nums[j] ? nums[i++] : nums[j++];
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= right) {
            temp[k++] = nums[j++];
        }
        // 把temp数据复制回原数组
        for (i = 0; i < k; i++) {
            nums[left + i] = temp[i];
        }
    }
}
