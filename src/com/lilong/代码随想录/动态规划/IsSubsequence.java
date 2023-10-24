package com.lilong.代码随想录.动态规划;

/**
 * @author :lilong
 * @date :2023-09-28-13:49
 * @description : 判断是否是子序列
 */
public class IsSubsequence {
    /**
     * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
     * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。
     * （例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
     * 示例 1：
     * 输入：s = "abc", t = "ahbgdc"
     * 输出：true
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        if (dp[s.length()][t.length()] == s.length()) {
            return true;
        } else {
            return false;
        }
    }
}
