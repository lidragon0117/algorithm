package com.lilong.leetcode;

/**
 * @author :lilong
 * @date :2023-09-27-22:28
 * @description : 给你两个字符串 word1 和 word2 。请你从 word1 开始，
 * 通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * 返回 合并后的字符串 。
 * 示例 1：
 * <p>
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 */
public class MergeAlternately {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int left = 0;
        int right = 0;
        while (left < word1.length() || right < word2.length()) {
            if (left < word1.length()) {
                sb.append(word1.charAt(left));
                left++;
            }
            if (right < word2.length()) {
                sb.append(word2.charAt(right));
                right++;
            }
        }
        return sb.toString();
    }
}
