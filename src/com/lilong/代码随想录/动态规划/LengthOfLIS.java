package com.lilong.代码随想录.动态规划;

import java.util.Arrays;

/**
 * @author :lilong
 * @date :2023-09-28-10:01
 * @description : 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * 示例 1：
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 */
public class LengthOfLIS {
    /**
     * 寻找最长连续子数组的长度
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[i - 1] + 1);
                }
            }
        }
        return dp[nums.length - 1];
    }
}
