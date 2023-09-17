package com.lilong.代码随想录.回溯问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :lilong
 * @date :2023-09-17-15:10
 * @description : 回溯问题
 */
public class Subset {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    /**
     * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     *
     * @param nums 数组
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        subsetsBack(nums, 0);
        return res;
    }

    private void subsetsBack(int[] nums, int startIndex) {
        res.add(new ArrayList<>(path));
        if (startIndex > nums.length) {
            return;
        }
        //回溯
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            subsetsBack(nums, i + 1);
            path.remove(path.size() - 1);
        }

    }
}
