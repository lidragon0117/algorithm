package com.lilong.代码随想录.面试;

/**
 * @author :lilong
 * @date :2023-09-18-14:05
 * @description :
 */
public class TestDemo1 {
    public static void main(String[] args) {
        System.out.println(Math.ceil(-4.01));
        new TestDemo1().deleteIsExist(new int[]{0,0,1,1,1,2,2,3,3,4});
    }
    /**
     * 给定一个整形数组 nums，固定升序排列，请你删除重复元素，返回删除后数组的新长度。
     * 输入例子：
     * 0,0,1,1,1,2,2,3,3,4
     * 输出例子：5
     *
     * @param nums 数组
     */
    public void deleteIsExist(int[] nums) {
        int left=0;
        int right=1;
        while(right< nums.length){
            if(nums[left]!=nums[right]){
               nums[left+1]=nums[right];
               left++;
            }
            right++;
        }
        System.out.println(left+1);
    }
}
