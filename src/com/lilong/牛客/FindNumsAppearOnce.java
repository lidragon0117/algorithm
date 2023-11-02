package com.lilong.牛客;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author : lilong
 * @date : 2023-11-02 19:56
 * @description :
 */
public class FindNumsAppearOnce {
    /**
     * 一个整型数组里除了两个数字只出现一次，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
     * <p>
     * 数据范围：数组长度
     * 2
     * ≤
     * �
     * ≤
     * 1000
     * 2≤n≤1000，数组中每个数的大小
     * 0
     * <
     * �
     * �
     * �
     * ≤
     * 1000000
     * 0<val≤1000000
     * 要求：空间复杂度
     * �
     * (
     * 1
     * )
     * O(1)，时间复杂度
     * �
     * (
     * �
     * )
     * O(n)
     * <p>
     * 提示：输出时按非降序排列。
     *
     * @param nums
     * @return
     */
    public int[] FindNumsAppearOnce(int[] nums) {
        // write code here
        int[] result = new int[2];
        Set<Integer> map = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.contains(nums[i])) {
                map.remove(nums[i]);
            } else {
                map.add(nums[i]);
            }
        }
        int i = 0;
        for (Integer integer : map) {
            result[i++] = integer;
        }
        return result;
    }
}
