package com.lilong.牛客;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lilong
 * @date : 2023-11-02 20:41
 * @description : 后序遍历
 */
public class PostorderTraversal {

    List<Integer> list = new ArrayList<>();

    public int[] postorderTraversal(TreeNode root) {
        // write code here
        postOrder(list, root);
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private void postOrder(List<Integer> list, TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(list, root.left);
        postOrder(list, root.right);
        list.add(root.val);
    }
}
