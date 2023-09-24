package com.lilong.代码随想录.动态规划;

/**
 * @author :lilong
 * @date :2023-09-24-12:31
 * @description : 动态规划 背包问题优化 只用一维数组
 */
public class BagProblemTwo {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWight = 4;
        bagProblemTwo(weight, value, bagWight);
    }

    /**
     * 背包问题的优化，只用一维数组来存储 代替之前的二维数组
     *
     * @param weight  重量
     * @param values  价值
     * @param bagSize 背包大小
     */
    public static void bagProblemTwo(int[] weight, int[] values, int bagSize) {
        int[] dp = new int[bagSize + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagSize; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + values[i]);
            }
        }
        for (int d : dp) {
            System.out.print(d + " ");
        }
    }

}
