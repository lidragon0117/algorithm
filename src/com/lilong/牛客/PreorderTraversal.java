package com.lilong.牛客;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lilong
 * @date : 2023-11-02 20:28
 * @description : 前序遍历
 */
public class PreorderTraversal {
    /**
     * 树的前序遍历 递归的方式
     */
    List<Integer> list = new ArrayList<Integer>();
    public int[] preorderTraversal(TreeNode root) {
        // write code here
        preorder(list, root);
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void preorder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorder(list, root.left);
        preorder(list, root.right);
    }
}
