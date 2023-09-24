package com.lilong.代码随想录.动态规划;

/**
 * @author :lilong
 * @date :2023-09-24-9:51
 * @description : 动态规划 不同二叉搜索树
 */
public class NumTrees {
    /**
     * @param n
     * @return
     */
    public int numTrees(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i] = dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}
