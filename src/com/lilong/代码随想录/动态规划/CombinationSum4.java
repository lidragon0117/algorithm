package com.lilong.代码随想录.动态规划;

/**
 * @author :lilong
 * @date :2023-09-24-16:40
 * @description : 动态规划 组合总数IV
 * 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
 * <p>
 * 如果求排列数就是外层for遍历背包，内层for循环遍历物品。
 */
public class CombinationSum4 {
    /**
     * 给定一个由 不同 正整数组成的数组 nums ，和一个目标整数 target 。请从 nums 中找出并返回总和为 target 的元素组合的个数。数组中的数字可以在一次排列中出现任意次，但是顺序不同的序列被视作不同的组合。
     * 题目数据保证答案符合 32 位整数范围。
     * 示例 1：
     * 输入：nums = [1,2,3], target = 4
     * 输出：7
     * 解释：
     * 所有可能的组合为：
     * (1, 1, 1, 1)
     * (1, 1, 2)
     * (1, 2, 1)
     * (1, 3)
     * (2, 1, 1)
     * (2, 2)
     * (3, 1)
     * 请注意，顺序不同的序列被视作不同的组合。
     *
     * @param nums   数组
     * @param target 目标数
     * @return 返回的个数
     * <p>
     * 如果求组合数就是外层for循环遍历物品，内层for遍历背包。
     * 如果求排列数就是外层for遍历背包，内层for循环遍历物品。
     */
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 1; j <= nums.length; j++) {
                dp[i] += dp[i - nums[j]];
            }
        }
        return dp[target];
    }
}
