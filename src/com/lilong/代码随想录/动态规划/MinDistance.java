package com.lilong.代码随想录.动态规划;

/**
 * @author :lilong
 * @date :2023-09-28-14:32
 * @description :
 */
public class MinDistance {
    /**
     * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
     * 每步 可以删除任意一个字符串中的一个字符。
     * 示例 1：
     * 输入: word1 = "sea", word2 = "eat"
     * 输出: 2
     * 解释: 第一步将 "sea" 变为 "ea" ，第二步将 "eat "变为 "ea"
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i < word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < word2.length(); j++) {
            dp[0][j] =j;
        }
        for (int i = 0; i < dp.length; i++){

        }
        return 0;
    }
}
