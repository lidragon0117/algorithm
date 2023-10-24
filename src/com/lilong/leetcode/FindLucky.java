package com.lilong.leetcode;

import java.util.*;

/**
 * @author :lilong
 * @date :2023-10-09-21:12
 * @description : 发现幸运数
 */
public class FindLucky {
    /**
     * 在整数数组中，如果一个整数的出现频次和它的数值大小相等，我们就称这个整数为「幸运数」。
     * 给你一个整数数组 arr，请你从中找出并返回一个幸运数。
     * 如果数组中存在多个幸运数，只需返回 最大 的那个。
     * 如果数组中不含幸运数，则返回 -1
     *
     * @param arr 数组
     * @return 返回值
     */
    public int findLucky(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        List list=new ArrayList();

        int ans = -1;
        Set<Integer> set = new HashSet<Integer>();
        for (Map.Entry<Integer, Integer> val : map.entrySet()) {
            if (Objects.equals(val.getKey(), val.getValue())) {
                ans = Math.max(val.getValue(), ans);
            }
        }
        return ans;
    }
}
