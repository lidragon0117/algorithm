package com.lilong.代码随想录.回溯问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :lilong
 * @date :2023-09-17-16:09
 * @description : 回溯问题
 */
public class SubsetTwo {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        //去重的话就排序
        Arrays.sort(nums);
        subsetBack(nums, 0);
        return res;
    }

    private void subsetBack(int[] nums, int startIndex) {
        //定义出口
        res.add(new ArrayList<>(path));
        for (int i = startIndex; i < nums.length; i++) {
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            subsetBack(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
