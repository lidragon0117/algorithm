package com.lilong.代码随想录.回溯问题;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author :lilong
 * @date :2023-09-17-16:18
 * @description : 回溯问题
 */
public class IncreasingSubsequence {
    List<Integer> path=new ArrayList<>();
    List<List<Integer>> res=new ArrayList<>();
    /**
     * 给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
     * <p>
     * 示例:
     * <p>
     * 输入: [4, 6, 7, 7]
     * 输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        findSubsequencesBack(nums,0);
        return res;
    }

    private void findSubsequencesBack(int[] nums, int startIndex) {
        if(path.size()>1){
            res.add(new ArrayList<>(path));
        }
        Map<Integer,Integer> map =new HashMap<>();
        for(int i=startIndex;i<nums.length;i++){
            if(!path.isEmpty() && nums[i]<path.get(path.size()-1)){
                continue;
            }
            if(map.getOrDefault(nums[i],0)>=1){
                continue;
            }
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            path.add(nums[i]);
            findSubsequencesBack(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}
