package com.lilong.代码随想录.回溯问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :lilong
 * @date :2023-09-17-14:04
 * @description : 回溯问题
 */
public class CombineBackThree {
    List<Integer> path=new LinkedList<>();
    List<List<Integer>> res=new ArrayList<>();
    /**
     * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
     * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
     * <p>
     * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
     *
     * @param candidates 数组
     * @param target     结果
     * @return 返回值
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 先进行排序
        Arrays.sort(candidates);
        combineSum(candidates,target,0,0);
        return res;
    }

    private void combineSum(int[] candidates, int target, int startIndex, int sum) {
        //判断结束
        if(sum==target){
            res.add(new ArrayList<>(path));
            return;
        }
        //进行回溯函数
        for(int i=startIndex;i<candidates.length;i++){
            path.add(candidates[i]);
            combineSum(candidates,target,i,sum+candidates[i]);
            path.remove(path.size()-1);
        }
    }
}
