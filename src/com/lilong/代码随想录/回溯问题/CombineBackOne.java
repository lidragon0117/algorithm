package com.lilong.代码随想录.回溯问题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :lilong
 * @date :2023-09-17-12:35
 * @description : 回溯问题
 */
public class CombineBackOne {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * <p>
     * 示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]
     */
    public List<List<Integer>> combine(int n, int k) {
        combineBack(n,k,1);
        return res;
    }

    private void combineBack(int n, int k, int startIndex) {
        //先判断结束
        if(path.size()==k){
            //进行保存
            res.add(new ArrayList<>(path));
            return;
        }
        //进行回溯
        for(int i=startIndex;i<n-(k-path.size())+1;i++){
            path.add(i);
            combineBack(n,k,i+1);
            path.removeLast();
        }
    }
}
