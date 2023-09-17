package com.lilong.代码随想录.双指针;

/**
 * @author :lilong
 * @date :2023-09-16-21:18
 * @description : 双指针
 */
public class RemoveElement {
    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
     *
     * @param nums 数组
     * @param val 值
     */
    public void removeElement(int[] nums, int val) {
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]!=val){
                nums[left]=nums[right];
                left++;
            }
        }
    }
}
