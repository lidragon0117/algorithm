package com.lilong.牛客;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author : lilong
 * @date : 2023-11-02 21:25
 * @description :
 */
public class MaxDepth {
    /**
     * 求给定二叉树的最大深度，
     * 深度是指树的根节点到任一叶子节点路径上节点的数量。
     * 最大深度是所有叶子节点的深度的最大值
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        // write code here
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result++;
        }
        return result;
    }
}
