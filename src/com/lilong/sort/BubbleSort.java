package com.lilong.sort;

import com.lilong.utils.PrintUtils;

/**
 * @author :lilong
 * @date :2023-09-07-10:07
 * @description : 冒泡排序
 */
public class BubbleSort {
    public static void main(String[] args) {
        new BubbleSort().bubbleSort(new int[]{2, 3, 6, 8, 1, 7, 0, 6});
    }

    public void bubbleSort(int[] nums) {
        int temp;
        //设置标记
        boolean flag = true;
        //冒泡遍历
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    flag = false;
                    temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
            if (flag) {
                break;
            }
        }
        PrintUtils.printSort(nums);
    }
}
