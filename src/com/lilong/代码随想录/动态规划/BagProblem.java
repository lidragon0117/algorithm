package com.lilong.代码随想录.动态规划;

import java.util.Arrays;

/**
 * @author :lilong
 * @date :2023-09-24-11:02
 * @description : 动态规划  背包问题
 */
public class BagProblem {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagSize = 4;
        bagProblem(weight, value, bagSize);
    }

    /**
     * 解题思路：
     *
     * @param values  价值
     * @param weight  重量
     * @param bagSize 背包的最大容量
     */
    public static void bagProblem(int[] values, int[] weight, int bagSize) {
        //初始化背包容量和价值成一个二维数组 默认初始值都是 0
        int[][] dp = new int[weight.length + 1][bagSize + 1];
        //进行填充
        for (int i = 1; i <= weight.length; i++) {
            for (int j = 1; j <= bagSize; j++) {
                if (j < weight[i-1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i-1]] + values[i-1]);
                }
            }
        }
        // 打印dp数组
        for (int[] arr : dp) {
            System.out.println(Arrays.toString(arr));
        }
    }
}
