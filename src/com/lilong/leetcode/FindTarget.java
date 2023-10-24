package com.lilong.leetcode;



import java.util.ArrayList;
import java.util.List;

/**
 * @author :lilong
 * @date :2023-10-09-22:31
 * @description :
 */
public class FindTarget {
    public static void main(String[] args) {
    }
    List<Integer> list=new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        findTree(root,list);
        for(int i=0;i<list.size();i++){
            if(list.contains(k-list.get(i))){
                return true;
            }
        }
        return false;
    }
    public void findTree(TreeNode root,List<Integer> list){
        if(root==null){
            return;
        }

        list.add(root.val);
        findTree(root.left,list);
        findTree(root.right,list);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left,TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
