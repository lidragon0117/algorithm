package com.lilong.代码随想录.动态规划;

/**
 * @author :lilong
 * @date :2023-09-23-22:29
 * @description : 动态规划
 */
public class Fib {

    public int fib(int n) {
        if (n < 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
