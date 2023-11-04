package com.lilong.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : lilong
 * @date : 2023-11-04 21:25
 * @description :
 */
public class FindMaximumXOR {
    /**
     * 给你一个整数数组 nums ，返回 nums[i] XOR nums[j] 的最大运算结果，其中 0 ≤ i ≤ j < n 。
     * 示例 1：
     * 输入：nums = [3,10,5,25,2,8]
     * 输出：28
     * 解释：最大运算结果是 5 XOR 25 = 28.
     */
    public int findMaximumXOR(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int maxNum = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                maxNum = Math.max(nums[i] ^ nums[j], maxNum);
            }
        }
        return maxNum;
    }

    /**
     * 这一个才是标准的
     *
     * @param nums
     * @return
     */
    public int findMaximumXOR1(int[] nums) {
        int max = 0;
        for (int x : nums) {
            max = Math.max(max, x);
        }
        int highBit = 31 - Integer.numberOfLeadingZeros(max);

        int ans = 0, mask = 0;
        Set<Integer> seen = new HashSet<>();
        for (int i = highBit; i >= 0; i--) { // 从最高位开始枚举
            seen.clear();
            mask |= 1 << i;
            int newAns = ans | (1 << i); // 这个比特位可以是 1 吗？
            for (int x : nums) {
                x &= mask; // 低于 i 的比特位置为 0
                if (seen.contains(newAns ^ x)) {
                    ans = newAns; // 这个比特位可以是 1
                    break;
                }
                seen.add(x);
            }
        }
        return ans;
    }
}



