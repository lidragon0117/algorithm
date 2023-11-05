package com.lilong.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : lilong
 * @date : 2023-11-05 16:59
 * @description : 深度遍历
 */
public class DFSDemo {
    List<TreeNodes> treeList;

    public List<TreeNodes> dfs(TreeNodes root) {
        treeList = new ArrayList<TreeNodes>();
        if (root == null) {
            return null;
        }
        Stack<TreeNodes> stack = new Stack<TreeNodes>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNodes node = stack.pop();
            treeList.add(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        return treeList;
    }
}

class TreeNodes {

    int val;
    TreeNodes left;
    TreeNodes right;

    TreeNodes() {
    }

    TreeNodes(int val) {
        this.val = val;
    }

    TreeNodes(int val, TreeNodes left, TreeNodes right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

}
