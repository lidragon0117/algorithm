package com.lilong.代码随想录.回溯问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :lilong
 * @date :2023-09-17-14:23
 * @description : 回溯问题
 */
public class CombineBackFour {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();

    /**
     * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
     * <p>
     * candidates 中的每个数字在每个组合中只能使用一次。
     * <p>
     * 说明： 所有数字（包括目标数）都是正整数。解集不能包含重复的组合。
     *
     * @param candidates 数组
     * @param target     和
     * @return
     */

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        combineBack(candidates, target, 0, 0);
        return res;
    }

    private void combineBack(int[] candidates, int target, int startIndex, int sum) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        //回溯
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) {
                break;
            }
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum += candidates[i];
            path.add(candidates[i]);
            combineBack(candidates, target, i + 1, sum);
            Integer lastPath = path.get(path.size() - 1);
            sum -= lastPath;
            path.remove(path.size() - 1);
        }
    }
}
