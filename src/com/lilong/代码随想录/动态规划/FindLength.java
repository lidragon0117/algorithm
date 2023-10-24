package com.lilong.代码随想录.动态规划;

/**
 * @author :lilong
 * @date :2023-09-28-11:02
 * @description : 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 * 示例 1：
 * 输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
 */
public class FindLength {
    /**
     * 计算出公共长度
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        int result = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i][j] = dp[i - 1][j - 1];
                    result = Math.max(dp[i][j], result);
                }
            }
        }
        return result;
    }
}
