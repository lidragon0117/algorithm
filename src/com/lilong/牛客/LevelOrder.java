package com.lilong.牛客;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author : lilong
 * @date : 2023-11-02 20:44
 * @description : 层序遍历
 */
public class LevelOrder {
    /**
     * 层序遍历
     *
     * @param root 树的根
     * @return 返回结果
     */
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode nodeTemp = queue.poll();
                list.add(nodeTemp.val);
                if (nodeTemp.left != null) {
                    queue.add(nodeTemp.left);
                }
                if (nodeTemp.right != null) {
                    queue.add(nodeTemp.right);
                }
            }
            result.add(list);
        }
        return result;
    }
}
