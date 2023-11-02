package com.lilong.牛客;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : lilong
 * @date : 2023-11-02 20:05
 * @description :
 */
public class MinNumberDisappeared {
    /**
     * 给定一个无重复元素的整数数组nums，请你找出其中没有出现的最小的正整数
     * 进阶： 空间复杂度 O(1)，时间复杂度 O(n)
     */
    public int minNumberDisappeared(int[] nums) {
        // write code here
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int res = 1;
        while (set.contains(res)) {
            res++;
        }
        return res;
    }

}
