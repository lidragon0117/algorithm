package com.lilong.sort;

import com.lilong.utils.PrintUtils;

/**
 * @author :lilong
 * @date :2023-09-07-10:36
 * @description :选择排序
 */
public class SelectSort {
    public static void main(String[] args) {
        new SelectSort().selectSort(new int[]{2, 3, 6, 8, 1, 7, 0, 6});
    }

    /**
     * 选择排序
     *
     * @param nums 排序数组
     */
    public void selectSort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            // 记录
            int min = nums[i];
            int minIndex = i;
            //前面排好序之后就不用排序
            for (int j = i + 1; j < nums.length; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            if (i != minIndex) {
                nums[minIndex] = nums[i];
                nums[i] = min;
            }
        }
        PrintUtils.printSort(nums);
    }
}
