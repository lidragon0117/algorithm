package com.lilong.utils;

/**
 * @author :lilong
 * @date :2023-09-07-10:12
 * @description : 输出工具类
 */
public class PrintUtils {
    /**
     * 输出排序
     * @param nums 数组
     */
    public static void printSort(int[] nums){
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
