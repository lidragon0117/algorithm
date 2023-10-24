package com.lilong.代码随想录.面试;

import java.util.Arrays;

/**
 * @author :lilong
 * @date :2023-10-13-15:33
 * @description :
 */


public class 实习 {

    /**
     * 题目：寻找缺失的数字
     * 描述：给定一个包含 0 到 n 的整数数组 nums，其中数字在范围 [0, n] 内。数组中有且只有一个数字在该范围内缺失，
     * 请编写一个函数找出缺失的数字。
     * 要求：你的算法应具有线性时间复杂度和常数级空间复杂度。
     * 函数签名：public int findMissingNumber(int[] nums)
     * 示例：
     * 输入：[3, 0, 1]
     * 输出：2
     * 解释：数组中缺失的数字是2。
     * 输入：[9, 6, 4, 2, 3, 5, 7, 0, 1]
     * 输出：8
     * 解释：数组中缺失的数字是8。
     * 请编写函数 findMissingNumber 的实现来解决这个问题。
     *
     * @param
     */
    public static void findMissingNumber(int[] nums) {
        Arrays.sort(nums);
        int flag = 0;
        for (int i = 0; i < nums.length; i++) {
            if (flag != nums[i]) {
                System.out.println(flag);
            }
            flag++;
        }
    }


    public static String reverseString(String s) {
        char[] chars = s.toCharArray();
        int left = 0,
                right = chars.length - 1;
        while (left <= right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    public static void main(String[] args) {


    }
}
