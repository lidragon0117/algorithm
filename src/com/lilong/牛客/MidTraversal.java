package com.lilong.牛客;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lilong
 * @date : 2023-11-02 20:37
 * @description : 树的中序遍历
 */
public class MidTraversal {
    /**
     * 树的中序遍历 递归的方式
     *
     * @param root
     * @return
     */
    List<Integer> list = new ArrayList<Integer>();

    public int[] inorderTraversal(TreeNode root) {
        // write code here
        inorderTra(list, root);
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void inorderTra(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        inorderTra(list, root.left);
        list.add(root.val);
        inorderTra(list, root.right);
    }
}
