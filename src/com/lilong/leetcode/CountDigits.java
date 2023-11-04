package com.lilong.leetcode;

/**
 * @author : lilong
 * @date : 2023-11-04 21:46
 * @description :
 */
public class CountDigits {
    /**
     * 给你一个整数 num ，返回 num 中能整除 num 的数位的数目。
     * <p>
     * 如果满足 nums % val == 0 ，则认为整数 val 可以整除 nums 。
     * 示例 1：
     * 输入：num = 7
     * 输出：1
     * 解释：7 被自己整除，因此答案是 1 。
     *
     * @param num
     * @return
     */
    public int countDigits(int num) {
        int numNew = num;
        int count = 0;
        while (numNew != 0) {
            if (num % (numNew % 10) == 0) {
                count++;
            }
            numNew /= 10;
        }
        return count;
    }
}
