package com.lilong.代码随想录.回溯问题;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :lilong
 * @date :2023-09-17-16:48
 * @description : 回溯问题
 */
public class FullPermutation {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        fullPermuteBack(nums);
        return res;
    }

    private void fullPermuteBack(int[] nums) {
        if(path.size()==nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(path.contains(nums[i])){
                continue;
            }
            path.add(nums[i]);
            fullPermuteBack(nums);
            path.remove(path.size()-1);
        }
    }
}
