package com.lilong.代码随想录.动态规划;

/**
 * @author :lilong
 * @date :2023-09-28-13:25
 * @description : 最大连续子列表的和
 */
public class MaxSubArray {
    /**
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        int result = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
            result = result > dp[i] ? result : dp[i];
        }
        return result;
    }
}
