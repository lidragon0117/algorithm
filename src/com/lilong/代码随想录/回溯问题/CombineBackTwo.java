package com.lilong.代码随想录.回溯问题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :lilong
 * @date :2023-09-17-13:10
 * @description : 回溯优化
 */
public class CombineBackTwo {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
     * <p>
     * 只使用数字1到9
     * 每个数字 最多使用一次
     * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
     *
     * @param n 总数
     * @param k 个数
     */
    public void combine(int n, int k) {
        combineBack(n, k, 1, 0);
    }

    private void combineBack(int n, int k, int startIndex, int sum) {
        //进行剪枝
        if (sum > n) {
            return;
        }
        //寻找结束条件
        if (path.size() == k) {
            if (sum == n) {
                res.add(new ArrayList<>(path));
            }
            return;
        }
        //回溯
        for (int i = startIndex; i <= 9 - (k - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            combineBack(n, k, i + 1, sum);
            path.removeLast();
            sum -= i;
        }
    }
}
