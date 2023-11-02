package com.lilong.牛客;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : lilong
 * @date : 2023-11-02 20:58
 * @description : 之字形打印
 */
public class ZhiPrint {
    /**
     * 给定一个二叉树，返回该二叉树的之字形层序遍历，（第一层从左向右，下一层从右向左，一直这样交替）
     * 输入：
     * {1,2,3,#,#,4,5}
     * 返回值：
     * [[1],[3,2],[4,5]]
     * 说明：
     * 如题面解释，第一层是根节点，从左到右打印结果，第二层从右到左，第三层从左到右。
     *
     * @param pRoot 树的根
     * @return 返回值
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (pRoot == null) {
            return result;
        }
        queue.add(pRoot);
        boolean flag = true;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            flag = !flag;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (flag) {
                Collections.reverse(list);
            }
            result.add(list);
        }
        return result;
    }
}
