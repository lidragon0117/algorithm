package com.lilong.代码随想录.图;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :lilong
 * @date :2023-10-10-20:25
 * @description : 图 所有路径的可能
 */
public class AllPathsSourceTarget {
    List<List<Integer>> result;
    List<Integer> ans;
    public void dfs(int[][] graph, int node) {
        if (graph.length - 1 == node) {
            result.add(new ArrayList<>(ans));
        }
        //
        for (int i = 0; i < graph[node].length; i++){
            int nodeValue=graph[node][i];
            ans.add(nodeValue);
            dfs(graph,nodeValue);
            ans.remove(ans.size()-1);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        result = new ArrayList<>();
        ans = new ArrayList<>();
        ans.add(0);			// 注意，0 号节点要加入 cnt 数组中
        dfs(graph, 0);
        return result;
    }
}
