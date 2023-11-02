package com.lilong.代码随想录.面试;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : lilong
 * @date : 2023-10-31 14:32
 * @description :
 */
class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}

public class Cloud {
    //返回结果
    List<List<Integer>> results = new ArrayList<List<Integer>>();
    List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> pathFindList(TreeNode root, Integer target) {
        if (root == null) {
            return results;
        }
        path.add(root.val);
        if (root.left == null && root.right == null && target == root.val) {
            results.add(new ArrayList<>(path));
        }
        if (root.val <= target && root.left != null) {
            pathFindList(root.left, target - root.val);
        }
        if (root.val <= target && root.right != null) {
            pathFindList(root.right, target - root.val);
        }
        path.remove(path.size() - 1);
        return results;
    }
}
